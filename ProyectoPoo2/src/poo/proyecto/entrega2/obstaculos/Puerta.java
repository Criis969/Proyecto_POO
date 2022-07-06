package poo.proyecto.entrega2.obstaculos;

import poo.proyecto.entrega2.Obstaculo;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.Jugador;
import poo.proyecto.entrega2.items.poderes.AbrePuertas;

public class Puerta extends Obstaculo {

    public Puerta() {
        super();
    }

    public java.lang.String getArchivoImagen() {
        return Const.ARCHIVO_PUERTA;
    }

    public boolean puedePasar(Jugador j) {
        if (j.getItem() == null) {
            return false;
        } else if (j.getItem().tienePoder(AbrePuertas.INSTANCIA)) {
            return true;
        } else {
            return false;
        }

    }
}
