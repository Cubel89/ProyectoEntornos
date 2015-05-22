package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GuiCliente extends JPanel {

	private static final long serialVersionUID = -7558889977118792822L;
	protected String user;
//	private JPanel panelScroll = null;
	protected JMenu opciones = TpvMain.menuBar.getMenu(1);
	private static ArrayList<Productos> productos = new ArrayList<Productos>();
	private static ArrayList<Productos> cesta = new ArrayList<Productos>();
//	private static ArrayList<Tickets> tickets = new ArrayList<Tickets>();
	
	public GuiCliente(String user) {
		setLayout(null);
		TpvMain.frame.setSize(860, 510);
		setSize(850, 500);
		this.user = user;
		
	
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
		cargarProductos();
		comprar();
	}
	
	void comprar(){
		removeAll();
		repaint();
		
		JLabel hola = new JLabel("Hola, " + user);
        JLabel infoCesta = new JLabel("Tienes " + cesta.size() + " productos en la cesta.");
        add(hola).setBounds(10, 10, 300, 20);;
        add(infoCesta).setBounds(10, 35, 300, 20);
        
        JButton btnCesta = new JButton("Ir a la cesta");
        btnCesta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cesta();
				
			}
		});
        add(btnCesta).setBounds(620,10,200,20);
        btnCesta.setBackground(Color.orange);
        
        final JTextField txtBuscar = new JTextField("");
        JLabel lblBuscar = new JLabel("Buscar");
        JButton btnBuscar = new JButton("Buscar");
		
        add(lblBuscar).setBounds(380, 33, 80,20);
        add(txtBuscar).setBounds(470, 33, 240,20);
        add(btnBuscar).setBounds(720, 33, 100,20);
        
        final JPanel panelScroll = scrolling();
        
		listarProductos(panelScroll, txtBuscar.getText());
        
        btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarProductos(panelScroll, txtBuscar.getText());
			}
		});
        
	}
	JPanel scrolling(){
		JPanel panelScroll = new JPanel();
        panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));
		
        JScrollPane scrollPane = new JScrollPane(panelScroll);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     //   scrollPane.setAutoscrolls(true);
        scrollPane.setBounds(10, 30, 800, 380);
      
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(800, 380));
        contentPane.add(scrollPane);
        
        add(contentPane).setBounds(10, 30, 830, 410);
        return panelScroll;
	}
	void listarProductos(JPanel panel, String buscar){
		panel.removeAll();
		panel.repaint();
		for (int i = 0, color = 0; i < productos.size(); i++) {
			if(productos.get(i).getDescripcion().indexOf(buscar) != -1
					|| Integer.toString(productos.get(i).getCodigo()).indexOf(buscar) != -1){
				panel.add(productos.get(i).comprar(i, color++));
			}
           	
        }
	}
	void cesta(){
		removeAll();
		repaint();
		
		JLabel lblCesta = new JLabel("Mi Cesta");
		lblCesta.setFont(new Font("Dialog", Font.BOLD, 29));
		lblCesta.setBounds(20, 10, 360, 45);
		add(lblCesta);
		
		JButton btnHacerPedido = new JButton("Realizar pedido");
		btnHacerPedido.setFont(new Font("Dialog", Font.BOLD, 16));
		btnHacerPedido.setBackground(new Color(0, 255, 0));
		btnHacerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cesta.size() > 0){
					new Tickets(user, cesta);
					cesta.clear();
					tickets();
				} else {
					JOptionPane.showMessageDialog(null, "Tienes la cesta vacia, para realizar un pedido tienes que comprar algo.");
				}
			}
		});
		btnHacerPedido.setBounds(590, 10, 230, 45);
		add(btnHacerPedido);
		
		final JPanel panel = scrolling();
		
		for (int i = 0, color = 0; i < cesta.size(); i++) {
			boolean evaluado = false;
			int cant = 0;
			
			for(int j = i-1; j >= 0; j--){
				if(cesta.get(j).equals(cesta.get(i))){
					evaluado = true;
				}
			}
			
			if(!evaluado){
	           	for (int j = i; j < cesta.size(); j++) {
					if(cesta.get(i).equals(cesta.get(j))){
						cant++;
					}
				}
				panel.add(cesta.get(i).cesta(i, color++, cant));
			}
        }
		
		
		
	}
	void tickets(){
		removeAll();
		repaint();
		final ArrayList<Tickets> tickets = new ArrayList<Tickets>();
		
		
		JLabel lblTickets = new JLabel("Mis tickets");
		lblTickets.setFont(new Font("Dialog", Font.BOLD, 29));
		lblTickets.setBounds(20, 10, 360, 45);
		add(lblTickets);
		
		JButton btnFactura = new JButton("Solicitar factura");
		btnFactura.setFont(new Font("Dialog", Font.BOLD, 16));
		btnFactura.setBackground(new Color(0, 255, 0));
		btnFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Tickets> checks = new ArrayList<Tickets>();
				for (int i = 0; i < tickets.size(); i++) {
					if(tickets.get(i).getCheckBox().isSelected()){
						checks.add(tickets.get(i));
					}
				}
				if(checks.size() > 0){
					new Facturas(checks);
					facturas();
				} else {
					JOptionPane.showMessageDialog(null, "Selecciona como minimo un ticket");
				}
			}
		});
		btnFactura.setBounds(590, 10, 230, 45);
		add(btnFactura);
		
		
		JPanel panel = scrolling();
		
		
		
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("select * from Tickets where cod_cliente ='" + user + "' order by fecha desc;");
			while (rs.next()) {
				tickets.add(new Tickets(rs));
				panel.add(tickets.get(tickets.size()-1).ver());
			//	panel.add(Tickets.ver(rs));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void facturas(){
		removeAll();
		repaint();
		removeAll();
		repaint();
		final ArrayList<Facturas> facturas = new ArrayList<Facturas>();
	//	final ArrayList<Tickets> tickets = new ArrayList<Tickets>();
		
		
		JLabel lblFacturas = new JLabel("Mis Facturas");
		lblFacturas.setFont(new Font("Dialog", Font.BOLD, 29));
		lblFacturas.setBounds(20, 10, 360, 45);
		add(lblFacturas);
		
		
		JPanel panel = scrolling();
		
		
		
		ResultSet rs;
		try {
			rs = TpvMain.db.createStatement().executeQuery("SELECT DISTINCT f.* FROM Facturas f, Tickets t where t.num_factura = f.numero and t.cod_cliente='" + user + "' order by numero desc;");
			while (rs.next()) {
				facturas.add(new Facturas(rs));
			}
			for (int i = 0; i < facturas.size(); i++) {
				panel.add(facturas.get(i).ver());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void perfil(){
		removeAll();
		repaint();
		final JTextField txt1, txt2, txt3, txt4,txt5,txt6;
		final JPasswordField txtPass;
		
		JLabel lblPerfil = new JLabel("Mi Perfil");
		lblPerfil.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPerfil.setBounds(20, 10, 360, 45);
		add(lblPerfil);
	
		JLabel lblUsuario_1 = new JLabel("Usuario");
		lblUsuario_1.setBounds(78, 54, 116, 15);
		add(lblUsuario_1);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(78, 81, 116, 15);
		add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(78, 135, 116, 15);
		add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(78, 162, 116, 15);
		add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(78, 189, 116, 15);
		add(lblDireccion);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(78, 108, 116, 15);
		add(lblDni);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setBounds(212, 54, 166, 19);
		add(txt1);
		txt1.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(212, 81, 166, 19);
		add(txtPass);
		
		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setBounds(212, 108, 166, 19);
		add(txt3);
		txt3.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(212, 135, 166, 19);
		add(txt2);
		txt2.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(212, 162, 166, 19);
		add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(212, 189, 166, 19);
		add(txt5);
		txt5.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(78, 216, 70, 15);
		add(lblFecha);
		
		txt6 = new JTextField();
		txt6.setBounds(212, 215, 166, 19);
		add(txt6);
		txt6.setEditable(false);
		txt6.setColumns(10);
		
		final String [] datos = Usuarios.buscar(user);
		txt1.setText(datos[0]);
		txtPass.setText(datos[1]);
		txt3.setText(datos[2]);
		txt2.setText(datos[3]);
		txt4.setText(datos[4]);
		txt5.setText(datos[5]);
		txt6.setText(datos[6]);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] datos = Usuarios.buscar(user);
				txt1.setText(datos[0]);
				txtPass.setText(datos[1]);
				txt3.setText(datos[2]);
				txt2.setText(datos[3]);
				txt4.setText(datos[4]);
				txt5.setText(datos[5]);
				txt6.setText(datos[6]);
			}
		});
		btnCancelar.setBounds(77, 290, 140, 25);
		add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Usuarios.modificar(txt1.getText(), String.valueOf(txtPass.getPassword()),
						txt2.getText(), txt4.getText(),
						txt5.getText(),txt6.getText(),Integer.parseInt(datos[7]));
				
			}
		});
		btnGuardar.setBounds(240, 290, 140, 25);
		add(btnGuardar);
		
		
	}
	void cargarProductos(){
		ResultSet rs;
		try{
			rs = TpvMain.db.createStatement().executeQuery("select * from Productos");
			while(rs.next()){
				productos.add(new Productos(rs));
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error intentando cargas los productos");
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public static ArrayList<Productos> getProductos() {
		return productos;
	}

	public static void setProductos(ArrayList<Productos> productos) {
		GuiCliente.productos = productos;
	}

	public static ArrayList<Productos> getCesta() {
		return cesta;
	}

	public static void setCesta(ArrayList<Productos> cesta) {
		GuiCliente.cesta = cesta;
	}
	
}
