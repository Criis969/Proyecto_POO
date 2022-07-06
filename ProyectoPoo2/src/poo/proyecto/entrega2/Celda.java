package poo.proyecto.entrega2;

public class Celda {

    private ObjetoEnEscena objeto;
    private int fila;
    private int columna;

    public Celda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;

    }

    public Celda(int fila, int columna, ObjetoEnEscena objeto) {
        this.fila = fila;
        this.columna = columna;
        this.objeto = objeto;
    }

    protected int getFila() {
        return this.fila;
    }

    protected int getColumna() {
        return this.columna;
    }

    public java.lang.String getArchivoImagen() {
        if (this.objeto != null) {
            return this.objeto.getArchivoImagen();
        } else {
            return null;
        }
    }

    public boolean puedePasar(Jugador j) {
        if(this.objeto == null){
            return true;
        }
        else{
            return this.objeto.puedePasar(j);
        }
    }

    public boolean pasa(Jugador j) {
         if(this.objeto == null){
            return false;
        }
        else if (this.objeto.getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Item")) {           
            return this.objeto.pasa(j, this);

        } else if (this.objeto.getClass().getSimpleName().equalsIgnoreCase("Puerta")) {
            this.objeto.pasa(j, this);
            return true;
        }
       
        else {
            return this.objeto.pasa(j, this);
        }
    }

    public void eliminaObjeto() {
        this.objeto = null;
    }

}
