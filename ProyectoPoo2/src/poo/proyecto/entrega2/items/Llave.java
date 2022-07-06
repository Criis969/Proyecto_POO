
package poo.proyecto.entrega2.items;
import poo.proyecto.entrega2.Item;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.items.poderes.AbrePuertas;

public class Llave extends Item{
    public Llave(){
        super();
        this.poderes.add(AbrePuertas.INSTANCIA);
    }
    public java.lang.String getArchivoImagen(){
        return Const.ARCHIVO_LLAVE;
    }
}
