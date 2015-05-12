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

public class Usuarios extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private String user, pass, dni, nombre, ape, domicilio;
	private GregorianCalendar fechaAlta;
	private int nivel;
	private JTextField txt_user;
	private JPasswordField txt_pass;
	private JTextField txt_nombre;
	private JTextField txt_dni;
	private JTextField txt_ape;
	private JTextField txt_domicilio;
	/*
	public Usuarios() {
		setLayout(null);
		setSize(500, 400);
		JPanel panel = new JPanel();
		panel.setBounds(12, 5, 476, 283);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(65, 14, 100, 15);
		panel.add(lblUsuario);
		
		txt_user = new JTextField();
		txt_user.setBounds(170, 12, 175, 19);
		panel.add(txt_user);
		txt_user.setColumns(10);
		
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(65, 41, 100, 15);
		panel.add(lblContrasea);
		
		txt_pass = new JPasswordField();
		txt_pass.setBounds(170, 39, 175, 19);
		panel.add(txt_pass);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(65, 97, 70, 15);
		panel.add(lblNombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setBounds(170, 95, 175, 19);
		panel.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(65, 124, 70, 15);
		panel.add(lblApellidos);
		
		JLabel lblDniCif = new JLabel("DNI / CIF");
		lblDniCif.setBounds(65, 68, 70, 15);
		panel.add(lblDniCif);
		
		txt_dni = new JTextField();
		txt_dni.setBounds(170, 66, 175, 19);
		panel.add(txt_dni);
		txt_dni.setColumns(10);
		
		txt_ape = new JTextField();
		txt_ape.setBounds(170, 122, 175, 19);
		panel.add(txt_ape);
		txt_ape.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(65, 151, 70, 15);
		panel.add(lblDomicilio);
		
		txt_domicilio = new JTextField();
		txt_domicilio.setBounds(170, 149, 175, 19);
		panel.add(txt_domicilio);
		txt_domicilio.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(65, 178, 70, 15);
		panel.add(lblNivel);
		
		final JComboBox box_nivel = new JComboBox();
		box_nivel.setModel(new DefaultComboBoxModel(new String[] {"Usuario", "Administrador"}));
		box_nivel.setBounds(170, 173, 175, 24);
		panel.add(box_nivel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_user.setText("");
				txt_nombre.setText("");
				txt_dni.setText("");
				txt_ape.setText("");
				txt_domicilio.setText("");
				txt_pass.setText("");
				box_nivel.setSelectedItem(1);
			}
		});
		btnCancelar.setBounds(65, 240, 117, 25);
		panel.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean ok = false;
				ResultSet rs = null;
				try {
					//  VERIFICAR USUARIO
					rs = TpvMain.db.createStatement().executeQuery("select usuario from Usuarios where usuario = '" + txt_user.getText() + "'");
					if(!rs.absolute(1)){
						//  VERIFICAR DNI
						rs = TpvMain.db.createStatement().executeQuery("select dni from Usuarios where dni = '" + txt_dni.getText() + "'");
						if(!rs.absolute(1)){
							// VERIFICAR NULLS
							if(!txt_user.getText().equals("") && !txt_pass.getText().equals("")
									&& !txt_nombre.getText().equals("") && !txt_ape.getText().equals("")
									&& !txt_dni.getText().equals("") && !txt_domicilio.getText().equals("")){
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
								+ txt_user.getText() + "','" + String.valueOf(txt_pass.getPassword()) + "','"
								+ txt_dni.getText() + "','" + txt_nombre.getText() + "','" + txt_ape.getText() + "','"
								+ txt_domicilio.getText() + "','"
								+ GregorianCalendar.getInstance().toInstant().toString().substring(0,10) + "',"
								+ box_nivel.getSelectedIndex()
								+");");
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnGuardar.setBounds(228, 240, 117, 25);
		panel.add(btnGuardar);
		
		
	}
	
	public Usuarios(final int nivel) {
		setLayout(null);
		setSize(500, 400);
		JPanel panel = new JPanel();
		panel.setBounds(12, 5, 476, 283);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(65, 14, 100, 15);
		panel.add(lblUsuario);
		
		txt_user = new JTextField();
		txt_user.setBounds(170, 12, 175, 19);
		panel.add(txt_user);
		txt_user.setColumns(10);
		
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(65, 41, 100, 15);
		panel.add(lblContrasea);
		
		txt_pass = new JPasswordField();
		txt_pass.setBounds(170, 39, 175, 19);
		panel.add(txt_pass);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(65, 97, 70, 15);
		panel.add(lblNombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setBounds(170, 95, 175, 19);
		panel.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(65, 124, 70, 15);
		panel.add(lblApellidos);
		
		JLabel lblDniCif = new JLabel("DNI / CIF");
		lblDniCif.setBounds(65, 68, 70, 15);
		panel.add(lblDniCif);
		
		txt_dni = new JTextField();
		txt_dni.setBounds(170, 66, 175, 19);
		panel.add(txt_dni);
		txt_dni.setColumns(10);
		
		txt_ape = new JTextField();
		txt_ape.setBounds(170, 122, 175, 19);
		panel.add(txt_ape);
		txt_ape.setColumns(10);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(65, 151, 70, 15);
		panel.add(lblDomicilio);
		
		txt_domicilio = new JTextField();
		txt_domicilio.setBounds(170, 149, 175, 19);
		panel.add(txt_domicilio);
		txt_domicilio.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_user.setText("");
				txt_nombre.setText("");
				txt_dni.setText("");
				txt_ape.setText("");
				txt_domicilio.setText("");
				txt_pass.setText("");
			}
		});
		btnCancelar.setBounds(65, 240, 117, 25);
		panel.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean ok = false;
				ResultSet rs = null;
				try {
					//  VERIFICAR USUARIO
					rs = TpvMain.db.createStatement().executeQuery("select usuario from Usuarios where usuario = '" + txt_user.getText() + "'");
					if(!rs.absolute(1)){
						//  VERIFICAR DNI
						rs = TpvMain.db.createStatement().executeQuery("select dni from Usuarios where dni = '" + txt_dni.getText() + "'");
						if(!rs.absolute(1)){
							// VERIFICAR NULLS
							if(!txt_user.getText().equals("") && !txt_pass.getText().equals("")
									&& !txt_nombre.getText().equals("") && !txt_ape.getText().equals("")
									&& !txt_dni.getText().equals("") && !txt_domicilio.getText().equals("")){
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
								+ txt_user.getText() + "','" + String.valueOf(txt_pass.getPassword()) + "','"
								+ txt_dni.getText() + "','" + txt_nombre.getText() + "','" + txt_ape.getText() + "','"
								+ txt_domicilio.getText() + "','"
								+ GregorianCalendar.getInstance().toInstant().toString().substring(0,10) + "',"
								+ nivel
								+");");
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnGuardar.setBounds(228, 240, 117, 25);
		panel.add(btnGuardar);
		
		
	}
	*/
	
	public Usuarios(String user,String pass,String dni,String nombre,String ape,String domicilio){
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
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
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
	
}
