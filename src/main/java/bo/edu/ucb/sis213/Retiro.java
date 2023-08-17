package bo.edu.ucb.sis213;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Retiro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAceptar;

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
	public Retiro() {
        Llamadas calls = new Llamadas(); // Create an instance of Calls

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese la cantidad que desea retirar:");
		lblNewLabel.setBounds(137, 86, 196, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(165, 111, 121, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Retiro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(144, 39, 158, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                calls.callIngreso();
			}
		});
		btnNewButton.setBounds(181, 203, 89, 23);
		contentPane.add(btnNewButton);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(181, 162, 89, 23);
		contentPane.add(btnAceptar);
	}
}
