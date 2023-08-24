package bo.edu.ucb.sis213.BLogic;

import bo.edu.ucb.sis213.BDO.ConsultasBDO;

public class Metodos {

    public static int id;
    public static int pinActual;
    public static double saldo;

    public boolean validarPIN(String usuario,int pinIngresado) 
    {   
        ConsultasBDO dbo=new ConsultasBDO();
        pinActual=dbo.pin_Consulta(usuario,pinIngresado);
        if(pinActual==pinIngresado){
            obtencionId(usuario, pinIngresado);
            return true;
        }
        return false;
    }
    public int obtencionId(String usuario,int pinIngresado){
        ConsultasBDO dbo=new ConsultasBDO();
        id=dbo.id_Consulta(usuario, pinIngresado);
        return id;
    }
    public String generacion(){
        ConsultasBDO dbo=new ConsultasBDO();
        saldo=dbo.saldo_Consulta(id);
        String cad="Su saldo actual es de:\nBs."+saldo;
		return cad;
    }
    public String realizarDeposito(double cantidad) {
        ConsultasBDO dbo=new ConsultasBDO();
        saldo=dbo.saldo_Consulta(id);
        String cad="";
        String transaccion="Deposito";
        if (cantidad <= 0) {
            cad="Cantidad no válida.";
            return cad;
        } 
        else {
            double saldoTemp = saldo + cantidad;
            boolean flag=dbo.updateSaldo(saldoTemp, id);
            if(flag==true){
                saldo += cantidad;
                cad="Deposito exitoso, su saldo actual es de \nBs."+ saldo;
                dbo.updateHistorico(cantidad, transaccion, id);
                return cad;
            }
            else{
                cad="Error en el retiro";
                return cad;
            }
        }
    }
    public String realizarRetiro(double cantidad) {
        ConsultasBDO dbo=new ConsultasBDO();
        saldo=dbo.saldo_Consulta(id);
        String cad="";
        String transaccion="Retiro";
        if (cantidad <= 0) {
            cad="Cantidad no válida.";
            return cad;
        } 
        else {
            if(saldo >= cantidad){
                double saldoTemp = saldo - cantidad;
                boolean flag=dbo.updateSaldo(saldoTemp, id);
                if(flag==true){
                    saldo -= cantidad;
                    cad="Retiro exitoso, su saldo actual es de \nBs."+ saldo;
                    dbo.updateHistorico(cantidad, transaccion, id);
                    return cad;
                }
                else{
                cad="Error en el retiro";
                return cad;
                }
            }
            else{
                cad="Saldo insuficiente para el retiro";
                return cad;
            }
        }
    }
    public String cambiarPIN(int pinIngresado, int pinNuevo, int pinNuevoConf){
        ConsultasBDO dbo=new ConsultasBDO();
        String cad="";
        if (pinIngresado == pinActual) {
            if (pinNuevo == pinNuevoConf) {
                    dbo.updatePin(pinNuevo, id);
                    pinActual = pinNuevo;
                    cad="Cambio de pin exitoso";
                    return cad;
            }
            else{
            cad="Error en la confirmación del pin";
        }
        }
        else{
            cad="Error en el cambio de pin";
        }
        return cad;
    }
}