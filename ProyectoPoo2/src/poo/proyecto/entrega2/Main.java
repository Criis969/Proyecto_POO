
package poo.proyecto.entrega2;
import java.io.IOException;

public class Main {
    public static void main(java.lang.String args[])throws java.lang.InterruptedException{
      try{
          try{
            ControlJuego juego = new ControlJuego();
            juego.cargaNiveles();
            juego.empiezaPartida();
          }
          catch(ArchivoMalFormateadoException e){
            System.out.println(e.getMessage());  
          }
      }
      catch(IOException ex){
           System.out.println("No se ha encontrado el archivo");
      }
    }
}
