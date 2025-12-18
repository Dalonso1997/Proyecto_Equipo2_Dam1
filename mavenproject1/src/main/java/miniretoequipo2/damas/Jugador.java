
package miniretoequipo2.damas;

/**
 *
 * @author DAM108
 */
public class Jugador {
    private String nombre;
    private Color color;
    private boolean turnoActivo;
    private int fichasVivas = 12;
    private int fichasPerdidas = 0;
    private int damas = 0;
    private Jugador oponente;
    
    public enum Color {
        BLANCO, NEGRO
    }
    
    public Jugador(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
        
        if (color == color.BLANCO){
            turnoActivo = true;
            } else {
            turnoActivo = false;
        }
    }
    public void setOponente(Jugador oponente){
        this.oponente = oponente;
    }
    public void pasarTurno(){
        this.turnoActivo = false;
        oponente.turnoActivo = true;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Color getColor(){
        return color;
    }
    public int fichasVivas(){
        return fichasVivas;
    }    
    public int fichasPerdidas(){
        return fichasPerdidas;
    }
    public int damas(){
        return damas;
    }
    
    public boolean esTurnoActivo(){
        return turnoActivo;
    }
    public void activarTurno(){
        turnoActivo = true;
    }
    public void desactivarTurno(){
        turnoActivo = false;
    }
    
}
