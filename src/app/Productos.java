package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Productos {
	private int codigo, stock;
	private String descripcion;
	private double precio, iva, precioIva;
	
	public Productos() {
	}
	public Productos(String desc, double precio, double iva, int stock){
		String sentencia = "INSERT INTO Productos(descripcion, precio, iva, precioIva, stock) VALUES("
				+"\'" + desc + "\', " + precio + ", " + iva + ", " + precio*(iva/100 + 1) + ", " + stock + ")";
		try {
			TpvMain.db.createStatement().execute(sentencia);
			JOptionPane.showMessageDialog(null, "Producto añadido con exito");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getPrecioIva() {
		return precioIva;
	}
	public void setPrecioIva(double precioIva) {
		this.precioIva = precioIva;
	}
	
	public static void modificar(int codigo, String desc, double precio, double iva, int stock){
		try {
			
			TpvMain.db.createStatement().executeUpdate("UPDATE Productos SET "
					+ "descripcion='" + desc
					+ "', precio=" + precio
					+ ", iva=" + iva
					+ ", precioIva=" + precio*(iva/100 +1)
					+ ", stock=" + stock
					+" WHERE codigo = "+codigo+";");
			JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
	}
	public static void eliminar(int codigo){
		try {
			ResultSet rs = TpvMain.db.createStatement().executeQuery("select codigo from Productos where codigo =" + codigo +";");
			if(rs.absolute(1)){
				if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar el producto " + codigo + " ?") == 0){
					TpvMain.db.createStatement().execute("delete from Productos where codigo = " + codigo +";");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El producto " + codigo + " no existe.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
	}
	public static String[] buscar(int codigo){
		String [] producto = new String[6];
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("select * from Productos where codigo = " + codigo + ";");
			if(rs.absolute(1)){
				for (int i = 0; i < producto.length; i++) {
					producto[i] = rs.getString(i+1);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existe este producto");
				return null;
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
		return producto;
	}
}
