package app;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class TpvMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2948762342322980933L;
	private static JPanel content = new JPanel();
	static Connection db = MySQL.Connectar();
	public static JMenuBar menuBar;
	public static TpvMain frame = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new TpvMain();
					frame.setVisible(true);
					frame.setSize(630, 360);
			//		frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TpvMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TpvMain.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("TPV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setSize(400,250);
		content.setLayout(null);
		
		JPanel login = new JPanel();
		login.setBounds(5, 0, 614, 310);
		content.add(login);
		login.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(188, 88, 60, 15);
		login.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(188, 139, 88, 15);
		login.add(lblContrasea);
		
		final JTextField txtUsuario = new JTextField();
		txtUsuario.setBounds(294, 86, 136, 19);
		login.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(294, 137, 136, 19);
		login.add(passwordField);
		passwordField.setColumns(12);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login(txtUsuario.getText(), passwordField.getPassword());
			}
		});
		btnAceptar.setBounds(317, 174, 113, 25);
		login.add(btnAceptar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro();
			}
		});
		btnRegistrar.setBounds(188, 174, 126, 25);
		login.add(btnRegistrar);
		
		
		
		JTextPane txtpnCadaUsuarioTiene = new JTextPane();
		txtpnCadaUsuarioTiene.setText("Cada usuario tiene su propio panel de administracion o su propio panel de compras segun el tipo de usuario que sea, (Administrador o Cliente)");
		txtpnCadaUsuarioTiene.setBounds(12, 248, 590, 50);
		login.add(txtpnCadaUsuarioTiene);
		
		JLabel lblh1 = new JLabel("Acceso a la cuenta");
		lblh1.setFont(new Font("Dialog", Font.BOLD, 32));
		lblh1.setBounds(136, 12, 346, 38);
		login.add(lblh1);
		
	//	contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(ABORT);
			}
		});
		
				
		
		mnArchivo.add(mntmCerrar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmCrearCuenta = new JMenuItem("Crear cuenta");
		mntmCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registro();
			}
		});
		mnOpciones.add(mntmCrearCuenta);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe();
			}
		});
		mnAyuda.add(mntmAcercaDe);
	}
	void login(String user, char [] pass){
		try {
			ResultSet select = db.createStatement().executeQuery(
					"select * from Usuarios where usuario = '" + user + "' and contrasena = '" + String.valueOf(pass) + "';"
					);
			
			if(select.absolute(1)){
				JOptionPane.showMessageDialog(null, "Bienvenido " + user + ", te has identificado correctamente");
				
				menuBar.getMenu(1).removeAll();
				JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
				menuBar.getMenu(0).add(mntmDesconectar);
				
				mntmDesconectar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						frame = new TpvMain();
						frame.setVisible(true);
						frame.setSize(630, 360);
						
					}
				});
				content.removeAll();
				content.repaint();
				switch (select.getInt("nivel")) {
					case 0:
						content.add(new GuiCliente(user));
				//		frame.pack();
						break;
					case 1:
						content.add(new GuiAdmin());
				//		frame.setSize(900, 500);
						break;
	
					default:
						break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Los datos introducidos no son correctos. ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void registro(){
		
		JFrame Fregistro = new JFrame("Crear cuenta");
		JPanel registro = new JPanel();
		Fregistro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Fregistro.setSize(450,400);
		Fregistro.getContentPane().add(registro);
		Fregistro.setVisible(true);
		
		
		final JTextField txtUser, txtNombre, txtDni, txtApe, txtDir;;
		final JPasswordField txtPass;
		
		registro.setLayout(null);
		registro.setSize(500, 400);
		JPanel panel = new JPanel();
		panel.setBounds(12, 5, 476, 283);
		registro.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(65, 14, 100, 15);
		panel.add(lblUsuario);
		
		txtUser = new JTextField();
		txtUser.setBounds(170, 12, 175, 19);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(65, 41, 100, 15);
		panel.add(lblContrasea);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(170, 39, 175, 19);
		panel.add(txtPass);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(65, 97, 70, 15);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(170, 95, 175, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(65, 124, 70, 15);
		panel.add(lblApellidos);
		
		JLabel lblDniCif = new JLabel("DNI / CIF");
		lblDniCif.setBounds(65, 68, 70, 15);
		panel.add(lblDniCif);
		
		txtDni = new JTextField();
		txtDni.setBounds(170, 66, 175, 19);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(170, 122, 175, 19);
		panel.add(txtApe);
		txtApe.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(65, 151, 70, 15);
		panel.add(lblDomicilio);
		
		txtDir = new JTextField();
		txtDir.setBounds(170, 149, 175, 19);
		panel.add(txtDir);
		txtDir.setColumns(10);
		
		JButton btnCancelar = new JButton("Borrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUser.setText("");
				txtNombre.setText("");
				txtDni.setText("");
				txtApe.setText("");
				txtDir.setText("");
				txtPass.setText("");
			}
		});
		btnCancelar.setBounds(65, 240, 117, 25);
		panel.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Usuarios(txtUser.getText(), String.valueOf(txtPass.getPassword()),
						txtDni.getText(), txtNombre.getText(), txtApe.getText(),
						txtDir.getText(),0);
				
			}
		});
		btnGuardar.setBounds(228, 240, 117, 25);
		panel.add(btnGuardar);
		
	}
	
	void acercaDe(){
		JFrame Facerca = new JFrame("Acerca de");
		JPanel acerca = new JPanel();
		Facerca.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Facerca.setSize(450,400);
		Facerca.getContentPane().add(acerca);
		Facerca.setVisible(true);
		
		acerca.setSize(500,600);
		JTextPane txtAcerca = new JTextPane();
		txtAcerca.setText("Esta aplicacion ha sido realizada por Enrique Gil y Juan Jesus Gregori como proyecto para la asignatura de \"Entornos de desarrollo\"\n\nUna aplicacion sencilla para TPV que permite hacer las funciones basicas como:\nADMINISTRADORES\n------------------------------------\nAñadir usuarios y productos\nModificar usuarios y productos\nEliminar usuarios y productos\nConsultar informacion de usuarios y productos\n\nGenerar facturas\nConsultar informacion sobre facturas\n\nUSUARIOS\n------------------------------------\nComprar\nEditar perfil\nImprimir facturas\n\nEs una herramienta de Software Libre cuyo codigo lo podras encontrar en GitHub.\n\nhttps://github.com/QuiqueGilB/ProyectoEntornos");
		txtAcerca.setSize(387, 425);
		acerca.add(txtAcerca);
		Facerca.pack();
	}
}
