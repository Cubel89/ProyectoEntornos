import java.io.*;
 
class Ficheros {
   public static void main(String [] arg) {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("/run/media/quique/CosasExt4/eclipseProyects/Entornos/src/db.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
        // while((linea=br.readLine())!=null)
         System.out.println(br.readLine());
         System.out.println(br.readLine());
      }
      catch(Exception e){
         e.printStackTrace();
      }
      /*
      FileWriter fichero = null;
      PrintWriter pw = null;
      try
      {
          fichero = new FileWriter(archivo, true);
          pw = new PrintWriter(fichero);
          for (int i = 0; i < 5; i++){
        	  pw.append("eee");
          }

      } catch (Exception e) {
          e.printStackTrace();
      } finally {
         try {
         // Nuevamente aprovechamos el finally para 
         // asegurarnos que se cierra el fichero.
         if (null != fichero)
            fichero.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      */
      
   }
}