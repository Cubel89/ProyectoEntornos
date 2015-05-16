package pruebas;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class pruebas { 
	private static final String db = "pepito";
	private static final String url = "jdbc:mysql://127.0.0.1/"+db;
	private static final String user = "root";
	private static final String pass = "online";
	
	public static Connection Connectar(){
		Connection link = null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Conectando ...");
			link = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion establecida con éxito.");
		}catch(Exception e){
			System.out.println(e);
		}
		return link;
	}
	
	
	public static void main(String[] args) {
		Connection db = Connectar();
	}
}