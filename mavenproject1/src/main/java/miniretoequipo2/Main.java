package miniretoequipo2;

import java.util.Scanner;
import miniretoequipo2.carreraautobuses.CarreraAutobuses;
import miniretoequipo2.carreraautobuses.CarreraDeBuses;
import miniretoequipo2.damas.Damas;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU DE JUEGOS =====");
            System.out.println("1. Carrera de Autobuses");
            System.out.println("2. Damas");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> new CarreraAutobuses().iniciar();
                case 1 -> new CarreradeBuses().iniciar();
                case 2 -> new Damas().iniciar();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
