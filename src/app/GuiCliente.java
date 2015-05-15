package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GuiCliente extends JPanel {

	private static final long serialVersionUID = -7558889977118792822L;
	private String user;
	private static ArrayList<Productos> productos = new ArrayList<Productos>();
	private static ArrayList<Productos> cesta = new ArrayList<Productos>();
	
	public GuiCliente(String user) {
		setLayout(null);
		TpvMain.frame.setSize(860, 510);
		setSize(850, 500);
		this.user = user;
		JMenu opciones = TpvMain.menuBar.getMenu(1);
	
		JMenuItem mntmComprar = new JMenuItem("Seguir comprando");
		mntmComprar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comprar();				
			}
		});
		opciones.add(mntmComprar);
		
		JMenuItem mntmCesta = new JMenuItem("Cesta de la compra");
		opciones.add(mntmCesta);
		mntmCesta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cesta();				
			}
		});
		JMenuItem mntmTickets = new JMenuItem("Mis tickets");
		opciones.add(mntmTickets);
		mntmTickets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tickets();				
			}
		});
		JMenuItem mntmFacturas = new JMenuItem("Mis Facturas");
		opciones.add(mntmFacturas);
		mntmFacturas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				facturas();
			}
		});
		
		JMenuItem mntmPerfil = new JMenuItem("Editar perfil");
		opciones.add(mntmPerfil);
		mntmPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				perfil();			
			}
		});
		
		setVisible(true);
		cargarProductos();
		comprar();
	}
	
	void comprar(){
		removeAll();
		repaint();
		
		JLabel hola = new JLabel("Hola, " + user);
        JLabel infoCesta = new JLabel("Tienes " + cesta.size() + " productos en la cesta.");
        add(hola).setBounds(10, 10, 300, 20);;
        add(infoCesta).setBounds(10, 35, 300, 20);
        
        JButton cesta = new JButton("Ir a la cesta");
        add(cesta).setBounds(620,10,200,20);
        cesta.setBackground(Color.orange);
        
        final JTextField txtBuscar = new JTextField("");
        JLabel lblBuscar = new JLabel("Buscar");
        JButton btnBuscar = new JButton("Buscar");
		
        add(lblBuscar).setBounds(380, 33, 80,20);
        add(txtBuscar).setBounds(470, 33, 240,20);
        add(btnBuscar).setBounds(720, 33, 100,20);
        
        
        
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		listarProductos(panel, txtBuscar.getText());
        
        btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarProductos(panel, txtBuscar.getText());
				/*
				panel.removeAll();
				panel.repaint();
				System.out.println("e");
				for (int i = 0, color = 0; i < productos.size(); i++) {
					if(productos.get(i).getDescripcion().indexOf(txtBuscar.getText()) != -1
							|| Integer.toString(productos.get(i).getCodigo()).indexOf(txtBuscar.getText()) != -1){
						panel.add(productos.get(i).comprar(i, color++));
					}
		           	
		        }
		        */
				
			}
		});
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setAutoscrolls(true);
        scrollPane.setBounds(10, 30, 800, 380);
      
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(800, 380));
        contentPane.add(scrollPane);
      //  scrollPane.setViewportView(contentPane);
        
        add(contentPane).setBounds(10, 30, 830, 410);
      
        contentPane.setVisible(true);
        
	}
	void listarProductos(JPanel panel, String buscar){
		panel.removeAll();
		panel.repaint();
		System.out.println("e");
		for (int i = 0, color = 0; i < productos.size(); i++) {
			if(productos.get(i).getDescripcion().indexOf(buscar) != -1
					|| Integer.toString(productos.get(i).getCodigo()).indexOf(buscar) != -1){
				panel.add(productos.get(i).comprar(i, color++));
			}
           	
        }
	}
	void cesta(){
		removeAll();
		repaint();
		
	}
	void tickets(){
		removeAll();
		repaint();
		
	}
	void facturas(){
		removeAll();
		repaint();
		
	}
	void perfil(){
		removeAll();
		repaint();
		
	}
	void cargarProductos(){
		ResultSet rs;
		try{
			rs = TpvMain.db.createStatement().executeQuery("select * from Productos");
			while(rs.next()){
				productos.add(new Productos(rs));
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error intentando cargas los productos");
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public static ArrayList<Productos> getProductos() {
		return productos;
	}

	public static void setProductos(ArrayList<Productos> productos) {
		GuiCliente.productos = productos;
	}

	public static ArrayList<Productos> getCesta() {
		return cesta;
	}

	public static void setCesta(ArrayList<Productos> cesta) {
		GuiCliente.cesta = cesta;
	}
	
}
