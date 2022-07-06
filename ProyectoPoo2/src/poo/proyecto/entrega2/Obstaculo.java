
package poo.proyecto.entrega2;


public abstract class Obstaculo implements ObjetoEnEscena{
   public Obstaculo(){
       
   } 
   public boolean pasa(Jugador j,Celda c){
       j.setItem(null);
       c.eliminaObjeto();
       return false;
   }
}
