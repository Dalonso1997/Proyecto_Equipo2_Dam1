/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniretoequipo2.carreraautobuses;

/**
 *
 * @author DAM104
 */
public class Autobus {

    private int posicion = 0;
    private boolean ganador = false;
    private final String[] bus = {
        "   __________________________",
           "  (_________________________@)",
           "  /  |  |  |  |  |  |  |  || `\\",
           "  |__|__|__|__|__|__|__|__||___\\",
           "  |===================   | : |`'-._",
           " _|    .-.                 | : | ,===`\\",
           "'=|___/.-.\\________________|_:_|_/.-.\\|",
           "      \\'-'/                      \\'-'/",
           "        '-'                        '-'"// (ejemplo)
    };

    public Autobus() {

    }

    public void avanzar() {
        posicion += (int)(Math.random() * 4); //num 0-3

    }

    public void dibujar(int meta) {
        for (int i = 0; i < bus.length; i++) {
            System.out.println(" ".repeat(posicion) + bus[i]+ 
                    " ".repeat(meta-posicion-bus[i].length()) + "|"); // 
        }
    }

    public void setGanador() { // cuando gana se llama a este metodo
        this.ganador = true;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getLength() {
        return bus.length;
    }
    
    public int getMayor(){
        int mayor=0;
        for (int i = 0; i < bus.length; i++) {
            if (bus[i].length()>mayor) {
                mayor=bus[i].length();
            }
        }
        return mayor;
    }
}
