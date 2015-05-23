package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GuiAdmin extends GuiCliente {
//	private String user, pass, dni, nombre, ape, domicilio;
//	private GregorianCalendar fechaAlta;
//	private int nivel;
	private String user;
	private JTextField txt1, txt2, txt3, txt4,txt5,txt6;
	private JPasswordField txtPass;
	private JComboBox box_nivel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public GuiAdmin(String user) {
	//	this.user = user;
		super(user);
		setLayout(null);
		setSize(850, 450);

	//	JMenu opciones = TpvMain.menuBar.getMenu(1);
		opciones.add(new JSeparator());
		gestionUsuarios(opciones);
		gestionProductos(opciones);
		
		JMenuItem btnTickets = new JMenuItem("Consultar tickets");
		btnTickets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ticketsAdmin();
				
			}
		});
		opciones.add(btnTickets);
		
		JMenuItem btnFacturas = new JMenuItem("Consultar facturas");
		btnFacturas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				facturasAdmin();
				
			}
		});
		opciones.add(btnFacturas);
	/*	
		opciones.add(separator);
		JMenuItem mntmPanelUser = new JMenuItem("Acceder como cliente");
		mntmPanelUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				repaint();
				new GuiCliente(user);
				
			}
		});
		opciones.add(mntmPanelUser);
		*/
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
				eliminarUsuario();
			}
		});
		
		consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarUsuario();
			}
		});
		
	}
	void gestionProductos(JMenu opciones){
		JMenu productos = new JMenu("Gestion de productos");
		JMenuItem add = new JMenuItem("Añadir"),
				mod = new JMenuItem("Modificar"),
				eliminar = new JMenuItem("Eliminar"),
				consultar = new JMenuItem("Consultar");
		
		opciones.add(productos);
		productos.add(add);
		productos.add(mod);
		productos.add(eliminar);
		productos.add(consultar);

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearProducto();
			}
		}); 
		
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarProducto();
			}
		});
		
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarProducto();
			}
		});
		
		consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarProducto();
			}
		});
		
	}
	/*
	 * ************************************************************************************
	 * USUARIOS
	 * ************************************************************************************
	 * 
	 */
	
	void crearUsuario(){
		removeAll();
		repaint();
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(65, 14, 100, 15);
		add(lblUsuario);
		
		txt1 = new JTextField();
		txt1.setBounds(170, 12, 175, 19);
		add(txt1);
		txt1.setColumns(10);
		
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(65, 41, 100, 15);
		add(lblContrasea);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(170, 39, 175, 19);
		add(txtPass);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(65, 97, 70, 15);
		add(lblNombre);
		
		txt2 = new JTextField();
		txt2.setBounds(170, 95, 175, 19);
		add(txt2);
		txt2.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(65, 124, 70, 15);
		add(lblApellidos);
		
		JLabel lblDniCif = new JLabel("DNI / CIF");
		lblDniCif.setBounds(65, 68, 70, 15);
		add(lblDniCif);
		
		txt3 = new JTextField();
		txt3.setBounds(170, 66, 175, 19);
		add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(170, 122, 175, 19);
		add(txt4);
		txt4.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(65, 151, 70, 15);
		add(lblDomicilio);
		
		txt5 = new JTextField();
		txt5.setBounds(170, 149, 175, 19);
		add(txt5);
		txt5.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(65, 178, 70, 15);
		add(lblNivel);
		
		box_nivel = new JComboBox<>();
		box_nivel.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		box_nivel.setBounds(170, 173, 175, 24);
		add(box_nivel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
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
				new Usuarios(txt1.getText(), String.valueOf(txtPass.getPassword()),
						txt3.getText(), txt2.getText(), txt4.getText(),
						txt5.getText(),box_nivel.getSelectedIndex());
				
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
				txt1.setText(datos[0]);
				txtPass.setText(datos[1]);
				txt3.setText(datos[2]);
				txt2.setText(datos[3]);
				txt4.setText(datos[4]);
				txt5.setText(datos[5]);
				txt6.setText(datos[6]);
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
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(212, 54, 166, 19);
		add(txt1);
		txt1.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(212, 81, 166, 19);
		add(txtPass);
		
		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setBounds(212, 108, 166, 19);
		add(txt3);
		txt3.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(212, 135, 166, 19);
		add(txt2);
		txt2.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(212, 162, 166, 19);
		add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(212, 189, 166, 19);
		add(txt5);
		txt5.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(78, 216, 70, 15);
		add(lblFecha);
		
		txt6 = new JTextField();
		txt6.setBounds(212, 215, 166, 19);
		add(txt6);
		txt6.setColumns(10);
		
		box_nivel = new JComboBox();
		box_nivel.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		box_nivel.setBounds(212, 238, 166, 24);
		add(box_nivel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
				txtPass.setText("");
				txt6.setText("");
				box_nivel.setSelectedItem(1);
			}
		});
		btnCancelar.setBounds(77, 290, 140, 25);
		add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Usuarios.modificar(txt1.getText(), String.valueOf(txtPass.getPassword()),
						txt2.getText(), txt4.getText(),
						txt5.getText(),txt6.getText(),box_nivel.getSelectedIndex());
				
			}
		});
		btnGuardar.setBounds(240, 290, 140, 25);
		add(btnGuardar);
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuarios.eliminar(txt1.getText());
				
			}
		});
		btnEliminar.setBounds(390, 51, 90, 25);
		add(btnEliminar);
	
	}
	void eliminarUsuario(){
		removeAll();
		repaint();
		final JTextField txtEliminar;
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(37, 12, 70, 15);
		add(lblUsuario);
		
		txtEliminar = new JTextField();
		txtEliminar.setBounds(125, 10, 152, 19);
		add(txtEliminar);
		txtEliminar.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(289, 7, 117, 25);
		add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuarios.eliminar(txtEliminar.getText());
				
			}
		});
	}
	void consultarUsuario(){
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
		
		
		final JLabel lblUsuario_1 = new JLabel("Usuario: ");
		lblUsuario_1.setBounds(78, 54, 220, 15);
		add(lblUsuario_1);
		
		final JLabel lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setBounds(78, 81, 220, 15);
		add(lblContrasea);
		
		final JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(78, 135, 220, 15);
		add(lblNombre);
		
		final JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(78, 162, 220, 15);
		add(lblApellidos);
		
		final JLabel lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBounds(78, 189, 220, 15);
		add(lblDireccion);
		
		final JLabel lblDni = new JLabel("DNI: ");
		lblDni.setBounds(78, 108, 220, 15);
		add(lblDni);
		
		final JLabel lblFecha = new JLabel("Fecha de alta: ");
		lblFecha.setBounds(78, 216, 220, 15);
		add(lblFecha);
		
		final JLabel lblNivel = new JLabel("Nivel: ");
		lblNivel.setBounds(78, 243, 220, 15);
		add(lblNivel);
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] datos = Usuarios.buscar(txtBuscar.getText());
				if(datos != null){
					lblUsuario_1.setText("Usuario: ".concat(datos[0]));
					lblContrasea.setText("Contraseña: ".concat(datos[1]));
					lblDni.setText("DNI: ".concat(datos[2]));
					lblNombre.setText("Nombre: ".concat(datos[3]));
					lblApellidos.setText("Apellidos: ".concat(datos[4]));
					lblDireccion.setText("Direccion: ".concat(datos[5]));
					lblFecha.setText("Fecha de alta: ".concat(datos[6]));
					lblNivel.setText("Nivel: ".concat((Integer.parseInt(datos[7])==1)?"Administrador":"Usuario"));
				}
				
			}
		});
	}
	
	
	
	
	/*
	 * ************************************************************************************
	 * PRODUCTOS
	 * ************************************************************************************
	 * 
	 */
	
	void crearProducto(){
		removeAll();
		repaint();
		JLabel lblDesc = new JLabel("Descripcion");
		lblDesc.setBounds(65, 14, 100, 15);
		add(lblDesc);
		
		txt1 = new JTextField();
		txt1.setBounds(170, 12, 175, 19);
		add(txt1);
		txt1.setColumns(10);
		
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(65, 41, 100, 15);
		add(lblPrecio);
		
		txt2 = new JTextField();
		txt2.setBounds(170, 39, 175, 19);
		add(txt2);
		txt2.setColumns(10);
		
		JLabel lblIva = new JLabel("IVA");
		lblIva.setBounds(65, 66, 70, 15);
		add(lblIva);
		
		txt3 = new JTextField();
		txt3.setBounds(170, 66, 175, 19);
		add(txt3);
		txt3.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(65, 93, 70, 15);
		add(lblStock);
		
		txt4 = new JTextField();
		txt4.setBounds(170, 93, 175, 19);
		add(txt4);
		txt4.setColumns(10);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
			}
		});
		btnCancelar.setBounds(65, 120, 117, 25);
		add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Productos(txt1.getText(), Double.parseDouble(txt2.getText()),
						Double.parseDouble(txt3.getText()), Integer.parseInt(txt4.getText()));
				
			}
		});
		btnGuardar.setBounds(228, 120, 117, 25);
		add(btnGuardar);
	}
	void modificarProducto(){
		removeAll();
		repaint();
		final JTextField txtBuscar;
		JLabel lblUsuario = new JLabel("Codigo");
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
				String [] datos = Productos.buscar(Integer.parseInt(txtBuscar.getText()));
				txt1.setText(datos[0]);
				txt2.setText(datos[1]);
				txt3.setText(datos[2]);
				txt4.setText(datos[3]);
				txt5.setText(datos[5]);
			}
		});
		
		JLabel lblcodigo = new JLabel("Codigo");
		lblcodigo.setBounds(78, 54, 116, 15);
		add(lblcodigo);
		
		JLabel lblDesc = new JLabel("Descripcion");
		lblDesc.setBounds(78, 81, 116, 15);
		add(lblDesc);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(78, 108, 116, 15);
		add(lblPrecio);
		
		JLabel lblIva = new JLabel("IVA");
		lblIva.setBounds(78, 135, 116, 15);
		add(lblIva);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(78, 162, 116, 15);
		add(lblStock);
		
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(212, 54, 166, 19);
		add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(212, 81, 166, 19);
		add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(212, 108, 166, 19);
		add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(212, 135, 166, 19);
		add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(212, 162, 166, 19);
		add(txt5);
		txt5.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
			}
		});
		btnCancelar.setBounds(77, 200, 140, 25);
		add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Productos.modificar(Integer.parseInt(txt1.getText()),
						txt2.getText(), Double.parseDouble(txt3.getText()),
						Double.parseDouble(txt4.getText()),
						Integer.parseInt(txt5.getText()));
				
			}
		});
		btnGuardar.setBounds(240, 200, 140, 25);
		add(btnGuardar);
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Productos.eliminar(Integer.parseInt(txt1.getText()));
				
			}
		});
		btnEliminar.setBounds(390, 51, 90, 25);
		add(btnEliminar);
	
	}
	void eliminarProducto(){
		removeAll();
		repaint();
		final JTextField txtEliminar;
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(37, 12, 70, 15);
		add(lblCodigo);
		
		txtEliminar = new JTextField();
		txtEliminar.setBounds(125, 10, 152, 19);
		add(txtEliminar);
		txtEliminar.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(289, 7, 117, 25);
		add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Productos.eliminar(Integer.parseInt(txtEliminar.getText()));
				
			}
		});
	}
	void consultarProducto(){
		removeAll();
		repaint();
		final JTextField txtBuscar;
		JLabel lblbusqueda = new JLabel("Codigo");
		lblbusqueda.setBounds(37, 12, 70, 15);
		add(lblbusqueda);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(125, 10, 152, 19);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(289, 7, 117, 25);
		add(btnBuscar);
		
		
		final JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(78, 54, 250, 15);
		add(lblCodigo);
		
		final JLabel lblDesc = new JLabel("Descripcion: ");
		lblDesc.setBounds(78, 81, 250, 15);
		add(lblDesc);
		
		final JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(78, 108, 250, 15);
		add(lblPrecio);
		
		final JLabel lblIva = new JLabel("IVA: ");
		lblIva.setBounds(78, 135, 250, 15);
		add(lblIva);
		
		final JLabel lblPrecioIva = new JLabel("Prevo IVA Inc.: ");
		lblPrecioIva.setBounds(78, 162, 250, 15);
		add(lblPrecioIva);
		
		final JLabel lblStock = new JLabel("Stock: ");
		lblStock.setBounds(78, 189, 250, 15);
		add(lblStock);
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] datos = Productos.buscar(Integer.parseInt(txtBuscar.getText()));
				if(datos != null){
					lblCodigo.setText("Codigo: ".concat(datos[0]));
					lblDesc.setText("Descripcion: ".concat(datos[1]));
					lblPrecio.setText("Precio: ".concat(datos[2]));
					lblIva.setText("IVA: ".concat(datos[3]));
					lblPrecioIva.setText("Precio IVA Inc.: ".concat(datos[4]));
					lblStock.setText("Stock: ".concat(datos[5]));
				}
			}
		});
	}
	void ticketsAdmin(){
		removeAll();
		repaint();
		final ArrayList<Tickets> tickets = new ArrayList<Tickets>();
		
		
		JLabel lblTickets = new JLabel("Consultar tickets");
		lblTickets.setFont(new Font("Dialog", Font.BOLD, 29));
		lblTickets.setBounds(20, 10, 360, 45);
		add(lblTickets);
		
		JButton btnListados = new JButton("Hacer un listado");
		btnListados.setFont(new Font("Dialog", Font.BOLD, 16));
		btnListados.setBackground(new Color(0, 255, 0));
		btnListados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listados();
			}
		});
		btnListados.setBounds(590, 10, 230, 45);
		add(btnListados);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(70, 65, 180, 15);
		add(lblCodigo);
		
		
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(290, 65, 131, 15);
		add(lblFecha);
		
		JLabel lblFacturado = new JLabel("Facturado");
		lblFacturado.setBounds(490, 65, 118, 15);
		add(lblFacturado);
		
		JPanel panel = scrolling();
		
		
		
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("select * from Tickets order by fecha desc;");
			while (rs.next()) {
				tickets.add(new Tickets(rs));
				panel.add(tickets.get(tickets.size()-1).ver());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void facturasAdmin(){
		removeAll();
		repaint();
		removeAll();
		repaint();
		final ArrayList<Facturas> facturas = new ArrayList<Facturas>();
	//	final ArrayList<Tickets> tickets = new ArrayList<Tickets>();
		
		
		JLabel lblFacturas = new JLabel("Consultar facturas");
		lblFacturas.setFont(new Font("Dialog", Font.BOLD, 29));
		lblFacturas.setBounds(20, 10, 360, 45);
		add(lblFacturas);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(70, 65, 180, 15);
		add(lblCodigo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(310, 65, 131, 15);
		add(lblFecha);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setBounds(530, 65, 118, 15);
		add(lblCif);
		
		JPanel panel = scrolling();
		
		
		
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("SELECT DISTINCT f.* FROM Facturas f, Tickets t where t.num_factura = f.numero order by numero desc;");
			while (rs.next()) {
				facturas.add(new Facturas(rs));
			}
			for (int i = 0; i < facturas.size(); i++) {
				panel.add(facturas.get(i).ver());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void listados(){
		removeAll();
		repaint();
		final JTextField fInicio;
		final JTextField fFin;
		
		final ButtonGroup buttonGroup = new ButtonGroup();
		
		final JRadioButton rdbtnListadoDeVentas = new JRadioButton("Listado de ventas realizadas agrupadas por clientes");
		buttonGroup.add(rdbtnListadoDeVentas);
		rdbtnListadoDeVentas.setSelected(true);
		rdbtnListadoDeVentas.setBounds(8, 10, 426, 15);
		add(rdbtnListadoDeVentas);
		
		final JRadioButton rdbtnListadoDeVentas_1 = new JRadioButton("Listado de ventas realizadas a un cliente");
		buttonGroup.add(rdbtnListadoDeVentas_1);
		rdbtnListadoDeVentas_1.setBounds(8, 30, 426, 15);
		add(rdbtnListadoDeVentas_1);
		
		final JRadioButton rdbtnRankingDeProductos = new JRadioButton("Ranking de productos mas vendidos");
		buttonGroup.add(rdbtnRankingDeProductos);
		rdbtnRankingDeProductos.setBounds(8, 50, 426, 15);
		add(rdbtnRankingDeProductos);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setBounds(548, 10, 88, 20);
		add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin:");
		lblFechaFin.setBounds(548, 30, 88, 20);
		add(lblFechaFin);
		
		fInicio = new JTextField();
		fInicio.setText("2015-05-01");
		fInicio.setBounds(654, 10, 88, 20);
		add(fInicio);
		fInicio.setColumns(10);
		
		fFin = new JTextField();
		fFin.setText("2015-05-22");
		fFin.setBounds(654, 30, 88, 20);
		add(fFin);
		fFin.setColumns(10);
		
		
		JButton btnListar = new JButton("Listar");
		
		btnListar.setBounds(590, 55, 104, 25);
		add(btnListar);
		

		final JPanel panel = scrolling();
		
		btnListar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.repaint();
				if(rdbtnListadoDeVentas.isSelected()){
					listadoVentas(panel, fInicio.getText(), fFin.getText());
				} else if(rdbtnListadoDeVentas_1.isSelected()){
					listadoVentasCliente(panel, fInicio.getText(), fFin.getText());
				} else if(rdbtnRankingDeProductos.isSelected()){
					listadoRanking(panel, fInicio.getText(), fFin.getText());
				}
				
			}
		});
		
	}
	void listadoVentas(JPanel panel, String fInicio, String fFin){
		
		String sql = "SELECT * FROM tpv.Tickets where fecha >= '" + fInicio + "' and fecha <='" + fFin + "' order by cod_cliente, fecha desc;";
		String[][] data = null;
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery(sql);
			rs.last();
			data = new String[rs.getRow()][4];
			rs.absolute(0);
			while(rs.next()){
				for (int i = 0; i < data[rs.getRow()-1].length; i++) {
					data[rs.getRow()-1][i] = rs.getString(i+1);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    Object[] colum = {"Codigo", "Cliente", "Fecha", "Factura"};
	    JTable table = new JTable(data, colum);
	    JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 52, 600, 50);
		panel.add(scrollPane);

		table.setRowSelectionAllowed(false);
		table.setShowVerticalLines(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
	}
	
	void listadoVentasCliente(JPanel panel,  String fInicio, String fFin){
		String sql = "";
		String cliente;
		do {
			cliente = JOptionPane.showInputDialog("Nombre de usuario:");
		} while (!Usuarios.existe(cliente));
		sql = "SELECT * FROM tpv.Tickets where cod_cliente ='" + cliente + "' and fecha >= '" + fInicio + "' and fecha <='" + fFin + "' order by fecha desc;";
		String[][] data = null;
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery(sql);
			rs.last();
			data = new String[rs.getRow()][4];
			rs.absolute(0);
			while(rs.next()){
				for (int i = 0; i < data[rs.getRow()-1].length; i++) {
					data[rs.getRow()-1][i] = rs.getString(i+1);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    Object[] colum = {"Codigo", "Cliente", "Fecha", "Factura"};
	    JTable table = new JTable(data, colum);
	    JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 52, 600, 50);
		panel.add(scrollPane);

		table.setRowSelectionAllowed(false);
		table.setShowVerticalLines(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
	}
	
	void listadoRanking(JPanel panel,  String fInicio, String fFin){
		String sql = "SELECT sum(lt.cantidad), p.* FROM LineasTicket lt, Productos p, Tickets t where p.codigo = lt.cod_producto and lt.cod_ticket = t.codigo and t.fecha >= '" + fInicio + "' and t.fecha <='" + fFin + "' group by lt.cod_producto order by 1 desc;";
		String[][] data = null;
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery(sql);
			rs.last();
			data = new String[rs.getRow()][7];
			rs.absolute(0);
			while(rs.next()){
				for (int i = 0; i < data[rs.getRow()-1].length; i++) {
					data[rs.getRow()-1][i] = rs.getString(i+1);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    Object[] colum = {"Cantidad", "Producto", "Descripcion", "Precio","IVA","Precio con IVA", "STOCK"};
	    
	    JTable table = new JTable(data, colum);
	    JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 52, 600, 50);
		panel.add(scrollPane);

		table.setRowSelectionAllowed(false);
		table.setShowVerticalLines(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
	//	scrollPane.setPreferredSize(new Dimension(700, 400));
	}
}
