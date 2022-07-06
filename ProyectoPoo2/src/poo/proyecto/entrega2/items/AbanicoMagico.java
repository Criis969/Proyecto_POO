package poo.proyecto.entrega2.items;

import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.Item;
import poo.proyecto.entrega2.items.poderes.AmansaVientos;

public class AbanicoMagico extends Item {

    public AbanicoMagico() {
        super();
        this.poderes.add(AmansaVientos.INSTANCIA);
    }

    public java.lang.String getArchivoImagen() {
        return Const.ARCHIVO_ABANICO;
    }
}
