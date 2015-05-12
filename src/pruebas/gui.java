package pruebas;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class gui extends JPanel{
	private JTextField textField;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApe;
	private JTextField txtDir;
	public gui() {
		setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(37, 12, 70, 15);
		add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(125, 10, 152, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(289, 7, 117, 25);
		add(btnBuscar);
		
		JLabel lblUsuario_1 = new JLabel("Usuario");
		lblUsuario_1.setBounds(78, 54, 116, 15);
		add(lblUsuario_1);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(78, 81, 116, 15);
		add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(78, 135, 116, 15);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(78, 162, 116, 15);
		add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(78, 189, 116, 15);
		add(lblDireccion);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(78, 108, 116, 15);
		add(lblDni);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(78, 216, 116, 15);
		add(lblNivel);
		
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setBounds(212, 54, 166, 19);
		add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(212, 81, 166, 19);
		add(txtPass);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setBounds(212, 108, 166, 19);
		add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(212, 135, 166, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(212, 162, 166, 19);
		add(txtApe);
		txtApe.setColumns(10);
		
		txtDir = new JTextField();
		txtDir.setBounds(212, 189, 166, 19);
		add(txtDir);
		txtDir.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		comboBox.setBounds(212, 211, 166, 24);
		add(comboBox);
	}
}
