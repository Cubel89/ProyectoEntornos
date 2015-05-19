package app;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	public static JPanel ver(ResultSet rs){
		JPanel panel = new JPanel();

		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblLinea = new JLabel();
		lblLinea.setPreferredSize(new Dimension(100,15));
	//	lblLinea.setBounds(26, 12, 52, 15);
	//	lblLinea.setSize(100, 15);
		lblLinea.setPreferredSize(new Dimension(52,15));
		lblLinea.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		panel.add(lblLinea);
		
		JLabel lblProducto = new JLabel();
	//	lblProducto.setBounds(90, 12, 70, 15);
		lblProducto.setPreferredSize(new Dimension(70,15));
		lblProducto.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		panel.add(lblProducto);
		
		JLabel lblDesc = new JLabel();
	//	lblDesc.setBounds(172, 12, 324, 15);
		lblDesc.setPreferredSize(new Dimension(324,15));
		lblDesc.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		panel.add(lblDesc);
		
		JLabel lblPrecio = new JLabel();
	//	lblPrecio.setBounds(508, 12, 70, 15);
		lblPrecio.setPreferredSize(new Dimension(70,15));
		lblPrecio.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		panel.add(lblPrecio);
		
		JLabel lblCant = new JLabel();
	//	lblCant.setBounds(590, 12, 44, 15);
		lblCant.setPreferredSize(new Dimension(44,15));
		lblCant.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		panel.add(lblCant);
		
		JLabel lblIva = new JLabel();
	//	lblIva.setBounds(646, 12, 35, 15);
		lblIva.setPreferredSize(new Dimension(35,15));
		lblIva.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		panel.add(lblIva);
		
		JLabel lblTotal = new JLabel();
	//	lblTotal.setBounds(708, 12, 70, 15);
		lblTotal.setPreferredSize(new Dimension(70,15));
		lblTotal.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		panel.add(lblTotal);
		
		
		try {
			lblLinea.setText(rs.getString(2));
			lblProducto.setText(rs.getString(3));
			lblDesc.setText(rs.getString(4));
			lblPrecio.setText(rs.getString(5));
			lblCant.setText(rs.getString(6));
			lblIva.setText(rs.getString(7));
			lblTotal.setText(rs.getString(8));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return panel;
	}
	public static String [] get (ResultSet rs, int colum){
		String [] row = new String[colum];
		try {
			for (int i = 0; i < row.length; i++) {
				row[i] = rs.getString(i+2);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
		
		return row;
	}
}
