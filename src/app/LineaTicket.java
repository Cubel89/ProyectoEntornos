package app;

import java.sql.SQLException;

import javax.swing.JPanel;

public class LineaTicket {
	
	public LineaTicket(String ticket, int numLinea, Productos producto, int cant) {
		try {
			TpvMain.db.createStatement().execute("insert into LineasTicket values ('"
					+ ticket + "'," + numLinea + "," + producto.getCodigo() + ",'"
					+ producto.getDescripcion() +"'," + producto.getPrecioIva() + ","
					+ cant + "," + producto.getIva() + "," + (producto.getPrecioIva()*cant)
					+");");
			TpvMain.db.createStatement().execute("update Productos set stock = (stock -" + cant + ") where codigo = " + producto.getCodigo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public JPanel ver(){
		return null;
	}
}
