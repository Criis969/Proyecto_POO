
package poo.proyecto.entrega2.items;
import poo.proyecto.entrega2.Item;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.items.poderes.Rompedor;

public class Pico extends Item{
    public Pico(){
        super();
        this.poderes.add(Rompedor.INSTANCIA);
    }
    public java.lang.String getArchivoImagen(){
        return Const.ARCHIVO_PICO;
    }
}
