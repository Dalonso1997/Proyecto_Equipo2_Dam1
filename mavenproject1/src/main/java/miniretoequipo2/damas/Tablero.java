package miniretoequipo2.damas;

/**
 *
 * @author DAM106
 */
public class Tablero {

    int[][] tablero = new int[9][9]; //Matriz con el tamaño del tablero

    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) { //Bucle que recorre las filas
            System.out.println();
            for (int j = 0; j < tablero[i].length; j++) { //Bucle que recorre las columnas

                if ((i + j) % 2 != 0) {

                    if (i < 3) {
                        tablero[i][j] = 1;
                        System.out.print(" X ");

                    } else if (i > 4) {

                        tablero[i][j] = 2;
                        System.out.print(" O ");
                    }

                } else {

                    tablero[i][j] = 0;
                    System.out.print("  ");
                }

            }

        }
    }
}
