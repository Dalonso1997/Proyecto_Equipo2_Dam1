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
        "-bus-",
        "-------" // (ejemplo)
    };

    public Autobus() {

    }

    public void avanzar() {
        posicion += 1; 

    }

    public void dibujar() {
        for (int i = 0; i < bus.length; i++) {
<<<<<<< Updated upstream
            System.out.println(" ".repeat(posicion) + bus[i]);
=======
            System.out.println(" ".repeat(posicion) + bus[i]+ 
                    " ".repeat(meta-posicion-bus[i].length()) + "|"); //escribe los espacios que faltan desde el bus hasta la meta
>>>>>>> Stashed changes
        }
    }

    public void setGanador() { // cuando gana se llama a este metodo
        this.ganador = true;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getLength() { // length del array del texto del bus (no de buses)
        return bus.length;
    }
    
<<<<<<< Updated upstream
=======
    public int getMayor(){
        int mayor=0;
        for (int i = 0; i < bus.length; i++) { // recorre el array del texto del bus y se queda con el length de la mas larga
            if (bus[i].length()>mayor) {
                mayor=bus[i].length();
            }
        }
        return mayor;
    }
>>>>>>> Stashed changes
}
