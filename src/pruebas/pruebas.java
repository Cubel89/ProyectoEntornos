package pruebas;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class pruebas { 
	public static void main(String[] args) {
		String [] row = new String[7];
			System.out.println("e");
			for (int i = 0; i < 7; i++) {
				row[i] = "e";
			}
			System.out.println(Arrays.toString(row));
		
	}
}