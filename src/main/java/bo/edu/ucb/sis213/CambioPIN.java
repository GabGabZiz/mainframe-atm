package bo.edu.ucb.sis213;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambioPIN extends JFrame {

	private JPanel contentPane;
	private JButton btnAceptar;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public CambioPIN() {
        Llamadas calls = new Llamadas(); // Create an instance of Calls

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese su PIN actual:");
		lblNewLabel.setBounds(54, 97, 119, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cambio de PIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(152, 35, 150, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                calls.callIngreso();
			}
		});
		btnNewButton.setBounds(182, 241, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(54, 132, 121, 29);
		contentPane.add(passwordField);
		
		JLabel lblIngreseSuNuevo = new JLabel("Ingrese su nuevo PIN:");
		lblIngreseSuNuevo.setBounds(279, 68, 119, 14);
		contentPane.add(lblIngreseSuNuevo);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(279, 90, 121, 29);
		contentPane.add(passwordField_1);
		
		JLabel lblConfirmeSuNuevo = new JLabel("Confirme su nuevo PIN:");
		lblConfirmeSuNuevo.setBounds(277, 132, 119, 14);
		contentPane.add(lblConfirmeSuNuevo);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(277, 154, 121, 29);
		contentPane.add(passwordField_2);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos info = new Metodos();
				int pinActual = Integer.parseInt(passwordField.getText());
				int pinNuevo =  Integer.parseInt(passwordField_1.getText());
				int pinNuevoConf =  Integer.parseInt(passwordField_2.getText());
				info.cambiarPIN(pinActual,pinNuevo,pinNuevoConf);
			}
		});
		btnAceptar.setBounds(182, 200, 89, 23);
		contentPane.add(btnAceptar);
	}
}