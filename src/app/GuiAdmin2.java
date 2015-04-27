package app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class GuiAdmin2 extends TpvMain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8736058198185258996L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAdmin2 frame = new GuiAdmin2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public GuiAdmin2() {
		super.setVisible(false);
		menuBar.setForeground(new Color(51, 51, 51));
		menuBar.setBackground(new Color(102, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(12, 12, 197, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenu mnGestinDeProductos = new JMenu("Gestión de productos");
		mnGestinDeProductos.setForeground(new Color(255, 255, 255));
		mnGestinDeProductos.setBounds(12, 67, 173, 19);
		panel.add(mnGestinDeProductos);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mnGestinDeProductos.add(mntmBuscar);
		
		JMenuItem mntmAadir_1 = new JMenuItem("Añadir");
		mnGestinDeProductos.add(mntmAadir_1);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mnGestinDeProductos.add(mntmModificar_1);
		
		JMenuItem mntmEliminar_1 = new JMenuItem("Eliminar");
		mnGestinDeProductos.add(mntmEliminar_1);
		
		JMenu mnGestionDeUsuarios = new JMenu("Gestion de usuarios");
		mnGestionDeUsuarios.setForeground(new Color(255, 255, 255));
		mnGestionDeUsuarios.setBounds(12, 98, 173, 19);
		panel.add(mnGestionDeUsuarios);
		
		JMenuItem mntmBuscare = new JMenuItem("Buscar");
		mnGestionDeUsuarios.add(mntmBuscare);
		
		JMenuItem mntmAadir = new JMenuItem("Añadir");
		mnGestionDeUsuarios.add(mntmAadir);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnGestionDeUsuarios.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnGestionDeUsuarios.add(mntmEliminar);
		
		JLabel lbMenu = new JLabel("MENÚ");
		lbMenu.setForeground(new Color(0, 255, 153));
		lbMenu.setFont(new Font("Serif", Font.BOLD, 18));
		lbMenu.setBounds(57, 5, 78, 50);
		panel.add(lbMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(221, 12, 686, 380);
		contentPane.add(panel_1);
	}
	
	
	public void menuBar(){
		
	}
}
