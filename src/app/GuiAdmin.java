package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GuiAdmin extends JPanel {
//	private String user, pass, dni, nombre, ape, domicilio;
//	private GregorianCalendar fechaAlta;
//	private int nivel;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtApe;
	private JTextField txtDir;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public GuiAdmin() {
		setLayout(null);
		setSize(850, 450);

		menuBar();
		
		setVisible(true);

	}
	void menuBar(){
		JMenu opciones = TpvMain.menuBar.getMenu(1),
				users = new JMenu("Gestion de usuarios"),
				productos = new JMenu("Gestion de productos");
		
		JMenuItem add = new JMenuItem("Añadir");
		
		opciones.add(users);
		opciones.add(productos);
		
		users.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	removeAll();
			//	repaint();
			//	add(new Usuarios());
				crearUsuario();
			}
		}); 
		
		
	}
	
	void crearUsuario(){
		removeAll();
		repaint();
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(65, 14, 100, 15);
		add(lblUsuario);
		
		txtUser = new JTextField();
		txtUser.setBounds(170, 12, 175, 19);
		add(txtUser);
		txtUser.setColumns(10);
		
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(65, 41, 100, 15);
		add(lblContrasea);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(170, 39, 175, 19);
		add(txtPass);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(65, 97, 70, 15);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(170, 95, 175, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(65, 124, 70, 15);
		add(lblApellidos);
		
		JLabel lblDniCif = new JLabel("DNI / CIF");
		lblDniCif.setBounds(65, 68, 70, 15);
		add(lblDniCif);
		
		txtDni = new JTextField();
		txtDni.setBounds(170, 66, 175, 19);
		add(txtDni);
		txtDni.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(170, 122, 175, 19);
		add(txtApe);
		txtApe.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(65, 151, 70, 15);
		add(lblDomicilio);
		
		txtDir = new JTextField();
		txtDir.setBounds(170, 149, 175, 19);
		add(txtDir);
		txtDir.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(65, 178, 70, 15);
		add(lblNivel);
		
		final JComboBox box_nivel = new JComboBox();
		box_nivel.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		box_nivel.setBounds(170, 173, 175, 24);
		add(box_nivel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUser.setText("");
				txtNombre.setText("");
				txtDni.setText("");
				txtApe.setText("");
				txtDir.setText("");
				txtPass.setText("");
				box_nivel.setSelectedItem(1);
			}
		});
		btnCancelar.setBounds(65, 240, 117, 25);
		add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Usuarios(txtUser.getText(), String.valueOf(txtPass.getPassword()),
						txtDni.getText(), txtNombre.getText(), txtApe.getText(),
						txtDir.getText());
				
			}
		});
		btnGuardar.setBounds(228, 240, 117, 25);
		add(btnGuardar);
	}
	void modificarUsuario(){
		JTextField textField;
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
