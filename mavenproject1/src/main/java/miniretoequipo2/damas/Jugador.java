
package miniretoequipo2.damas;

import java.awt.Color;

/**
 *
 * @author DAM108
 */
public class Jugador {
    private String nombre;
    private Color color;
    private boolean esHumano;
    private boolean turnoActivo;
    private int fichasVivas;
    private int damas;
    
    public Jugador(String nombre, Color color, boolean esHumano) {
        this.nombre = nombre;
        this.color = color;
        this.esHumano = esHumano;
    }
}
