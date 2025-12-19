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
    
    public int obtenerValorCelda(String pos){
        
        int[] Array = convertirPosicion(pos);
        int fila = Array[0];
        int columna = Array[1];
        return tablero[fila][columna];
        
    
    }
    
    public boolean esCeldaVacia(String pos){
    
        int[] Array = convertirPosicion(pos);
        int fila = Array[0];
        int columna = Array[1];
        if(tablero[fila][columna] != 1 && tablero[fila][columna] != 2){
            return true;
        
        }else{
        
        return false;
        }
    }
    
    
    
    public boolean posiblesMovimientos(String pos ,String destino){
        
        int[] arrayOrigen = convertirPosicion(pos);
        int[] arrayDestino = convertirPosicion(destino);
        
        int fila = arrayOrigen[0];
        int columna = arrayOrigen[1];
        
        int filaDestino = arrayDestino[0];
        int columnaDestino = arrayDestino[1];


        if(tablero[fila][columna] == 1){ //Significa que es una ficha X
          
            if(tablero[filaDestino][columnaDestino] == tablero[fila +1][columna -1] || 
               tablero[filaDestino][columnaDestino] == tablero[fila +1][columna +1] &&
               esCeldaVacia(filaDestino, columnaDestino) == true){

                }
                
            
            }

            
            
            
        }

        
    
    }
    
    
    /*public boolean moverFicha(String origen, String destino){
    
        int[] Arrayorigen = convertirPosicion(origen);
        int[] Arraydestino = convertirPosicion(destino);
        
        
    
    
    }
}*/
