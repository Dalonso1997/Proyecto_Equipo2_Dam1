package miniretoequipo2.damas;

public class Damas {

    public void iniciar() {
        Tablero tablero = new Tablero();  // crear un único tablero
        tablero.inicializarTablero();     // inicializar fichas
        tablero.mostrarTablero();         // mostrar el mismo tablero
    }
}
