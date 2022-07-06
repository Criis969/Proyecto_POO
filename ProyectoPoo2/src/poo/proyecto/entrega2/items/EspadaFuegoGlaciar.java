package poo.proyecto.entrega2.items;

import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.Item;
import poo.proyecto.entrega2.items.poderes.ApagaFuegos;
import poo.proyecto.entrega2.items.poderes.Fundidor;

public class EspadaFuegoGlaciar extends Item {

    public EspadaFuegoGlaciar() {
        super();
        this.poderes.add(Fundidor.INSTANCIA);
        this.poderes.add(ApagaFuegos.INSTANCIA);
    }

    public java.lang.String getArchivoImagen() {
        return Const.ARCHIVO_ESPADA;
    }
}
