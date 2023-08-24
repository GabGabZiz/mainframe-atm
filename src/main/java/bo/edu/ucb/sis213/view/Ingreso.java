package bo.edu.ucb.sis213.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingreso extends JFrame {

    private JPanel contentPane;
    //private Calls calls;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ingreso frame = new Ingreso();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ingreso() {

        Llamadas calls = new Llamadas(); // Create an instance of Calls

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 466, 333);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Menú");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(194, 39, 62, 36);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Consulta de Saldo");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                calls.callConsulta();
            }
        });
        btnNewButton.setBounds(70, 94, 125, 23);
        contentPane.add(btnNewButton);

        JButton btnCambioDePin = new JButton("Cambio de PIN");
        btnCambioDePin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                calls.callCambioPIN();
            }
        });
        btnCambioDePin.setBounds(70, 142, 125, 23);
        contentPane.add(btnCambioDePin);

        JButton btnDeposito = new JButton("Deposito");
        btnDeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                calls.callDeposito();
            }
        });
        btnDeposito.setBounds(254, 94, 125, 23);
        contentPane.add(btnDeposito);

        JButton btnRetiro = new JButton("Retiro");
        btnRetiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                calls.callRetiro();
            }
        });
        btnRetiro.setBounds(254, 142, 125, 23);
        contentPane.add(btnRetiro);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                calls.callInicio();
            }
        });
        btnSalir.setBounds(167, 194, 125, 23);
        contentPane.add(btnSalir);
    }
}