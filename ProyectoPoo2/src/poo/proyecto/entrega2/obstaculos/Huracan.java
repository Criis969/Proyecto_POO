
package poo.proyecto.entrega2.obstaculos;
import poo.proyecto.entrega2.Obstaculo;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.Jugador;
import poo.proyecto.entrega2.items.poderes.AmansaVientos;


public class Huracan extends Obstaculo{
    public Huracan(){
        super();
    }
    public java.lang.String getArchivoImagen() {
        return Const.ARCHIVO_HURACAN;
    }

    public boolean puedePasar(Jugador j) {
        if (j.getItem() == null) {
            return false;
        } else if (j.getItem().tienePoder(AmansaVientos.INSTANCIA)) {
            return true;
        } else {
            return false;
        }
    }
}
