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

    public void iniciar() {
        Scanner teclado = new Scanner(System.in);
        Tablero tablero = new Tablero();

        boolean hayGanador = false;
        char ficha = 'X';
        int jugadas = 42;

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
            
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                // no hacemos nada
            }

            hayGanador = tablero.hayGanador(ficha);
            //hayEmpate = tablero.comprobarEmpate();

            if (hayGanador && ficha == 'X') {
                tablero.mostrar();
                System.out.println("El ganador es el Jugador 1!!"
                        + "\nEnhorabuena!"
                        + "\nSaliendo....");
                System.out.println("3.........");
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // no hacemos nada
            }
                System.out.println("2.........");
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // no hacemos nada
            }
                System.out.println("1.........");
                System.out.println("Hasta pronto!!");

            } else if (hayGanador && ficha == 'O') {
                tablero.mostrar();
                System.out.println("El ganador es el Jugador 2!!"
                        + "\nEnhorabuena!!"
                        + "\nSaliendo....Hasta pronto!");
                 System.out.println("3.........");
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // no hacemos nada
            }
                System.out.println("2.........");
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // no hacemos nada
            }
                System.out.println("1.........");
                System.out.println("Hasta pronto!!");
            }

            jugadas--;
            //Condicion en caso de que los jugadores se queden sin movimientos
            if (jugadas == 0) {
                tablero.mostrar();
                System.out.println("EMPATE!!");
                System.out.println("Saliendo.....");
                 System.out.println("3.........");
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // no hacemos nada
            }
                System.out.println("2.........");
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // no hacemos nada
            }
                System.out.println("1.........");
                System.out.println("Hasta pronto!!");
            }
            

            // Cambio de jugador SOLO si el movimiento fue valido
            if (!hayGanador && ficha == 'X') {
                ficha = 'O';
            } else if (!hayGanador && ficha == 'O') {
                ficha = 'X';
            }

        } while (!hayGanador && jugadas != 0);
        
        
        try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                // no hacemos nada
            }
        
        
    }

}
