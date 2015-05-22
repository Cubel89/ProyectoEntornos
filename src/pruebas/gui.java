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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class gui extends JPanel{
	private JTable table;
	private JTable table_1;
	private JTextField fInicio;
	private JTextField fFin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public gui() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 97, 600, 50);
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
		
		JRadioButton rdbtnListadoDeVentas = new JRadioButton("Listado de ventas realizadas agrupadas por clientes");
		buttonGroup.add(rdbtnListadoDeVentas);
		rdbtnListadoDeVentas.setSelected(true);
		rdbtnListadoDeVentas.setBounds(8, 0, 426, 15);
		add(rdbtnListadoDeVentas);
		
		JRadioButton rdbtnListadoDeVentas_1 = new JRadioButton("Listado de ventas realizadas a un cliente");
		buttonGroup.add(rdbtnListadoDeVentas_1);
		rdbtnListadoDeVentas_1.setBounds(8, 19, 426, 15);
		add(rdbtnListadoDeVentas_1);
		
		JRadioButton rdbtnRankingDeProductos = new JRadioButton("Ranking de productos mas vendidos");
		buttonGroup.add(rdbtnRankingDeProductos);
		rdbtnRankingDeProductos.setBounds(8, 38, 426, 15);
		add(rdbtnRankingDeProductos);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setBounds(448, 0, 88, 15);
		add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin:");
		lblFechaFin.setBounds(448, 19, 88, 15);
		add(lblFechaFin);
		
		fInicio = new JTextField();
		fInicio.setText("01-01-2015");
		fInicio.setBounds(554, 0, 88, 15);
		add(fInicio);
		fInicio.setColumns(10);
		
		fFin = new JTextField();
		fFin.setText("22-05-2015");
		fFin.setBounds(554, 19, 88, 15);
		add(fFin);
		fFin.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(490, 38, 104, 15);
		add(btnListar);
		
		
		
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
