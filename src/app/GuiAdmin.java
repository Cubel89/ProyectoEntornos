package app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class GuiAdmin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public GuiAdmin() {
		setLayout(null);
		//setBounds(0,0,500,300);
		setSize(850, 450);
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(Color.DARK_GRAY));
		panelMenu.setBounds(12, 12, 214, 423);
		add(panelMenu);
		panelMenu.setLayout(null);
		
		final JPanel content = new JPanel();
		content.setBounds(238, 12, 599, 423);
		add(content);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMenu.setForeground(Color.GRAY);
		lblMenu.setBounds(12, 12, 69, 42);
		panelMenu.add(lblMenu);
		
		JMenu mnGestinDeProductos = new JMenu("Gestión de productos");
		mnGestinDeProductos.setBounds(22, 67, 174, 19);
		panelMenu.add(mnGestinDeProductos);
		
		JMenuItem mntmAadir = new JMenuItem("Añadir");
		mnGestinDeProductos.add(mntmAadir);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnGestinDeProductos.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnGestinDeProductos.add(mntmEliminar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnGestinDeProductos.add(mntmConsultar);
		
		JMenu mnGestinDeUsuarios = new JMenu("Gestión de usuarios");
		mnGestinDeUsuarios.setBounds(22, 98, 174, 19);
		panelMenu.add(mnGestinDeUsuarios);
		
		JMenuItem mntmAadir_1 = new JMenuItem("Añadir");
		mntmAadir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				content.removeAll();
				content.repaint();
				content.add(new Usuarios());
			}
		});
		mnGestinDeUsuarios.add(mntmAadir_1);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mnGestinDeUsuarios.add(mntmModificar_1);
		
		JMenuItem mntmEliminar_1 = new JMenuItem("Eliminar");
		mnGestinDeUsuarios.add(mntmEliminar_1);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mnGestinDeUsuarios.add(mntmConsultar_1);
		
		
		setVisible(true);

	}
}
