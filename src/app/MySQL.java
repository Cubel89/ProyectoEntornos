package app;

import java.sql.*;
import java.sql.DriverManager;

public class MySQL {
	
	private static final String db = "";
	private static final String url = ""+db;
	private static final String user = "";
	private static final String pass = "";
	
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
}