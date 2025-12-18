/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenraya;

/**
 *
 * @author david
 */
public class Tablero {

    private char[][] celdas;

    public Tablero() {
        celdas = new char[6][7];
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                celdas[i][j] = ' ';
            }
        }
    }

    public void mostrar() {
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 0; j < 7; j++) {
                System.out.print(" " + celdas[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        System.out.println("  1   2   3   4   5   6   7 ");
    }

    public boolean colocarFicha(int columna, char ficha) {

        // Ajuste de columna (usuario 1-7 -> array 0-6)
        int col = columna - 1;

        // Comprobacion basica de rango
        if (col < 0 || col > 6) {
            return false;
        }

        // Recorremos desde abajo hacia arriba
        for (int fila = 5; fila >= 0; fila--) {
            if (celdas[fila][col] == ' ') {
                celdas[fila][col] = ficha;
                return true;
            }
        }

        // Columna llena
        return false;
    }
}

