package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
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
	private JTextField txtFecha;
	private JComboBox box_nivel;
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

		JMenu opciones = TpvMain.menuBar.getMenu(1),
				productos = new JMenu("Gestion de productos");
		
		gestionUsuarios(opciones);
		
		opciones.add(productos);
		
		
		
		
		
		JSeparator separator = new JSeparator();
		opciones.add(separator);
		JMenuItem mntmImportar = new JMenuItem("Importar");
		opciones.add(mntmImportar);
		
		JMenuItem mntmExportar = new JMenuItem("Exportar");
		opciones.add(mntmExportar);
		
		
		setVisible(true);

	}
	
	void gestionUsuarios(JMenu opciones){
		JMenu users = new JMenu("Gestion de usuarios");
		JMenuItem add = new JMenuItem("Añadir"),
				mod = new JMenuItem("Modificar"),
				eliminar = new JMenuItem("Eliminar"),
				consultar = new JMenuItem("Consultar");
		
		opciones.add(users);
		users.add(add);
		users.add(mod);
		users.add(eliminar);
		users.add(consultar);

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearUsuario();
			}
		}); 
		
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarUsuario();
			}
		});
		
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearUsuario();
			}
		});
		
		consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		final JComboBox box_nivel = new JComboBox<>();
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
						txtDir.getText(),box_nivel.getSelectedIndex());
				
			}
		});
		btnGuardar.setBounds(228, 240, 117, 25);
		add(btnGuardar);
	}
	void modificarUsuario(){
		removeAll();
		repaint();
		final JTextField txtBuscar;
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(37, 12, 70, 15);
		add(lblUsuario);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(125, 10, 152, 19);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(289, 7, 117, 25);
		add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] datos = Usuarios.buscar(txtBuscar.getText());
				txtUser.setText(datos[0]);
				txtPass.setText(datos[1]);
				txtDni.setText(datos[2]);
				txtNombre.setText(datos[3]);
				txtApe.setText(datos[4]);
				txtDir.setText(datos[5]);
				txtFecha.setText(datos[6]);
				box_nivel.setSelectedIndex(Integer.parseInt(datos[7]));
			}
		});
		
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
		lblNivel.setBounds(78, 243, 116, 15);
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
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(78, 216, 70, 15);
		add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(212, 215, 166, 19);
		add(txtFecha);
		txtFecha.setColumns(10);
		
		final JComboBox box_nivel = new JComboBox();
		box_nivel.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		box_nivel.setBounds(212, 238, 166, 24);
		add(box_nivel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	txtUser.setText("");
				txtNombre.setText("");
			//	txtDni.setText("");
				txtApe.setText("");
				txtDir.setText("");
				txtPass.setText("");
				box_nivel.setSelectedItem(1);
			}
		});
		btnCancelar.setBounds(77, 290, 140, 25);
		add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Usuarios.modificar(txtUser.getText(), String.valueOf(txtPass.getPassword()),
						txtNombre.getText(), txtApe.getText(),
						txtDir.getText(),box_nivel.getSelectedIndex());
				
			}
		});
		btnGuardar.setBounds(240, 290, 140, 25);
		add(btnGuardar);
	
	}
}
