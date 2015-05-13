package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Usuarios {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private String user, pass, dni, nombre, ape, domicilio;
/*	private GregorianCalendar fechaAlta;
	private int nivel;
	private JTextField txt_user;
	private JPasswordField txt_pass;
	private JTextField txt_nombre;
	private JTextField txt_dni;
	private JTextField txt_ape;
	private JTextField txt_domicilio;
	*/

	public Usuarios(String user,String pass,String dni,String nombre,String ape,String domicilio, int nivel){
		boolean ok = false;
		ResultSet rs = null;
		try {
			//  VERIFICAR USUARIO
			rs = TpvMain.db.createStatement().executeQuery("select usuario from Usuarios where usuario = '" + user + "'");
			if(!rs.absolute(1)){
				//  VERIFICAR DNI
				rs = TpvMain.db.createStatement().executeQuery("select dni from Usuarios where dni = '" + dni + "'");
				if(!rs.absolute(1)){
					// VERIFICAR NULLS
					if(!user.equals("") && !pass.equals("")
							&& !nombre.equals("") && !ape.equals("")
							&& !dni.equals("") && !domicilio.equals("")){
						ok = true;
					} else {
						JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Este dni ya esta en uso");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Este usuario ya existe");
			}
			
			
			if(ok){
				TpvMain.db.createStatement().executeUpdate("INSERT INTO Usuarios (usuario, contrasena, dni, nombre, apellidos, domicilio, fechaAlta, nivel) VALUES ('"
						+ user + "','" + pass + "','"
						+ dni + "','" + nombre + "','" + ape + "','"
						+ domicilio + "','"
						+ GregorianCalendar.getInstance().toInstant().toString().substring(0,10) + "',"
						+ nivel
						+");");
				JOptionPane.showMessageDialog(null, "Se ha registrado correctamente.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
		
	}
	public static void modificar(String user,String pass,String nombre,String ape,String domicilio, String fecha,int nivel){
		boolean ok = false;
		try {
				
			// VERIFICAR NULLS
			if(!user.equals("") && !pass.equals("")
					&& !nombre.equals("") && !ape.equals("")
					&& !domicilio.equals("")){
				ok = true;
			} else {
				JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			}
			
			if(ok){
				TpvMain.db.createStatement().executeUpdate("UPDATE Usuarios SET "
						+ "contrasena='" + pass
						+ "', nombre='" + nombre
						+ "', apellidos='" + ape
						+ "', domicilio='" + domicilio
						+ "', fechaAlta='" + fecha
						+ "', nivel ="	+ nivel
						+" WHERE usuario = '"+user+"';");
				JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
			
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
		
	}
	public static void eliminar(String user){
		try {
			ResultSet rs = TpvMain.db.createStatement().executeQuery("select usuario from Usuarios where usuario ='" + user +"';");
			if(rs.absolute(1)){
				if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar el usuario " + user + " ?") == 0){
					TpvMain.db.createStatement().execute("delete from Usuarios where usuario = '" + user +"';");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El usuario " + user + " no existe.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
	}
	public static String [] buscar(String user){
		String[] usuario = new String[8];
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("select * from Usuarios where usuario='"+ user +"'");
			if(rs.absolute(1)){
				for (int i = 0; i < usuario.length; i++) {
					usuario[i] = rs.getString(i+1);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existe este usuario");
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
		return usuario;
	}
	
	/*
	void modificarUsuario(){
		JTextField textField;
		JTextField txtUser;
		JPasswordField txtPass;
		JTextField txtDni;
		JTextField txtNombre;
		JTextField txtApe;
		JTextField txtDir;
		
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
	*/
}
