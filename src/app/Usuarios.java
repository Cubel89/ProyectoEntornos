package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JPanel{
	
	private String user, pass, dni, nombre, ape, domicilio;
	private GregorianCalendar fechaAlta;
	private int nivel;
	private JTextField txt_user;
	private JPasswordField txt_pass;
	private JTextField txt_nombre;
	private JTextField txt_dni;
	private JTextField txt_ape;
	private JTextField txt_domicilio;
	
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
}
