package bo.edu.ucb.sis213;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodos {

    public static int id;
    public static double saldo;
    public static int pinActual;

    public boolean validarPIN(String usuario,int pinIngresado) 
    {   
        String query = "SELECT pin, id, saldo FROM usuario where nombre = ?";
        try {
            Connection con = Conexion.obtenerConexion();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, usuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pinActual  = resultSet.getInt("pin");
                id  = resultSet.getInt("id");
                saldo  = resultSet.getDouble("saldo");
                if(pinActual==pinIngresado)
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public String generacion(){
        String cad="Su saldo actual es de:\nBs."+saldo;
		return cad;
    }

    public void realizarDeposito(double cantidad) {
        Connection con = null;
        if (cantidad <= 0) {
            System.out.println("Cantidad no válida.");
        } else {
            try {
                con = Conexion.obtenerConexion();
                // Actualizar el saldo en la base de datos
                String updateQuery = "UPDATE usuarios SET saldo = saldo + ? WHERE id = ?";
                PreparedStatement updateStatement = con.prepareStatement(updateQuery);
                updateStatement.setDouble(1, cantidad);
                updateStatement.setInt(2, id);
                updateStatement.executeUpdate();
    
                // Registrar la operación en el historial
                String insertHistoricoQuery = "INSERT INTO historico (usuario_id, tipo_operacion, cantidad) VALUES (?, ?, ?)";
                PreparedStatement historicoStatement = con.prepareStatement(insertHistoricoQuery);
                historicoStatement.setInt(1, id);
                historicoStatement.setString(2, "depósito");
                historicoStatement.setDouble(3, cantidad);
                historicoStatement.executeUpdate();
    
                con.commit();
    
                saldo += cantidad;
                //System.out.println("Depósito realizado con éxito. Su nuevo saldo es: $" + saldo);
            } catch (SQLException e) {
                if (con != null) {
                    try {
                        con.rollback();
                    } catch (SQLException rollbackEx) {
                        rollbackEx.printStackTrace();
                    }
                }
                e.printStackTrace();
                System.out.println("Error al realizar el depósito.");
            } finally {
                if (con != null) {
                    try {
                        con.setAutoCommit(true);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void realizarRetiro(double cantidad) {
        Connection con = null;
        if (cantidad <= 0) {
            System.out.println("Cantidad no válida.");
        } else {
            try {
                con = Conexion.obtenerConexion();
                
                // Verificar si hay suficiente saldo para el retiro
                if (saldo >= cantidad) {
                    // Actualizar el saldo en la base de datos
                    String updateQuery = "UPDATE usuarios SET saldo = saldo - ? WHERE id = ?";
                    PreparedStatement updateStatement = con.prepareStatement(updateQuery);
                    updateStatement.setDouble(1, cantidad);
                    updateStatement.setInt(2, id);
                    updateStatement.executeUpdate();
        
                    // Registrar la operación en el historial
                    String insertHistoricoQuery = "INSERT INTO historico (usuario_id, tipo_operacion, cantidad) VALUES (?, ?, ?)";
                    PreparedStatement historicoStatement = con.prepareStatement(insertHistoricoQuery);
                    historicoStatement.setInt(1, id);
                    historicoStatement.setString(2, "retiro");
                    historicoStatement.setDouble(3, cantidad);
                    historicoStatement.executeUpdate();
        
                    con.commit();
        
                    saldo -= cantidad;
                    System.out.println("Retiro realizado con éxito. Su nuevo saldo es: $" + saldo);
                } else {
                    System.out.println("Saldo insuficiente para realizar el retiro.");
                }
            } catch (SQLException e) {
                if (con != null) {
                    try {
                        con.rollback();
                    } catch (SQLException rollbackEx) {
                        rollbackEx.printStackTrace();
                    }
                }
                e.printStackTrace();
                System.out.println("Error al realizar el retiro.");
            } finally {
                if (con != null) {
                    try {
                        con.setAutoCommit(true);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void cambiarPIN(int pinIngresado, int pinNuevo, int pinNuevoConf) {
        Connection con=null;
        if (pinIngresado == pinActual) {
            if (pinNuevo == pinNuevoConf) {
                try {
                    con = Conexion.obtenerConexion();
                    con.setAutoCommit(false);
    
                    String updateQuery = "UPDATE usuarios SET pin = ? WHERE id = ?";
                    PreparedStatement updateStatement = con.prepareStatement(updateQuery);
                    updateStatement.setInt(1, pinNuevo);
                    updateStatement.setInt(2, id);
                    updateStatement.executeUpdate();
    
                    con.commit();
                    pinActual = pinNuevo;
                    //System.out.println("PIN actualizado con éxito.");
                } catch (SQLException e) {
                    try {
                        con.rollback();
                    } catch (SQLException rollbackEx) {
                        rollbackEx.printStackTrace();
                    }
                    e.printStackTrace();
                    //System.out.println("Error al actualizar el PIN.");
                } finally {
                    try {
                        con.setAutoCommit(true);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                //System.out.println("Los PINs no coinciden.");
            }
        } else {
            //System.out.println("PIN incorrecto.");
        }
    }
}