package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TpvMain {
	static Connection db;
	static Scanner telado = new Scanner(System.in);

	static JFrame gui = new JFrame("TPV");
	static JPanel menu = new JPanel(),
			submenu = new JPanel(),
			content = new JPanel();
	
	
	
	// ???????????????
	static ArrayList<Productos> productos = new ArrayList<Productos>();
	static ArrayList<Clientes> clientes = new ArrayList<Clientes>();
	static ArrayList<Tickets> tickets = new ArrayList<Tickets>();
	static ArrayList<Facturas> facturas = new ArrayList<Facturas>();
	
	
	static void anadirProducto(){
	//	String sentencia = "";
		final JTextField txt_desc = new JTextField(),
				txt_stock = new JTextField(),
				txt_precio = new JTextField(),
				txt_iva = new JTextField();
		JButton guardar = new JButton("Guardar");
		
		content.add(new JLabel("Descipcion: ")).setBounds(30, 30, 150, 30);
		content.add(txt_desc).setBounds(200, 30, 150, 30);
		content.add(new JLabel("Precio: ")).setBounds(30, 80, 150, 30);
		content.add(txt_precio).setBounds(200, 80, 150, 30);
		content.add(new JLabel("IVA: ")).setBounds(30, 130, 150, 30);
		content.add(txt_iva).setBounds(200, 130, 150, 30);
		content.add(new JLabel("Stock: ")).setBounds(30, 180, 150, 30);
		content.add(txt_stock).setBounds(200, 180, 150, 30);

		content.add(guardar).setBounds(200, 300, 150, 30);
/*
		sentencia = "INSERT INTO Productos(descripcion, precio, iva, precioIva, stock) VALUES("
				+"\'" + txt_desc + "\', " + txt_precio + ", " + txt_iva + ", " + txt_precio*(txt_iva/100 + 1) + ", " + txt_stock + ")";
		*/
		
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				productos.add(new Productos(txt_desc.getText().toString(),
						Double.parseDouble(txt_precio.getText()), Double.parseDouble(txt_iva.getText()),
						Integer.parseInt(txt_stock.getText())));
				
				
				JOptionPane.showMessageDialog(null, "Añadido con exito");
				
			}
		});
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		db = MySQL.Connectar();
		
		gui.setSize(1000, 550);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLayout(null);
		

		gui.add(menu).setBounds(10, 10, 230, 480);
		menu.setLayout(null);
		menu.setBorder(BorderFactory.createTitledBorder("Menu"));
		
		gui.add(submenu).setBounds(250, 10, 200, 480);
		submenu.setLayout(null);
		submenu.setBorder(BorderFactory.createTitledBorder("SubMenu"));
		
		gui.add(content).setBounds(460, 10, 520, 480);
		content.setLayout(null);
		content.setBorder(BorderFactory.createTitledBorder("Contenido"));

		menu();
		
	//	gui.pack();
		gui.setVisible(true);
		
	}
	
	static void menu(){
		JButton productos = new JButton("Gestion de productos"),
				clientes = new JButton("Gestion de clientes"),
				ventas = new JButton("Gestion de ventas"),
				facturas = new JButton("Gestion de facturas");

		menu.add(productos).setBounds(10, 30, 210, 30);
		menu.add(clientes).setBounds(10, 70, 210, 30);
		menu.add(ventas).setBounds(10, 110, 210, 30);
		menu.add(facturas).setBounds(10, 150, 210, 30);
		
		menu.add(new JLabel("View in GitHub")).setBounds(10, 150, 180, 530);
		
		
		productos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				submenu.removeAll();
				submenu.repaint();
				gestionProductos();
			}
		});
		
		clientes.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				submenu.removeAll();
				submenu.repaint();
			//	gestionClientes();
			}
		});
		
		ventas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				submenu.removeAll();
				submenu.repaint();
			//	gestionVentas();
			}
		});
		
		facturas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				submenu.removeAll();
				submenu.repaint();
			//	gestionFacturas);
			}
		});
		
	}
	
	static void gestionProductos(){
		JButton anadir = new JButton("Añadir"),
				eliminar = new JButton("Eliminar"),
				importar = new JButton("Importar"),
				exportar = new JButton("Exportar");

		submenu.setBorder(BorderFactory.createTitledBorder("Gestion de Productos"));
		submenu.add(anadir).setBounds(10, 30, 180, 30);
		submenu.add(eliminar).setBounds(10, 70, 180, 30);
		submenu.add(importar).setBounds(10, 110, 180, 30);
		submenu.add(exportar).setBounds(10, 150, 180, 30);
		
		
		anadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				content.removeAll();
				content.repaint();
				anadirProducto();
			}
		});
		
		eliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				content.removeAll();
				content.repaint();
			//	eliminarProducto();
			}
		});
		
		importar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				content.removeAll();
				content.repaint();
			//	eliminarProducto();
			}
		});

		exportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				content.removeAll();
				content.repaint();
			//	eliminarProducto();
			}
		});
	}
}
