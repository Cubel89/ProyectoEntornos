import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class Main {
	static Connection db = MySQL.Connectar();
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
			PreparedStatement exec =  (PreparedStatement) db.prepareStatement(sentencia);
			exec.executeUpdate();
			System.out.println("Añadido con existo");
		} catch(SQLException e){
			System.out.println(e);
			System.out.println("ERROR");
		}
	}
	public static void main(String[] args) {
		addRegistro();
		
		
		
	}
}
