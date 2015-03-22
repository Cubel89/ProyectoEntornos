package app;

import java.sql.SQLException;

public class Productos {
	private int codigo, stock;
	private String descripcion;
	private double precio, iva, precioIva;
	
	public Productos(String ee) {
		
	}
	public Productos(String desc, double precio, double iva, int stock){
		String sentencia = "INSERT INTO Productos(descripcion, precio, iva, precioIva, stock) VALUES("
				+"\'" + desc + "\', " + precio + ", " + iva + ", " + precio*(iva/100 + 1) + ", " + stock + ")";
		try {
			TpvMain.db.prepareStatement(sentencia).executeUpdate();
			System.out.println("EEEEEEEEEEEEEEEEEEEEEEE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
}
