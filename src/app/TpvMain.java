package app;

import java.awt.EventQueue;
import java.awt.Font;
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
import java.awt.Toolkit;

public class TpvMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2948762342322980933L;
	private static JPanel content = new JPanel();
	static Connection db = MySQL.Connectar();
	private static JMenuBar menuBar;
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
		mnArchivo.setEnabled(false);
		menuBar.add(mnArchivo);
		
		JMenu mnImportar = new JMenu("Importar");
		mnArchivo.add(mnImportar);
		
		JMenuItem mntmProductos = new JMenuItem("Productos");
		mnImportar.add(mntmProductos);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mnImportar.add(mntmClientes);
		
		JMenu mnExportar = new JMenu("Exportar");
		mnArchivo.add(mnExportar);
		
		JMenuItem mntmProductos_1 = new JMenuItem("Productos");
		mnExportar.add(mntmProductos_1);
		
		JMenuItem mntmClientes_1 = new JMenuItem("Clientes");
		mnExportar.add(mntmClientes_1);
		
		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mnArchivo.add(mntmDesconectar);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		mnOpciones.setEnabled(false);
		menuBar.add(mnOpciones);
		
		JMenu mnGestionDeProductos = new JMenu("Gestion de productos");
		mnOpciones.add(mnGestionDeProductos);
		
		JMenuItem mntmAadir = new JMenuItem("Añadir");
		mnGestionDeProductos.add(mntmAadir);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mnGestionDeProductos.add(mntmBorrar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnGestionDeProductos.add(mntmModificar);
		
		JMenu mnGestionDeClientes = new JMenu("Gestion de clientes");
		mnOpciones.add(mnGestionDeClientes);
		
		JMenuItem mntmAadir_1 = new JMenuItem("Añadir");
		mnGestionDeClientes.add(mntmAadir_1);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnGestionDeClientes.add(mntmEliminar);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mnGestionDeClientes.add(mntmModificar_1);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAyuda.add(mntmAcercaDe);
	}
	void login(String user, char [] pass){
		try {
			ResultSet select = db.createStatement().executeQuery(
					"select * from Usuarios where usuario = '" + user + "' and contrasena = '" + String.valueOf(pass) + "';"
					);
			
			if(select.absolute(1)){
				JOptionPane.showMessageDialog(null, "Bienvenido " + user + ", te has identificado correctamente");
				
				
				switch (select.getInt("nivel")) {
					case 0:
						content.removeAll();
						content.repaint();
						content.add(new GuiCliente());
						frame.pack();
						break;
					case 1:
						content.removeAll();
						content.repaint();
						content.add(new GuiAdmin());
						frame.setSize(900, 500);
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
}
