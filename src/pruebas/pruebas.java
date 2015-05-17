package pruebas;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class pruebas { 
	public static void main(String[] args) {
		System.out.println(GregorianCalendar.getInstance().get(GregorianCalendar.YEAR));
		System.out.println();
	}
}