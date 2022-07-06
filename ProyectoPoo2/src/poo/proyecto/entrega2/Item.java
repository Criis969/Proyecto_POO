
package poo.proyecto.entrega2;
import java.util.HashSet;

public abstract class Item implements ObjetoEnEscena{
    protected java.util.Set<PoderItem> poderes = new HashSet();
    
    public Item(){
        
    }
    public boolean puedePasar(Jugador j){
        if(j.getItem() == null){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean pasa(Jugador j, Celda c){
        j.setItem(this);
        c.eliminaObjeto();
        return false;
    }
    public boolean tienePoder(PoderItem poder){
        return this.poderes.contains(poder);
    }
}
