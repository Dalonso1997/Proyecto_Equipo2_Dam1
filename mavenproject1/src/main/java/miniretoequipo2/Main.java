package miniretoequipo2;

import java.util.Scanner;
import miniretoequipo2.carreraautobuses.Carrera;
import miniretoequipo2.carreraautobuses.Autobus;
import miniretoequipo2.carreraautobuses.Apuesta;
import miniretoequipo2.damas.Damas;
import miniretoequipo2.cuatroenraya.CuatroEnRaya;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU DE JUEGOS =====");
            System.out.println("1. Carrera de Autobuses");
            System.out.println("2. Damas");
            System.out.println("3. Cuatro en raya");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("¿Cuantos autobuses quieres?");
                    int num = new Scanner(System.in).nextInt();
                    Autobus[] buses = new Autobus[num];  // crea un array de autobuses que se llena automaticamente
                    for (int i = 0; i < num; i++) {
                        buses[i] = new Autobus(i + 1); // les asigna un numero su posicion del array+1)
                    }

                    int bus;
                    do {
                        System.out.println("¿Por que bus quieres apostar?");
                        bus = new Scanner(System.in).nextInt();
                        if (bus < 0 && bus > num) {
                            System.out.println("No existe ese numero de bus.");
                        } else {
                           Apuesta apuesta= new Apuesta(bus);
                            
                        }
                    } while (bus < 0 && bus > num); // pide el numero de bus repitiendo hasta que sea valido
                    
                    Carrera c = new Carrera(100, buses); // crea una carrera y llama a los metodos de iniciar y dar ganador
                    c.iniciar();
                    c.darGanador();
                }

                case 2 ->
                    new Damas().iniciar();
                case 3 ->
                    new CuatroEnRaya().iniciar();
                case 0 ->
                    System.out.println("Saliendo...");
                default ->
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
