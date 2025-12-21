package miniretoequipo2.damas;

public class Damas {

    public void iniciar() {
        Tablero tablero = new Tablero();   // crea un nuevo tablero
        tablero.inicializarTablero();      // coloca las fichas
        tablero.mostrarTablero();          // muestra el tablero inicial

        System.out.println("\n Movimiento de prueba");

        tablero.moverFicha("B6", "A5");    // prueba mover una ficha
        tablero.mostrarTablero();          // muestra el tablero actualizado
    }
}
