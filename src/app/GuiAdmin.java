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
		setSize(850, 450);

		menuBar();
		
		setVisible(true);

	}
	void menuBar(){
		JMenu opciones = TpvMain.menuBar.getMenu(1),
				users = new JMenu("Gestion de usuarios"),
				productos = new JMenu("Gestion de productos");
		
		JMenuItem add = new JMenuItem("Añadir");
		
		opciones.add(users);
		opciones.add(productos);
		
		users.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				repaint();
				add(new Usuarios());
			}
		});
		
	}
}
