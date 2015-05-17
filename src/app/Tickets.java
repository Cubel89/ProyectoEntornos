package app;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class Tickets {
	String codigo;
	ArrayList<LineaTicket> linea;
	

	public Tickets(String user, ArrayList<Productos> cesta) {
		String year = Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.YEAR));
		String mes = Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.MONTH)+1);
		String dia = Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.DAY_OF_MONTH));
		String hora = Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.HOUR_OF_DAY));
		String minuto = Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.MINUTE));

		codigo = year
				+ ((mes.length() == 1)? "0".concat(mes): mes)
				+ ((dia.length() == 1)? "0".concat(dia): dia)
				+ ((hora.length() == 1)? "0".concat(hora): hora)
				+ ((minuto.length() == 1)? "0".concat(minuto): minuto);
		try {
			TpvMain.db.createStatement().execute("insert into Tickets (codigo, cod_cliente, fecha) "
					+ "values (" + codigo + ", '" + user + "','" + year.concat("-").concat(mes).concat("-").concat(dia) + "')");
			int numLinea = 1;
			for (int i = 0; i < cesta.size(); i++) {
				boolean evaluado = false;
				int cant = 0;
				
				for(int j = i-1; j >= 0; j--){
					if(cesta.get(j).equals(cesta.get(i))){
						evaluado = true;
					}
				}
				
				if(!evaluado){
		           	for (int j = i; j < cesta.size(); j++) {
						if(cesta.get(i).equals(cesta.get(j))){
							cant++;
						}
					}
					new LineaTicket(codigo, numLinea++,cesta.get(i), cant);
				}
	        }
			JOptionPane.showMessageDialog(null, "Su pedido se realizo correctamente.");
			
		} catch(MySQLIntegrityConstraintViolationException e){
			JOptionPane.showMessageDialog(null, "No se pueden hacer dos tickets en el mismo minuto.\n"
					+ "Por favor, espere un poco.");
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
			System.out.println(e);
		}
	}
	public static JPanel ver(ResultSet rs){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		panel.setPreferredSize(new Dimension(790,40));
		
		JCheckBox checkBox = new JCheckBox("");
		
		JLabel lblCodigo = new JLabel("");
		lblCodigo.setBounds(54, 12, 180, 15);
		panel.add(lblCodigo);
		checkBox.setBounds(12, 4, 21, 30);
		panel.add(checkBox);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(276, 12, 131, 15);
		panel.add(lblFecha);
		
		JLabel lblFacturado = new JLabel("Facturado");
		lblFacturado.setBounds(481, 12, 118, 15);
		panel.add(lblFacturado);
		
		JButton btnDetalles = new JButton("Detalles");
		btnDetalles.setBounds(655, 6, 117, 25);
		panel.add(btnDetalles);
		
		try {
			lblCodigo.setText(rs.getString(1));
			lblFecha.setText(rs.getString(3));
			lblFacturado.setText((rs.getString(4) != null)? rs.getString(4): "No");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return panel;
	}
}