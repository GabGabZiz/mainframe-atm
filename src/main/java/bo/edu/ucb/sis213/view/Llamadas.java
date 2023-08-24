package bo.edu.ucb.sis213.view;

import javax.swing.JFrame;

public class Llamadas {
    public void callInicio() {
        Inicio x = new Inicio();
        setupFrame(x);
    }
    public void callIngreso() {
        Ingreso x = new Ingreso();
        setupFrame(x);
    }
    public void callConsulta() {
        Consulta x = new Consulta();
        setupFrame(x);
    }

    public void callCambioPIN() {
        CambioPIN x = new CambioPIN();
        setupFrame(x);
    }

    public void callRetiro() {
        Retiro x = new Retiro();
        setupFrame(x);
    }

    public void callDeposito() {
        Deposito x = new Deposito();
        setupFrame(x);
    }

    private void setupFrame(JFrame frame) {
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
