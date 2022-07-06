
package poo.proyecto.entrega2.obstaculos;
import poo.proyecto.entrega2.Obstaculo;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.Jugador;

public class Pared extends Obstaculo{
    public Pared(){
        super();
    }
    public java.lang.String getArchivoImagen(){
       return Const.ARCHIVO_PARED;
    }
    public boolean puedePasar(Jugador j){
       return false;
    }
}
