/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniretoequipo2.carreraautobuses;

/**
 *
 * @author DAM104
 */
public class Carrera {

    private int meta;
    private boolean hayGanador = false;
    private Autobus[] buses;

    public Carrera(int meta, Autobus[] buses) {
        this.meta = meta;
        this.buses = buses;
    }

    public void iniciar() {
        do {
            for (Autobus bus : buses) {
                bus.dibujar();
                bus.avanzar();
<<<<<<< Updated upstream
                
                if ((bus.getPosicion()+bus.getLength())>= meta) {
                    hayGanador=true;
=======
                int tiempo = (int) Math.random() * 3000 + 200; // escoge un tiempo rndom entre 0,2 y 3 seg
                Thread.sleep(tiempo);

                if ((bus.getPosicion() + bus.getMayor()) >= meta) { // compara la posicion + la linea mas larga del bus con la meta
                    hayGanador = true;
>>>>>>> Stashed changes
                    bus.setGanador();
                }
            }
        } while (!hayGanador);
    }
<<<<<<< Updated upstream
=======

    public static void limpiarPantalla() { // imprime espacios, no se usa todavia

        for (int i = 0; i < 40; i++) {

            System.out.println();

        }

    }

    public int getMeta() { 
        return meta;
    }

>>>>>>> Stashed changes
}
