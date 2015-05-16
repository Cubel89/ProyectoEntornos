package pruebas;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gui extends JPanel{
	private JTextField textField;
	public gui() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(348, 139, 70, 15);
		lblNewLabel.setForeground(new Color(204, 153, 0));
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(168, 293, 114, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("/home/quique/git/ProyectoEntornos/src/menos.png"));
		//btnNewButton.setBounds(109, 34, , 30);
		add(btnNewButton);
		
	}
}
