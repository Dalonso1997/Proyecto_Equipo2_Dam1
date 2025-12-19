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

    public Carrera() {
    }

    public void iniciar() throws InterruptedException {
        do {
            for (Autobus bus : buses) {
                if (!hayGanador) {
                    bus.dibujar(meta);
                    bus.avanzar();
                    
                }
            }
            
            for (Autobus bus : buses) {
                if ((bus.getPosicion() + bus.getMayor()) >= meta) { // compara la posicion + la linea mas larga del bus con la meta
                    hayGanador = true;

                    bus.setGanador();
                }
            }
            Thread.sleep(500); // pausa un segundo
                    
            Funciones.limpiar();
        } while (!hayGanador);
    }

    /*  public static void limpiarPantalla() { // imprime lineas vacias para parecer q pasa de pantalla

        for (int i = 0; i < 40; i++) {

            System.out.println();

        }

    } */
    public int getMeta() {
        return meta;
    }

    public void darGanador() {
        int contadorGanadores = 0;
        for (Autobus bus : buses) {
            if (bus.isGanador()) {
                System.out.println("El autobus " + bus.getNumero() + " gana!!");
                contadorGanadores++;
            }
        }
        if (contadorGanadores > 1) {
            System.out.println("Hay empate!");
        }
    }
    
    public int getNumBuses(){
        return buses.length;
    }
}
