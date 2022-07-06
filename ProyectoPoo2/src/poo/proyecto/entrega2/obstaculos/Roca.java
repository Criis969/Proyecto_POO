package poo.proyecto.entrega2.obstaculos;

import poo.proyecto.entrega2.Obstaculo;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.Jugador;
import poo.proyecto.entrega2.items.poderes.Rompedor;

public class Roca extends Obstaculo {

    public Roca() {
        super();
    }

    public java.lang.String getArchivoImagen() {
        return Const.ARCHIVO_ROCA;
    }

    public boolean puedePasar(Jugador j) {
        if (j.getItem() == null) {
            return false;
        } else if (j.getItem().tienePoder(Rompedor.INSTANCIA)) {
            return true;
        } else {
            return false;
        }

    }
}
