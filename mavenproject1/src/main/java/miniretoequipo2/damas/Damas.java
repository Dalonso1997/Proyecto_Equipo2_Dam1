package miniretoequipo2.damas;

import java.util.Scanner;

public class Damas {

    public void iniciar() {
        Scanner teclado = new Scanner(System.in);

        // Crear jugadores
        System.out.print("Nombre jugador 1 (X): ");
        Jugador jugador1 = new Jugador(teclado.nextLine(), 1);

        System.out.print("Nombre jugador 2 (O): ");
        Jugador jugador2 = new Jugador(teclado.nextLine(), 2);

        // Inicializar tablero
        Tablero tablero = new Tablero();
        tablero.inicializarTablero();
        System.out.println("\nTABLERO INICIAL");
        tablero.mostrarTablero();

        // Configurar turno inicial
        Jugador turno = jugador1;
        boolean juegoActivo = true;

        // Bucle principal del juego
        while (juegoActivo) {
            System.out.println("\nTurno de " + turno.getNombre()
                    + " (Ficha " + (turno.getFichaTipo() == 1 ? "X" : "O") + ")");

            boolean movimientoHecho = false;

            while (!movimientoHecho && juegoActivo) {
                String origen = pedirPosicion(teclado, "Selecciona la ficha a mover (ej: B6) o SALIR: ");
                if (origen == null) { // usuario quiere salir
                    juegoActivo = false;
                    break;
                }

                if (!esPosicionValida(origen)) {
                    System.out.println("Formato incorrecto. Ejemplo: B6");
                    continue;
                }

                int valor = tablero.obtenerValorCelda(origen);

                // Para jugador X acepta ficha normal (1) o dama (3)
                if (turno.getFichaTipo() == 1 && valor != 1 && valor != 3) {
                    System.out.println("Esa no es tu ficha o la casilla está vacía.");
                    continue;
                }

                // Para jugador O acepta ficha normal (2) o dama (4)
                if (turno.getFichaTipo() == 2 && valor != 2 && valor != 4) {
                    System.out.println("Esa no es tu ficha o la casilla está vacía.");
                    continue;
                }

                String destino = pedirPosicion(teclado, "Selecciona a dónde moverla (ej: C5) o SALIR: ");
                if (destino == null) {
                    juegoActivo = false;
                    break;
                }

                if (!esPosicionValida(destino)) {
                    System.out.println("Formato incorrecto. Ejemplo: C5");
                    continue;
                }

                int[] destinoArray = tablero.convertirPosicion(destino);
                int filaDest = destinoArray[0];
                int colDest = destinoArray[1];

                if (!tablero.dentroDelTablero(filaDest, colDest)) {
                    System.out.println("Esa posición está fuera del tablero.");
                    continue;
                }

                if (!tablero.esCeldaVacia(filaDest, colDest)) {
                    System.out.println("No puedes moverte ahí porque hay una ficha.");
                    continue;
                }

                if (!tablero.posiblesMovimientos(origen, destino)) {
                    System.out.println("Movimiento no permitido.");
                    continue;
                }

                // Movimiento válido
                boolean comio = tablero.esSalto(origen, destino);
                tablero.moverFicha(origen, destino);

                if (comio) {
                    Jugador oponente = (turno == jugador1) ? jugador2 : jugador1;
                    oponente.perderFicha();
                    System.out.println(turno.getNombre()
                            + " ha comido una ficha de " + oponente.getNombre());
                }

                tablero.mostrarTablero();
                jugador1.mostrarInfo();
                jugador2.mostrarInfo();

                if (jugador1.getFichas() == 0 || jugador2.getFichas() == 0) {
                    System.out.println("\nEl ganador es "
                            + (jugador1.getFichas() > 0 ? jugador1.getNombre() : jugador2.getNombre()));
                    juegoActivo = false;
                }

                movimientoHecho = true;
            }

            // Cambiar turno si el juego sigue
            if (juegoActivo) {
                turno = (turno == jugador1) ? jugador2 : jugador1;
            }
        }

        System.out.println("Juego terminado.");
    }

    /**
     * Pide una posición al jugador y permite salir etecladoribiendo SALIR
     */
    private String pedirPosicion(Scanner teclado, String mensaje) {
        System.out.print(mensaje);
        String entrada = teclado.nextLine().trim().toUpperCase();
        if (entrada.equals("SALIR")) {
            return null;
        }
        return entrada;
    }

    /**
     * Verifica formato de coordenada, ej: B6
     */
    private boolean esPosicionValida(String pos) {
        return pos.matches("^[A-H][1-8]$");
    }
}
