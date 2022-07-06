package poo.proyecto.entrega2;

import java.util.ArrayList;
import poo.proyecto.entrega2.Const;
import poo.proyecto.entrega2.Item;
import poo.proyecto.entrega2.Nivel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import poo.proyecto.entrega2.ArchivoMalFormateadoException;
import java.io.IOException;

import poo.proyecto.gui.InterfazGrafica;

public class ControlJuego {

    private InterfazGrafica gui = new InterfazGrafica(Const.NIVEL_FILAS, Const.NIVEL_COLUMNAS);
    private int nivel = 0;
    private java.util.List<Nivel> niveles = new ArrayList<Nivel>();

    public void ControlJuego() {

    }

    public void empiezaPartida() {
        while (this.nivel < 6) {
            boolean acabaNivel = false;
            Nivel clon = this.niveles.get(this.nivel).clonar();
            redibuja(clon);
            while (!acabaNivel) {
                switch (this.gui.leeTeclaPulsada()) {
                    case InterfazGrafica.TECLA_ARRIBA:
                        if (clon.intentaMover(clon.getJugador().getPosFila() - 1, clon.getJugador().getPosCol())) {
                            acabaNivel = true;
                        }
                        break;
                    case InterfazGrafica.TECLA_ABAJO:
                        if (clon.intentaMover(clon.getJugador().getPosFila() + 1, clon.getJugador().getPosCol())) {
                            acabaNivel = true;
                        }
                        break;
                    case InterfazGrafica.TECLA_DERECHA:
                        if (clon.intentaMover(clon.getJugador().getPosFila(), clon.getJugador().getPosCol() + 1)) {
                            acabaNivel = true;
                        }
                        break;
                    case InterfazGrafica.TECLA_IZQUIERDA:
                        if (clon.intentaMover(clon.getJugador().getPosFila(), clon.getJugador().getPosCol() - 1)) {
                            acabaNivel = true;
                        }
                        break;
                    case InterfazGrafica.TECLA_R:
                        clon = this.niveles.get(this.nivel).clonar();
                        break;
                }
                redibuja(clon);
            }
            this.nivel++;
        }
    }

    private void redibuja(Nivel nivelActual) {
        for (int i = 0; i < Const.NIVEL_FILAS; i++) {
            for (int j = 0; j < Const.NIVEL_COLUMNAS; j++) {
                if (nivelActual.getJugador().getPosFila() == i && nivelActual.getJugador().getPosCol() == j) {
                    this.gui.colocaImagen(Const.ARCHIVO_JUGADOR, i, j);
                } else {
                    this.gui.colocaImagen(nivelActual.getCelda(i, j).getArchivoImagen(), i, j);
                }
            }
        }
        if (nivelActual.getJugador().getItem() != null) {
            if (nivelActual.getJugador().getItem().getClass().getSimpleName().equalsIgnoreCase("Agua")) {
                this.gui.colocaImagen(Const.ARCHIVO_AGUA, 0, Const.NIVEL_COLUMNAS - 1);
            } else if (nivelActual.getJugador().getItem().getClass().getSimpleName().equalsIgnoreCase("Llave")) {
                this.gui.colocaImagen(Const.ARCHIVO_LLAVE, 0, Const.NIVEL_COLUMNAS - 1);
            } else if (nivelActual.getJugador().getItem().getClass().getSimpleName().equalsIgnoreCase("Pico")) {
                this.gui.colocaImagen(Const.ARCHIVO_PICO, 0, Const.NIVEL_COLUMNAS - 1);
            } else if (nivelActual.getJugador().getItem().getClass().getSimpleName().equalsIgnoreCase("Soplete")) {
                this.gui.colocaImagen(Const.ARCHIVO_SOPLETE, 0, Const.NIVEL_COLUMNAS - 1);
            } else if (nivelActual.getJugador().getItem().getClass().getSimpleName().equalsIgnoreCase("EspadaFuegoGlaciar")) {
                this.gui.colocaImagen(Const.ARCHIVO_ESPADA, 0, Const.NIVEL_COLUMNAS - 1);
            } else if (nivelActual.getJugador().getItem().getClass().getSimpleName().equalsIgnoreCase("AbanicoMagico")) {
                this.gui.colocaImagen(Const.ARCHIVO_ABANICO, 0, Const.NIVEL_COLUMNAS - 1);
            }
        }

    }

    public void cargaNiveles() throws java.io.IOException, ArchivoMalFormateadoException {
        
            BufferedReader archivo = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "niveles.txt"));
            String linea = archivo.readLine();
            String s[];
            String c;
            char[] car;
            char mapa[][] = new char[Const.NIVEL_FILAS][Const.NIVEL_COLUMNAS];
            boolean finalFile = false;
            int i = 0;
            while (finalFile == false) {
                if (linea.length() < 2) {
                    throw new ArchivoMalFormateadoException("Archivo mal formateado");
                } else if (linea.charAt(0) == '/' && linea.charAt(1) == '/') {
                    linea = archivo.readLine();
                } else if (linea.length() == 3) {
                    if (linea.charAt(0) == '-' && linea.charAt(1) == '-' && linea.charAt(2) == '-') {
                        if (i != Const.NIVEL_FILAS) {
                            throw new ArchivoMalFormateadoException("Archivo mal formateado");
                        } else {
                            i=0;
                            this.niveles.add(new Nivel(Const.NIVEL_FILAS, Const.NIVEL_COLUMNAS, mapa));
                            mapa = new char[Const.NIVEL_FILAS][Const.NIVEL_COLUMNAS];
                            linea = archivo.readLine();
                            if (linea.length() == 3) {
                                if (linea.charAt(0) == '=' && linea.charAt(1) == '=' && linea.charAt(2) == '=') {
                                    finalFile = true;
                                }
                            }
                        }
                    }
                } else {
                    s = linea.split("\\|");
                    c = s[0];
                    if (c.length() != Const.NIVEL_COLUMNAS) {
                        throw new ArchivoMalFormateadoException("Archivo mal formateado");
                    } else {
                      car = c.toCharArray();
                      for(int j = 0;j<Const.NIVEL_COLUMNAS;j++){
                        mapa[i][j] = car[j];  
                      }
                      i++;
                      linea = archivo.readLine();
                    }
                }
            }

        

    }
}
