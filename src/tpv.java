import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class tpv {
	static Connection db;
	static Scanner telado = new Scanner(System.in);
	static void addRegistro(){
		String sentencia = "";
		String desc;
		int stock;
		double precio, iva;
		
		System.out.print("Descipcion: ");
		desc = telado.nextLine();
		System.out.print("Precio: ");
		precio = Double.parseDouble(telado.nextLine());
		System.out.print("IVA: ");
		iva = Double.parseDouble(telado.nextLine());
		System.out.print("Stock: ");
		stock = Integer.parseInt(telado.nextLine());

		sentencia = "INSERT INTO productos(Descripcion, PrecioSinIVA, IVA, PrecioConIVA, Stock) VALUES("
				+"\'" + desc + "\', " + precio + ", " + iva + ", " + precio*(iva/100 + 1) + ", " + stock + ")";
		
		try {
			db.prepareStatement(sentencia).executeUpdate();
			System.out.println("Añadido con existo");
		} catch(SQLException e){
			System.out.println(e);
			System.out.println("ERROR");
		}
	}
	public static void main(String[] args) {
		db = MySQL.Connectar();
		addRegistro();
		
		
		
	}
}
