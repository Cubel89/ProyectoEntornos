package pruebas;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Canvas;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class gui extends JPanel{
	public gui() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(445, 0, -435, 491);
		add(panel);
		panel.setLayout(null);
	}
}
