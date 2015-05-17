package pruebas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class gui extends JPanel{
	private final JCheckBox checkBox = new JCheckBox("");
	public gui() {
		setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(54, 12, 180, 15);
		add(lblCodigo);
		checkBox.setBounds(12, 4, 21, 30);
		add(checkBox);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(276, 12, 131, 15);
		add(lblFecha);
		
		JLabel lblFacturado = new JLabel("Facturado");
		lblFacturado.setBounds(481, 12, 118, 15);
		add(lblFacturado);
		
		JButton btnDetalles = new JButton("Detalles");
		btnDetalles.setBounds(655, 6, 117, 25);
		add(btnDetalles);
		
		JLabel lblNewLabel = new JLabel("Mis tickets");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 29));
		lblNewLabel.setBounds(66, 78, 366, 45);
		add(lblNewLabel);
		
	}
}
