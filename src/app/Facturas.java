package app;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Facturas {
	private String numero;
	private String cif = "00000000T";
	private String razonSocial = "Phone TPV";
	private String fecha;
	private ArrayList<Tickets> tickets = new ArrayList<Tickets>();
	
	public Facturas(ArrayList<Tickets> tickets){
		fecha = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR) + "-"
				+ GregorianCalendar.getInstance().get(GregorianCalendar.MONTH) + "-"
				+ GregorianCalendar.getInstance().get(GregorianCalendar.DAY_OF_MONTH);
		try {
			
			TpvMain.db.createStatement().execute("insert into Facturas (cif, razonSocial, fecha) values"
					+ "('" + cif + "', '" + razonSocial + "','" + fecha +"')"
					+ ";");
			
			ResultSet rs = TpvMain.db.createStatement().executeQuery("select numero from Facturas where numero = (select max(numero) from Facturas);");
			
			rs.absolute(1);
			
			for (int i = 0; i < tickets.size(); i++) {
				TpvMain.db.createStatement().execute("update Tickets set num_factura = '" + rs.getString(1) + "' where codigo = '" + tickets.get(i).getCodigo() + "';");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Facturas(ResultSet rs){
		try {
			numero = rs.getString(1);
			razonSocial = rs.getString(3);
			fecha = rs.getString(4);
			
			rs = TpvMain.db.createStatement().executeQuery("SELECT * FROM tpv.Tickets where num_factura='" + numero + "';");
			
			while (rs.next()) {
				tickets.add(new Tickets(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public JPanel ver(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		panel.setPreferredSize(new Dimension(790,40));
		
		final JLabel lblCodigo = new JLabel(numero);
		lblCodigo.setBounds(54, 12, 180, 15);
		panel.add(lblCodigo);
		
		JLabel lblFecha = new JLabel(fecha);
		lblFecha.setBounds(276, 12, 131, 15);
		panel.add(lblFecha);
		
		JLabel lblCif = new JLabel(cif);
		lblCif.setBounds(481, 12, 118, 15);
		panel.add(lblCif);
		
		JButton btnDetalles = new JButton("Detalles");
		btnDetalles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				detalles();
			}
		});
		btnDetalles.setBounds(655, 6, 117, 25);
		panel.add(btnDetalles);
		
		return panel;
	}
	void detalles(){
		JFrame frame = new JFrame("Factura" + numero);
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblTicket = new JLabel("Factura: " + numero);
		lblTicket.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblTicket);
		
		JLabel lblArticulos = new JLabel("Tickets: " + tickets.size());
		lblArticulos.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblArticulos);
		
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("select cod_cliente from Tickets where num_factura = '" + numero + "';");
			rs.absolute(1);
			JLabel lblCliente = new JLabel("Cliente: " + rs.getString(1));
			lblCliente.setFont(new Font("Dialog", Font.BOLD, 14));
			panel.add(lblCliente);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblFecha = new JLabel("Fecha: " + fecha);
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblFecha);
		/*
		String[][] data = null;
		int cant = 0, total = 0;
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("select count(*) from LineasTicket where cod_ticket ='" + numero + "';");
			rs.absolute(1);
			data = new String[rs.getInt(1)][7];
			rs = TpvMain.db.createStatement().executeQuery("select * from LineasTicket where cod_ticket ='" + numero + "';");
			while(rs.next()){
				data[rs.getRow()-1] = LineaTicket.get(rs, 7);
				total += rs.getDouble(8);
				cant += rs.getDouble(6);
			}
			rs = TpvMain.db.createStatement().executeQuery("select fecha from Tickets where codigo = '" + numero + "';");
			rs.absolute(1);
			lblFecha.setText(lblFecha.getText() + rs.getString(1));
			*/
		double total = 0;
		for (int i = 0; i < tickets.size(); i++) {
			panel.add(tickets.get(i).detallesFactura());
			total += tickets.get(i).getTotal();
		}
		
		/*
		
	    Object[] colum = {"Linea", "Producto", "Descripcion", "Precio","Cant.","IVA","TOTAL"};
	    
	    JTable table = new JTable(data, colum);
	    JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 52, 600, 50);
		panel.add(scrollPane);

		table.setRowSelectionAllowed(false);
		table.setShowVerticalLines(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JLabel lblTotal = new JLabel("Total: " + total + " €");
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblTotal);
		
		lblArticulos.setText(lblArticulos.getText() + cant);
		*/

		JLabel lblTotal = new JLabel("Total: " + total);
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblTotal);
		
		frame.pack();
		frame.setVisible(true);
		
		
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Tickets> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Tickets> tickets) {
		this.tickets = tickets;
	}
	
}
