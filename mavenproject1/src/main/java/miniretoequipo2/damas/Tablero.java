package miniretoequipo2.damas;

/**
 *
 * @author DAM106
 */
public class Tablero {

    int[][] tablero = new int[8][8]; //Matriz con el tamaño del tablero

    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) { // filas

            // línea horizontal y contenido juntos
            String lineaSuperior = "";   // línea superior de la fila
            String lineaCentral = ""; // líneas centrales de la fila

            for (int j = 0; j < tablero[i].length; j++) { // columnas

                lineaSuperior += "+---";
                lineaCentral += "|";
                
                if ((i + j) % 2 != 0) {
                    if (i < 3) {
                        tablero[i][j] = 1;
                        lineaCentral += " X ";
                    } else if (i > 4) {
                        tablero[i][j] = 2;
                        lineaCentral += " O ";
                    } else {
                        tablero[i][j] = 0;
                        lineaCentral += "   ";
                    }
                } else {
                    tablero[i][j] = 0;
                    lineaCentral += "   ";
                }
            }

            // Borde derecho y final de la línea superior
            lineaSuperior += "+";
            lineaCentral += "|";

            // imprimir
            System.out.println(lineaSuperior);
            System.out.println(lineaCentral);
            
            if (i == tablero.length -1){
            
                System.out.println(lineaSuperior);
            }
        }
        
    }

}
