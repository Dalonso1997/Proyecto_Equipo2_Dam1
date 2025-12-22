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

    private int numero;
    private int posicion = 0;
    private boolean ganador = false;
    private String[] bus;

    public Autobus(int numero) {
        this.numero = numero;
        bus = new String[]{
            "   __________________________",
            "  (_________________________@)",
            "  /  |  ".concat(Integer.toString(numero)).concat("  |  |  |  |  |  || `\\"), // concatena el numero del autobus pasado a string
            "  |__|_____|__|__|__|__|__||___\\",
            "  |===================   | : |`'-._",
            " _|    .-.                 | : | ,===`\\",
            "'=|___/.-.\\________________|_:_|_/.-.\\|",
            "      \\'-'/                      \\'-'/",
            "_______'-'________________________'-'" // (ejemplo)
        };
    }

    public void avanzar() {
        posicion += (int) ((Math.random() * 3) + 1); // avanza de 1 a 3 espacios

    }

    public void dibujar(int meta) {
        for (int i = 0; i < bus.length; i++) {
            if (i != bus.length - 1) {
                System.out.println(" ".repeat(posicion + 1) + bus[i]
                        + " ".repeat(meta - posicion - bus[i].length()) + "|"); //escribe los espacios que faltan desde el bus hasta la meta
            } else {
                System.out.println("_".repeat(posicion + 1) + bus[i] //si es la ultima linea en vez de imprimir espacios lo llena con _ simulando suelo
                        + "_".repeat(meta - posicion - bus[i].length()) + "|");
            }
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

    public int getMayor() {
        int mayor = 0;
        for (int i = 0; i < bus.length; i++) { // recorre el array del texto del bus y se queda con el length de la mas larga
            if (bus[i].length() > mayor) {
                mayor = bus[i].length();
            }

        }
        return mayor;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isGanador() {
        return ganador;
    }
    
}
