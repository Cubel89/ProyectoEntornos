package pruebas;

import javax.swing.JPasswordField;

public class pruebas {
	public static void main(String[] args) {
		System.out.println("123456".hashCode());
		JPasswordField ee = new JPasswordField();
		ee.setText("123456");
		System.out.println(ee.getPassword());
	}
}
