/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniretoequipo2.cuatroenraya;

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
    
    public boolean hayGanador(char ficha) {
        
        // comprobacion horizontal (misma fila, columnas consecutivas)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (celdas[i][j] == ficha && celdas[i][j + 1] == ficha && celdas[i][j + 2] == ficha && celdas[i][j + 3] == ficha){
                    
                    return true;
                    
                }
            }
        }
        
        // comprobacion horizontal (mismas columnas, filas consecutivas)
        for (int i = 0; i < 3; i++) { 
            for (int j = 0; j < 7; j++) {
                if (celdas[i][j] == ficha && celdas[i + 1][j] == ficha && celdas[i + 2][j] == ficha && celdas[i + 3][j] == ficha){
                    
                    return true;
                    
                }
            }
        }
        //comprobamos la diagonal de abajo a la derecha
        for (int i = 0; i < 3; i++) { //ponemos que i (filas) solo puede ser entre 0 y 2 del array, ya que si pasamos a la 3 ya no hay espacio para conectar 4
            for (int j = 0; j < 4; j++) { // ponemos que j (columnas) solo puede ser entre 0 y 3 ya que si pasamos a 4 ya no puede conectar 4
                if (celdas[i][j] == ficha && celdas[i + 1][j + 1] == ficha && celdas[i + 2][j + 2] == ficha && celdas[i + 3][j + 3] == ficha){ //comprobamos que las celdas en la diagonal sean iguales al caracter del jugador
                    
                    return true; //si se cumple la condicion, el boolean pasa a true y nos lo da como ganador
                }
            }
        }
        
        //comprobamos la diagonal de arriba a la derecha
        for (int i = 3; i < 6; i++) { //ponemos que i (filas) solo puede ser desde la fila 3 hasta la 5 ya que si pasamos a la 6 estariamos fuera y si es menor que 3 no habria hueco para conectar 4
            for (int j = 0; j < 4; j++) {//ponemos que j puede empezar en 0 pero no puede ser mayo que 3 ya que si pasamos a la 4 no habria espacio para conectar 4
                if (celdas[i][j] == ficha && celdas[i - 1][j + 1] == ficha && celdas[i - 2][j + 2] == ficha && celdas[i - 3][j + 3] == ficha){ //Aqui comprobamos que las celdas anteriores (por eso -1) y las columnas siguientes (por eso j +1) tienen el mismo char
                    
                    return true;
                }
            }
        }
        return false;
    }
}

