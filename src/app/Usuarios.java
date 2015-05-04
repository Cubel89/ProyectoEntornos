package app;

import java.util.GregorianCalendar;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Usuarios extends JPanel{
	
	private String user, pass, dni, nombre, ape, domicilio;
	private GregorianCalendar fechaAlta;
	private int nivel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public Usuarios() {
		setLayout(null);
		setSize(500, 400);
		JPanel panel = new JPanel();
		panel.setBounds(12, 5, 426, 283);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(65, 14, 100, 15);
		panel.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(170, 12, 175, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(65, 41, 100, 15);
		panel.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 39, 175, 19);
		panel.add(passwordField);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(65, 97, 70, 15);
		panel.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 95, 175, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(65, 124, 70, 15);
		panel.add(lblApellidos);
		
		JLabel lblDniCif = new JLabel("DNI / CIF");
		lblDniCif.setBounds(65, 68, 70, 15);
		panel.add(lblDniCif);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 66, 175, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(170, 122, 175, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(65, 151, 70, 15);
		panel.add(lblDomicilio);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 149, 175, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(65, 178, 70, 15);
		panel.add(lblNivel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(65, 240, 117, 25);
		panel.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(228, 240, 117, 25);
		panel.add(btnGuardar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		comboBox.setBounds(170, 173, 175, 24);
		panel.add(comboBox);
	}
}
