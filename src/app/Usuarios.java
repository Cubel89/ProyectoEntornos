package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Usuarios {
	
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
				return null;
			}
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
		return usuario;
	}
	public static boolean existe(String usuario){
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("select usuario from Usuarios where usuario = '" + usuario + "'");
			if(rs.absolute(1)){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "El usuario no existe");
		return false;
	}
}
