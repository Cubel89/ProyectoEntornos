package pruebas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;

public class gui extends JPanel{
	private JTable table;
	private JTable table_1;
	public gui() {
		setLayout(null);
		
		JLabel lblLinea = new JLabel("Linea");
		lblLinea.setBounds(12, 12, 39, 15);
		add(lblLinea);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(70, 12, 64, 15);
		add(lblProducto);
		
		JLabel lblDesc = new JLabel("Descripcion");
		lblDesc.setBounds(154, 12, 376, 15);
		add(lblDesc);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(542, 12, 87, 15);
		add(lblPrecio);
		
		JLabel lblCant = new JLabel("Cant.");
		lblCant.setBounds(641, 12, 38, 15);
		add(lblCant);
		
		JLabel lblIva = new JLabel("Iva");
		lblIva.setBounds(691, 12, 20, 15);
		add(lblIva);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(723, 12, 62, 15);
		add(lblTotal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 52, 600, 50);
		add(scrollPane);
		
		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setRowSelectionAllowed(false);
		table_1.setShowVerticalLines(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(99, 92, 600, 30);
		scrollPane.setViewportView(table_1);
		
		
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setContentPane(panel);
		String[][] data = {{"Pepe", "Last Name", "Sport", "# of Years", "Vegetarian"},
				{"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"},
				{"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"},
				{"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"}};
	    Object[] colum = {"First Name", "Last Name", "Sport", "# of Years","ee"};
	    
	    JTable table = new JTable(data, colum);
	    panel.add(table);
	    frame.pack();
	    frame.setVisible(true);
	
	}
}
