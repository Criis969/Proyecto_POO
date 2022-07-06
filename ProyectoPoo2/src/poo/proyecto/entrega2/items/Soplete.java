
package poo.proyecto.entrega2.items;
import poo.proyecto.entrega2.Item;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.items.poderes.Fundidor;

public class Soplete extends Item{
    public Soplete(){
        super();
        this.poderes.add(Fundidor.INSTANCIA);
    }
    public java.lang.String getArchivoImagen(){
        return Const.ARCHIVO_SOPLETE;
    }
}
