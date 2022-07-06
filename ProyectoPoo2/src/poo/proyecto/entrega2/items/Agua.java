
package poo.proyecto.entrega2.items;
import poo.proyecto.entrega2.Item;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.items.poderes.ApagaFuegos;

public class Agua extends Item{
    public Agua(){
       super();
       this.poderes.add(ApagaFuegos.INSTANCIA);
    }
    public java.lang.String getArchivoImagen(){
        return Const.ARCHIVO_AGUA;
    }
}
