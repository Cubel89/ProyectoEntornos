package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Productos {
	private int codigo, stock;
	private String descripcion;
	private double precio, iva, precioIva;
	
	public Productos() {
	}
	public Productos(String desc, double precio, double iva, int stock){
		String sentencia = "INSERT INTO Productos(descripcion, precio, iva, precioIva, stock) VALUES("
				+"\'" + desc + "\', " + precio + ", " + iva + ", " + precio*(iva/100 + 1) + ", " + stock + ")";
		try {
			TpvMain.db.createStatement().execute(sentencia);
			JOptionPane.showMessageDialog(null, "Producto añadido con exito");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}
	public Productos(ResultSet rs){
		try {
			codigo = rs.getInt(1);descripcion = rs.getString(2);
			precio = rs.getDouble(3);
			iva = rs.getDouble(4);
			precioIva = rs.getDouble(5);
			stock = rs.getInt(6);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se han podido cargar los productos");
		}
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getPrecioIva() {
		return precioIva;
	}
	public void setPrecioIva(double precioIva) {
		this.precioIva = precioIva;
	}
	
	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", stock=" + stock
				+ ", descripcion=" + descripcion + ", precio=" + precio
				+ ", iva=" + iva + ", precioIva=" + precioIva + "]";
	}
	public static void modificar(int codigo, String desc, double precio, double iva, int stock){
		try {
			
			TpvMain.db.createStatement().executeUpdate("UPDATE Productos SET "
					+ "descripcion='" + desc
					+ "', precio=" + precio
					+ ", iva=" + iva
					+ ", precioIva=" + precio*(iva/100 +1)
					+ ", stock=" + stock
					+" WHERE codigo = "+codigo+";");
			JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
	}
	public static void eliminar(int codigo){
		try {
			ResultSet rs = TpvMain.db.createStatement().executeQuery("select codigo from Productos where codigo =" + codigo +";");
			if(rs.absolute(1)){
				if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar el producto " + codigo + " ?") == 0){
					TpvMain.db.createStatement().execute("delete from Productos where codigo = " + codigo +";");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El producto " + codigo + " no existe.");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error.");
		}
	}
	public static String[] buscar(int codigo){
		String [] producto = new String[6];
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("select * from Productos where codigo = " + codigo + ";");
			if(rs.absolute(1)){
				for (int i = 0; i < producto.length; i++) {
					producto[i] = rs.getString(i+1);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existe este producto");
				return null;
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
		return producto;
	}
	
	public JPanel comprar(final int i, final int color){
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(790,80));

	//	panel.setSize(790, 80);
		panel. setLayout(null);
        
        JLabel lblProducto = new JLabel("Producto: " + descripcion);
        lblProducto.setBounds(12, 12, 599, 15);
        panel. add(lblProducto);
        
        JLabel lblCodigo = new JLabel("Codigo: " + codigo);
        lblCodigo.setBounds(623, 12, 155, 15);
        panel.add(lblCodigo);
        
        JLabel lblPrecio = new JLabel("Precio: " + precio + " €");
        lblPrecio.setBounds(12, 39, 130, 15);
        panel.add(lblPrecio);
        
        JLabel lblIva = new JLabel("IVA: " + iva + "%");
        lblIva.setBounds(154, 39, 95, 15);
        panel.add(lblIva);
        
        JLabel lblPrecioIvaInc = new JLabel("Precio Iva Inc.: " + precioIva + " €");
        lblPrecioIvaInc.setBounds(261, 39, 194, 15);
        panel.add(lblPrecioIvaInc);
        
        final JLabel lblStock = new JLabel("Stock: " + stock);
        lblStock.setBounds(467, 39, 100, 15);
        panel.add(lblStock);
        

		final JTextField txtCantidad;
        txtCantidad = new JTextField();
        txtCantidad.setText("1");
        txtCantidad.setBounds(730, 39, 40, 27);
        panel.add(txtCantidad);
        txtCantidad.setColumns(10);
        
        final JButton btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(txtCantidad.getText());
				if(stock >= cantidad){
					for (int j = 0; j < cantidad; j++) {
						GuiCliente.getCesta().add(GuiCliente.getProductos().get(i));
					}
					stock -= cantidad;
					lblStock.setText(("Stock: " + stock));
					if(stock == 0){
						lblStock.setForeground(Color.RED);
			        	btnComprar.setEnabled(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No hay suficiente stock");
				}
				
				
			}
		});
        btnComprar.setBounds(620, 39, 100, 25);
        panel.add(btnComprar);
		
        if(color %2 == 0){
        	panel.setBackground(SystemColor.control);
        }
        if(stock > 0){
        	lblStock.setForeground(new Color(0, 100, 0));
        } else {
        	lblStock.setForeground(Color.RED);
        	btnComprar.setEnabled(false);
        }
        return panel;
	}
	
	public JPanel cesta(final int i, final int color, final int cant){
		final JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(790,80));

		panel. setLayout(null);
        
        JLabel lblProducto = new JLabel("Producto: " + descripcion);
        lblProducto.setBounds(12, 12, 460, 15);
        panel. add(lblProducto);
        
        JLabel lblCodigo = new JLabel("Codigo: " + codigo);
        lblCodigo.setBounds(623, 12, 155, 15);
        panel.add(lblCodigo);
        
        JLabel lblPrecio = new JLabel("Precio: " + precio + " €");
        lblPrecio.setBounds(12, 39, 130, 15);
        panel.add(lblPrecio);
        
        JLabel lblIva = new JLabel("IVA: " + iva + "%");
        lblIva.setBounds(154, 39, 95, 15);
        panel.add(lblIva);
        
        JLabel lblPrecioIvaInc = new JLabel("Precio Iva Inc.: " + precioIva + " €");
        lblPrecioIvaInc.setBounds(261, 39, 194, 15);
        panel.add(lblPrecioIvaInc);
        
        final JLabel lblCantidad = new JLabel("Cantidad: " + cant);
        lblCantidad.setBounds(467, 39, 100, 15);
        panel.add(lblCantidad);
        
        final JLabel lblTotal = new JLabel("Total: " + cant*precioIva);
        lblTotal.setBounds(467, 10, 100, 15);
        lblTotal.setForeground(Color.RED);
        panel.add(lblTotal);
        
       final int []cantA = {cant};
        
        final JButton btnMenos = new JButton(new ImageIcon("src/menos.png"));
        btnMenos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int k = -1;
				for (int j = 0; j < GuiCliente.getCesta().size(); j++) {
					if(GuiCliente.getCesta().get(j).getCodigo() == codigo){
						k = j;
						break;
					}
				}
				if(k != -1){
					GuiCliente.getCesta().remove(k);
					cantA[0]--;
					lblCantidad.setText("Cantidad: " + cantA[0]);
			        lblTotal.setText("Total: " + cantA[0]*precioIva);
			        stock++;
			        if(cantA[0] == 0){
						panel.removeAll();
						panel.repaint();
						panel.setVisible(false);
			        }
				}
			}
		});
        btnMenos.setBounds(620, 35, 30, 30);
        panel.add(btnMenos);
        
        final JButton btnMas = new JButton(new ImageIcon("src/mas.png"));
        btnMas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int k = -1;
				for (int j = 0; j < GuiCliente.getProductos().size(); j++) {
					if(GuiCliente.getProductos().get(j).getCodigo() == codigo){
						k = j;
						break;
					}
				}
				if(k != -1){
					if(stock > 0){
						GuiCliente.getCesta().add(GuiCliente.getProductos().get(k));
						cantA[0]++;
						lblCantidad.setText("Cantidad: " + cantA[0]);
				        lblTotal.setText("Total: " + cantA[0]*precioIva);
				        stock--;
					} else {
						JOptionPane.showMessageDialog(null, "Ya no hay mas stock.");
					}
					
			       
				}
			}
		});
        btnMas.setBounds(655, 35, 30, 30);
        panel.add(btnMas);
        
        final JButton btnEliminar = new JButton(new ImageIcon("src/papelera.png"));
        btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int j = 0; j < GuiCliente.getCesta().size(); j++) {
					if(codigo == GuiCliente.getCesta().get(j).getCodigo()){
						GuiCliente.getCesta().remove(j);
						j--;
						
					}
				}
				stock += cantA[0];
				cantA[0] = 0;
				panel.removeAll();
				panel.repaint();
				panel.setVisible(false);
			}
		});
        btnEliminar.setBounds(690, 35, 30, 30);
        panel.add(btnEliminar);
        
        
        if(color %2 == 0){
        	panel.setBackground(SystemColor.control);
        }
        
    	lblCantidad.setForeground(new Color(204, 153, 0));
        
        return panel;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		if (codigo != other.codigo)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (Double.doubleToLongBits(iva) != Double.doubleToLongBits(other.iva))
			return false;
		if (Double.doubleToLongBits(precio) != Double
				.doubleToLongBits(other.precio))
			return false;
		if (Double.doubleToLongBits(precioIva) != Double
				.doubleToLongBits(other.precioIva))
			return false;
		return true;
	}
	
}
