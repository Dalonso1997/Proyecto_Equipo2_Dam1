/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniretoequipo2.cuatroenraya;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class CuatroEnRaya {
    
    public void iniciar(){
        Scanner teclado = new Scanner(System.in);
        Tablero tablero = new Tablero();

        boolean hayGanador = false;
        char ficha = 'X';

        do {
            tablero.mostrar();

            boolean movimientoEfectuado = false;

            while (!movimientoEfectuado) {

                System.out.println("Turno del jugador " + ficha);
                System.out.print("Introduce la columna (1-7): ");
                int columna = teclado.nextInt();

                movimientoEfectuado = tablero.colocarFicha(columna, ficha);

                if (!movimientoEfectuado) {
                    System.out.println("Columna llena o invalida. Intenta otra.");
                }
            }
            
            hayGanador = tablero.hayGanador(ficha);
            
            if(hayGanador && ficha == 'X'){
                
                System.out.println("El ganador es el Jugador 1!!"
                        + "\nEnhorabuena!"
                        + "\nSaliendo....Hasta pronto!!");
                
            } else if (hayGanador && ficha == 'O'){
                
                System.out.println("El ganador es el Jugador 2!!"
                        + "\nEnhorabuena!!"
                        + "\nSaliendo....Hasta pronto!");
                
            }
            
            // Cambio de jugador SOLO si el movimiento fue valido
            if (ficha == 'X') {
                ficha = 'O';
            } else {
                ficha = 'X';
            }

        } while (!hayGanador);

        
    }
    
}
