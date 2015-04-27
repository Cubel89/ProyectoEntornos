package app;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(12, 145, 208, 254);
		add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMenu.setForeground(Color.GRAY);
		lblMenu.setBounds(12, 12, 69, 42);
		panelMenu.add(lblMenu);
		
		JPanel content = new JPanel();
		content.setBounds(242, 12, 643, 387);
		add(content);
		
		JLabel lblEeeeeeeeeeeee = new JLabel("EEEEEEEEEEEEE");
		lblEeeeeeeeeeeee.setBounds(12, 56, 70, 15);
		add(lblEeeeeeeeeeeee);

	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel cont = new JPanel();
		frame.setSize(1800,900);
		cont.setSize(1800,900);
		frame.getContentPane().add(cont);
		GuiAdmin pepe = new GuiAdmin();
		pepe.setBounds(10, 10, 400, 400);
		cont.add(pepe);
		frame.setVisible(true);
	}
}
