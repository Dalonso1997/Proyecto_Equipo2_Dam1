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
        boolean salir = false;
        
        do {
            
            tablero.mostrar();//Mostramos el tablero
            
            boolean movimientoEfectuado = false; //Creamos el booleano para ver si el jugador ha podido hacer su movimiento o no

            while (!movimientoEfectuado && salir == false) { //Bucle para el turno de cada jugador
                
                System.out.println("Turno del jugador " + ficha); //Avisamos al  usuario de quien es el turno
                System.out.print("Introduce la columna (1-7) o pulse 0 para SALIR: "); //le pedimos la columna donde quiere colocar la ficha
                
                if (!teclado.hasNextInt()){ //Comprobacion de que el usuario pone un int, ya que si se equivoca y pone otra cosa, el sistema cae
                    
                    System.out.println("Entrada no valida.....");
                    teclado.next();//Limpiamos el scanner en caso de que lo que contenga no sea un int 
                    continue;
                    
                }
                
                int columna = teclado.nextInt(); 
                
                if (columna == 0) {
                    
                    salir = true;
                    System.out.println("Saliendo.....Hasta pronto!!");
                    
                }
                
                
                movimientoEfectuado = tablero.colocarFicha(columna, ficha); //Le pasamos a la clase tablero.colocarficha la columna y ficha que pide el usuario

                if (!movimientoEfectuado && salir == false){ //en caso de que el movimiento no sea posible, 
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

        } while (!hayGanador && jugadas != 0 && salir == false);
        
        
        try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                // no hacemos nada
            }
        
        
    }

}
