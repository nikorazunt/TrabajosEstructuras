/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Random;

/**
 *
 * @author SALA 2
 */
public class ModeloMinas {

    private int[][] tablero;
    private boolean[][] reveladoMinas;
    private int filas, columnas, minas;

    public ModeloMinas(int filas, int columnas, int minas) {
        if (minas < 0 && minas > filas * columnas) {
            throw new IllegalArgumentException("Numero de minas invalido");
        }
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.tablero = new int[filas][columnas];
        this.reveladoMinas = new boolean[filas][columnas];
        ponerMinas();
    }

    private void ponerMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            if (tablero[fila][columna] != -1) {
                tablero[fila][columna] = -1;
                minasColocadas++;
                actualizarCeldas(fila, columna);
            }
        }
    }

    private void actualizarCeldas(int fila, int columna) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (rango(fila + i, columna + j) && tablero[fila + i][columna + j] != -1) {
                    tablero[fila + i][columna + j]++;
                }
            }
        }
    }

    private boolean rango(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public int getCelda(int fila, int columna) {
        return tablero[fila][columna];
    }

    public boolean Revelado(int fila, int columna) {
        return reveladoMinas[fila][columna];
    }

    public void revelarCelda(int fila, int columna) {
        reveladoMinas[fila][columna] = true;
    }

    public int hayMina(int fila, int columna) {
        return tablero[fila][columna] = -1;
    }

}
