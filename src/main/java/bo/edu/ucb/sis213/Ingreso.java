package bo.edu.ucb.sis213;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Ingreso extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnCambioDePin;
	private JButton btnDeposito;
	private JButton btnRetiro;
	private JButton btnSalir;

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
	public Ingreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Men\u00FA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(194, 39, 62, 36);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Consulta de Saldo");
		btnNewButton.setBounds(70, 94, 125, 23);
		contentPane.add(btnNewButton);
		
		btnCambioDePin = new JButton("Cambio de PIN");
		btnCambioDePin.setBounds(70, 142, 125, 23);
		contentPane.add(btnCambioDePin);
		
		btnDeposito = new JButton("Deposito");
		btnDeposito.setBounds(254, 94, 125, 23);
		contentPane.add(btnDeposito);
		
		btnRetiro = new JButton("Retiro");
		btnRetiro.setBounds(254, 142, 125, 23);
		contentPane.add(btnRetiro);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(167, 194, 125, 23);
		contentPane.add(btnSalir);
	}
}