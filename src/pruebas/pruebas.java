package pruebas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class pruebas { 
    
    /** Creates a new instance of PruebaJScrollPane */ 
    public static void main(String [] args) { 
         
        // La ventana 
        JFrame ventana = new JFrame("Imagen"); 
         
        // El panel de scroll 
        JScrollPane scroll = new JScrollPane(); 
         
        // La etiqueta. 
        JLabel etiqueta = new JLabel(); 
         
        // Se carga la imagen, con path absoluto para evitar problemas y debe 
        // ser un gif. 
        Icon imagen = new ImageIcon ( 
            "d:/users/javier/paginas_web/chuidiang/iconos/pizarra.gif"); 
         
        // Se mete la imagen en el label 
        etiqueta.setIcon (imagen); 
         
        // Se mete el scroll en la ventana 
        ventana.getContentPane().add(scroll); 
         
        // Se mete el label en el scroll 
        scroll.setViewportView(etiqueta); 
         
        // Y se visualiza todo. 
        ventana.pack(); 
        ventana.setVisible(true); 
    } 
}