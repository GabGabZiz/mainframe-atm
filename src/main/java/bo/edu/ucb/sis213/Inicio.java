package bo.edu.ucb.sis213;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblContrasea;
	private JPasswordField passwordField;
	protected static String usuario;
	protected static int pin;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
                    frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {

        Llamadas calls = new Llamadas(); // Create an instance of Calls
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(118, 109, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(260, 106, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(118, 151, 86, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(260, 148, 86, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(194, 39, 62, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos info=new Metodos();
				usuario = textField.getText();
				pin = Integer.parseInt(passwordField.getText());
				int intentos = 3;
				while (intentos > 0) {
					if (info.validarPIN(usuario, pin)) {
						
						calls.callIngreso();
						break;
					} 
					else {
						intentos--;
						if (intentos > 0) {
							System.out.println("PIN incorrecto. Le quedan " + intentos + " intentos.");
						} else {
							System.out.println("PIN incorrecto. Ha excedido el número de intentos.");
							System.exit(0);
						}
					}
				}               
			}
		});
		btnNewButton.setBounds(181, 194, 89, 23);
		contentPane.add(btnNewButton);
	}

}
