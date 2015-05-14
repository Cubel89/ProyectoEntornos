package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GuiCliente extends JPanel {

	private static final long serialVersionUID = -7558889977118792822L;
	private String user;
	
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
		comprar();
	}
	
	void comprar(){
		removeAll();
		repaint();
		JLabel epe = new JLabel("EEEEEEEEEEEEEEE");
		add(epe);
		epe.setBounds(10, 10, 300, 30);
		
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
}
