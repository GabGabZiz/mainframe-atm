package bo.edu.ucb.sis213.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bo.edu.ucb.sis213.BLogic.Metodos;

public class Deposito extends JFrame {

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
	public Deposito() {
        Llamadas calls = new Llamadas(); // Create an instance of Calls

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese la cantidad que desea depositar:");
		lblNewLabel.setBounds(130, 86, 208, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(165, 111, 121, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Deposito");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(181, 39, 89, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                calls.callIngreso();
			}
		});
		btnNewButton.setBounds(181, 203, 89, 23);
		contentPane.add(btnNewButton);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos info=new Metodos();
				double cantidad = Double.parseDouble(textField.getText()); 
				String cad="";
				cad=info.realizarDeposito(cantidad);
				JOptionPane.showMessageDialog(contentPane, cad, "Deposito",  JOptionPane.INFORMATION_MESSAGE);
				limpiar();
				dispose();
				calls.callIngreso();
			}
		});
		btnAceptar.setBounds(181, 162, 89, 23);
		contentPane.add(btnAceptar);
	}
	public void limpiar(){
		textField.setText("");
	}
}
