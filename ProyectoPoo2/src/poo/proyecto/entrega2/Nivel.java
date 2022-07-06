package poo.proyecto.entrega2;

import poo.proyecto.entrega2.obstaculos.Fuego;
import poo.proyecto.entrega2.obstaculos.Pared;
import poo.proyecto.entrega2.obstaculos.Hielo;
import poo.proyecto.entrega2.obstaculos.Roca;
import poo.proyecto.entrega2.obstaculos.Puerta;
import poo.proyecto.entrega2.items.Agua;
import poo.proyecto.entrega2.items.Llave;
import poo.proyecto.entrega2.items.Pico;
import poo.proyecto.entrega2.items.Soplete;
import poo.proyecto.entrega2.items.EspadaFuegoGlaciar;
import poo.proyecto.entrega2.items.AbanicoMagico;
import poo.proyecto.entrega2.obstaculos.Huracan;

public class Nivel {

    private Jugador jugador;
    private int filas;
    private int columnas;
    private Celda[][] celdas;
    private char[][] mapa;

    public Nivel(int filas, int columnas, char[][] mapa) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Celda[this.filas][this.columnas];
        this.mapa = mapa;
        for (int i = 0; i < this.filas; i++) {
            for (int y = 0; y < this.columnas; y++) {

                if (this.mapa[i][y] == '#') {
                    this.celdas[i][y] = new Celda(i, y, new Pared());
                } else if (this.mapa[i][y] == 'P') {
                    this.celdas[i][y] = new Celda(i, y, new Puerta());
                } else if (this.mapa[i][y] == 'L') {
                    this.celdas[i][y] = new Celda(i, y, new Llave());
                } else if (this.mapa[i][y] == 'S') {
                    this.celdas[i][y] = new Celda(i, y, new Soplete());
                } else if (this.mapa[i][y] == 'H') {
                    this.celdas[i][y] = new Celda(i, y, new Hielo());
                } else if (this.mapa[i][y] == 'F') {
                    this.celdas[i][y] = new Celda(i, y, new Fuego());
                } else if (this.mapa[i][y] == 'A') {
                    this.celdas[i][y] = new Celda(i, y, new Agua());
                } else if (this.mapa[i][y] == 'T') {
                    this.celdas[i][y] = new Celda(i, y, new Pico());
                } else if (this.mapa[i][y] == 'R') {
                    this.celdas[i][y] = new Celda(i, y, new Roca());
                } else if (this.mapa[i][y] == 'J') {
                    this.jugador = new Jugador(new Celda(i, y));
                } else if (this.mapa[i][y] == 'E') {
                    this.celdas[i][y] = new Celda(i, y, new EspadaFuegoGlaciar());
                } else if (this.mapa[i][y] == 'V') {
                    this.celdas[i][y] = new Celda(i, y, new Huracan());
                } else if (this.mapa[i][y] == 'B') {
                    this.celdas[i][y] = new Celda(i, y, new AbanicoMagico());
                }
                else{
                    this.celdas[i][y] = new Celda(i,y);
                }

            }
        }
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public Celda getCelda(int fila, int columna) {
        return this.celdas[fila][columna];
    }

    public Nivel clonar() {
        Nivel clon = new Nivel(this.filas, this.columnas, this.mapa);
        return clon;
    }

    public boolean intentaMover(int fila, int col) {
        boolean mover = false;
        int columnaAnterior = 0;
        int filaAnterior = 0;
        if (this.celdas[fila][col].puedePasar(this.jugador)) {
            filaAnterior = this.jugador.getPosFila();
            columnaAnterior = this.jugador.getPosCol();
            this.jugador.setCelda(this.celdas[fila][col]);
            this.celdas[filaAnterior][columnaAnterior] = new Celda(filaAnterior, columnaAnterior);
            if (this.celdas[fila][col].pasa(this.jugador)) {
                mover = true;
            }
        }

        return mover;
    }

}
