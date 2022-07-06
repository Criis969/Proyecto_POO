
package poo.proyecto.entrega2;


public class Jugador {
    private Celda celda;
    private Item item;
    
    public Jugador(Celda c){
        this.celda = new Celda(c.getFila(),c.getColumna());
    }
    public int getPosFila(){
        return this.celda.getFila();
    }
    public int getPosCol(){
        return this.celda.getColumna();
    }
    public Item getItem(){
        return this.item;
    }
    public void setItem(Item item){
       this.item = item; 
    }
    public void setCelda(Celda c){
        this.celda = c;
    }
}
