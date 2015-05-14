package app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GuiCliente extends JPanel {

	private static final long serialVersionUID = -7558889977118792822L;
	private String user;
	private ArrayList<Productos> productos = new ArrayList<Productos>();
	
	public GuiCliente(String user) {
		setLayout(null);
		setSize(850, 450);
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
		
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 0; i < productos.size(); i++) {
            panel.add(new JLabel(productos.get(i).toString()));
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(10, 30, 500, 300);
      
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600, 400));
        contentPane.add(scrollPane);
        
        add(contentPane).setBounds(10, 30, 610, 300);
        contentPane.setVisible(true);
		
		JLabel msn = new JLabel("Hola, " + user + ". Tienes X productos en la cesta.");
	
		
		//add(contentPane);
		
		for (int i = 0; i < productos.size(); i++) {
			System.out.println(productos.get(i));
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
}
