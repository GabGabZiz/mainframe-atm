package bo.edu.ucb.sis213.BDO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasBDO {
    public int pin_Consulta(String usuario,int pinIngresado) 
    {   
        String query = "SELECT pin FROM usuarios where nombre = ?";
        int pinActual=0;
        try {
            Connection con = Conexion.obtenerConexion();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, usuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pinActual  = resultSet.getInt("pin");
                return pinActual;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pinActual;
    }
    public int id_Consulta(String usuario,int pinIngresado) 
    {   
        String query = "SELECT id FROM usuarios where nombre = ?";
        int id=0;
        try {
            Connection con = Conexion.obtenerConexion();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, usuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id  = resultSet.getInt("id");
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public int saldo_Consulta(int id) 
    {   
        String query = "SELECT saldo FROM usuarios where id = ?";
        int saldo=-1;
        try {
            Connection con = Conexion.obtenerConexion();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                saldo = resultSet.getInt("saldo");
                return saldo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saldo;
    }
    public void updatePin(int pinNuevo,int id) {
        Connection con=null;
        try {
            con = Conexion.obtenerConexion();
            con.setAutoCommit(false);
    
            String updateQuery = "UPDATE usuarios SET pin = ? WHERE id = ?";
            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setInt(1, pinNuevo);
            updateStatement.setInt(2, id);
            updateStatement.executeUpdate();
            con.commit();
        } 
        catch (SQLException e) {
            try {
                con.rollback();
            } 
            catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            System.out.println("Error al actualizar el PIN.");
        } 
        finally {
            try {
                con.setAutoCommit(true);
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean updateSaldo(double nuevaCantidad,int id) {
        Connection con = null;
        try {
            con = Conexion.obtenerConexion();
            con.setAutoCommit(false);
            // Actualizar el saldo en la base de datos
            String updateQuery = "UPDATE usuarios SET saldo = ? WHERE id = ?";
            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setDouble(1, nuevaCantidad);
            updateStatement.setInt(2, id);
            updateStatement.executeUpdate();

            con.commit();
            return true;
        } 
        catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                }
                 catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
            System.out.println("Error al realizar el depósito.");
            return false;
        } 
        finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void updateHistorico(double cantidad,String trans,int id) {
        Connection con = null;
        try {
            // Registrar la operación en el historial
            con = Conexion.obtenerConexion();
            con.setAutoCommit(false);

            String insertHistoricoQuery = "INSERT INTO historico (usuario_id, tipo_operacion, cantidad) VALUES (?, ?, ?)";
            PreparedStatement historicoStatement = con.prepareStatement(insertHistoricoQuery);
            historicoStatement.setInt(1, id);
            historicoStatement.setString(2,trans);
            historicoStatement.setDouble(3, cantidad);
            historicoStatement.executeUpdate(); 

            con.commit();
        } 
        catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                }
                 catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
            System.out.println("Error al actualizar el historico.");
        } 
        finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 