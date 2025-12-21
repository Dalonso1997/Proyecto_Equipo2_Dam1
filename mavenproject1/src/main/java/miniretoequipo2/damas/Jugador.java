
package miniretoequipo2.damas;

/**
 *
 * @author DAM108
 */
public class Jugador {

    private String nombre;    // Nombre del jugador
    private int fichas;       // Cantidad de fichas que le quedan
    private int fichaTipo;    // 1 = X, 2 = O

    // Constructor
    public Jugador(String nombre, int fichaTipo) {
        this.nombre = nombre;
        this.fichaTipo = fichaTipo;
        this.fichas = 12; // Cada jugador empieza con 12 fichas
    }

    // Devuelve el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Devuelve el tipo de ficha
    public int getFichaTipo() {
        return fichaTipo;
    }

    // Devuelve cuántas fichas le quedan
    public int getFichas() {
        return fichas;
    }

    // Resta una ficha (cuando se come una ficha del jugador)
    public void perderFicha() {
        if (fichas > 0) {
            fichas--;
        }
    }

    // Muestra la información del jugador
    public void mostrarInfo() {
        System.out.println("Jugador: " + nombre);
        System.out.println("Fichas restantes: " + fichas);

    }
}

