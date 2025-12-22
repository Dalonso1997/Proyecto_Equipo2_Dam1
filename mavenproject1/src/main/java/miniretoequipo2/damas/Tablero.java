package miniretoequipo2.damas;

/**
 *
 * @author DAM106
 */
public class Tablero {

    int[][] tablero = new int[8][8]; //Matriz con el tamaño del tablero

    public void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if ((i + j) % 2 != 0) {
                    if (i < 3) {
                        tablero[i][j] = 1;   // X
                    } else if (i > 4) {
                        tablero[i][j] = 2;   // O
                    } else {
                        tablero[i][j] = 0;   // vacía
                    }
                } else {
                    tablero[i][j] = 0;       // casilla blanca
                }
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) { // filas

            String lineaSuperior = "";   // línea superior de la fila
            String lineaCentral = "";    // línea central de la fila

            for (int j = 0; j < tablero[i].length; j++) { // columnas
                lineaSuperior += "+---";
                lineaCentral += "|";

                if (tablero[i][j] == 1) {
                    lineaCentral += " X ";
                } else if (tablero[i][j] == 2) {
                    lineaCentral += " O ";
                } else if (tablero[i][j] == 3) {
                    lineaCentral += "K "; // Dama X
                } else if (tablero[i][j] == 4) {
                    lineaCentral += "Q "; // Dama O
                } else {
                    lineaCentral += "   ";
                }

            }

            lineaSuperior += "+";
            lineaCentral += "|";

            System.out.println(lineaSuperior);
            System.out.println(lineaCentral);

            if (i == tablero.length - 1) {
                System.out.println(lineaSuperior); // línea final inferior
            }
        }
    }

    public int[] convertirPosicion(String pos) {
        pos = pos.toUpperCase(); // evitar problemas
        int columna = -1;
        char letra = pos.charAt(0);

        if (letra == 'A') {
            columna = 0;
        } else if (letra == 'B') {
            columna = 1;
        } else if (letra == 'C') {
            columna = 2;
        } else if (letra == 'D') {
            columna = 3;
        } else if (letra == 'E') {
            columna = 4;
        } else if (letra == 'F') {
            columna = 5;
        } else if (letra == 'G') {
            columna = 6;
        } else if (letra == 'H') {
            columna = 7;
        }

        int fila = -1;
        char numero = pos.charAt(1);

        if (numero == '1') {
            fila = 7;
        } else if (numero == '2') {
            fila = 6;
        } else if (numero == '3') {
            fila = 5;
        } else if (numero == '4') {
            fila = 4;
        } else if (numero == '5') {
            fila = 3;
        } else if (numero == '6') {
            fila = 2;
        } else if (numero == '7') {
            fila = 1;
        } else if (numero == '8') {
            fila = 0;
        }

        return new int[]{fila, columna};
    }

    public int obtenerValorCelda(String pos) {

        int[] Array = convertirPosicion(pos);
        int fila = Array[0];
        int columna = Array[1];
        return tablero[fila][columna];

    }

    public boolean esCeldaVacia(int fila, int columna) {
        if (tablero[fila][columna] != 1 && tablero[fila][columna] != 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean dentroDelTablero(int fila, int columna) {
        return fila >= 0 && fila < 8 && columna >= 0 && columna < 8;
    }

    public boolean posiblesMovimientos(String pos, String destino) {
        int[] arrayOrigen = convertirPosicion(pos);
        int[] arrayDestino = convertirPosicion(destino);

        int fila = arrayOrigen[0];
        int columna = arrayOrigen[1];
        int filaDestino = arrayDestino[0];
        int columnaDestino = arrayDestino[1];

        if (!dentroDelTablero(filaDestino, columnaDestino)) {
            return false;
        }
        if (!esCeldaVacia(filaDestino, columnaDestino)) {
            return false;
        }

        int ficha = tablero[fila][columna];

        // Movimiento normal de ficha X o O
        if (ficha == 1 && ((filaDestino == fila + 1 && Math.abs(columnaDestino - columna) == 1) || esSalto(pos, destino))) {
            return true;
        }
        if (ficha == 2 && ((filaDestino == fila - 1 && Math.abs(columnaDestino - columna) == 1) || esSalto(pos, destino))) {
            return true;
        }

        // Movimiento de Dama (3 o 4) en cualquier diagonal de 1 casilla o salto válido
        if ((ficha == 3 || ficha == 4) && ((Math.abs(filaDestino - fila) == 1 && Math.abs(columnaDestino - columna) == 1) || esSalto(pos, destino))) {
            return true;
        }

        return false;
    }

    public void moverFicha(String origen, String destino) {
        int[] arrayOrigen = convertirPosicion(origen);
        int[] arrayDestino = convertirPosicion(destino);

        int fila = arrayOrigen[0];
        int columna = arrayOrigen[1];
        int filaDestino = arrayDestino[0];
        int columnaDestino = arrayDestino[1];

        // Comprobar que el movimiento es válido
        if (posiblesMovimientos(origen, destino)) {

            // Si es un salto, se comerá la ficha enemiga
            if (esSalto(origen, destino)) {
                comerFicha(origen, destino);
            }

            // Mover ficha al destino
            int ficha = tablero[fila][columna];
            tablero[filaDestino][columnaDestino] = ficha;
            tablero[fila][columna] = 0;

            // CORONACIÓN: convertir en Dama si llega a la última fila
            if (ficha == 1 && filaDestino == 7) {
                tablero[filaDestino][columnaDestino] = 3; // Dama X
            }
            if (ficha == 2 && filaDestino == 0) {
                tablero[filaDestino][columnaDestino] = 4; // Dama O
            }
        }
    }

    public boolean esSalto(String origen, String destino) {
        int[] arrayOrigen = convertirPosicion(origen);
        int[] arrayDestino = convertirPosicion(destino);

        int fila = arrayOrigen[0];
        int columna = arrayOrigen[1];
        int filaDestino = arrayDestino[0];
        int columnaDestino = arrayDestino[1];

        if (Math.abs(filaDestino - fila) == 2 && Math.abs(columnaDestino - columna) == 2) {
            int filaMedia = (fila + filaDestino) / 2;
            int columnaMedia = (columna + columnaDestino) / 2;

            int ficha = tablero[fila][columna];
            int rival = tablero[filaMedia][columnaMedia];

            if (ficha == 1 && rival == 2) {
                return true;
            }
            if (ficha == 2 && rival == 1) {
                return true;
            }
            if (ficha == 3 && (rival == 2 || rival == 4)) {
                return true; // Dama X come ficha O o Dama O
            }
            if (ficha == 4 && (rival == 1 || rival == 3)) {
                return true; // Dama O come ficha X o Dama X
            }
        }

        return false;
    }

    public void comerFicha(String origen, String destino) {
        int[] arrayOrigen = convertirPosicion(origen);
        int[] arrayDestino = convertirPosicion(destino);

        int fila = arrayOrigen[0];
        int columna = arrayOrigen[1];
        int filaDestino = arrayDestino[0];
        int columnaDestino = arrayDestino[1];

        //posición de la ficha que se va a comer
        int filaMedia = (fila + filaDestino) / 2;
        int columnaMedia = (columna + columnaDestino) / 2;

        // Eliminación ficha del medio
        tablero[filaMedia][columnaMedia] = 0;
    }

}
