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

    public void iniciar() throws InterruptedException {
        do {
            for (Autobus bus : buses) {
                bus.dibujar();
                bus.avanzar();
                int tiempo  = (int) Math.random() * 3000 + 200;
                Thread.sleep(tiempo);
                
                if ((bus.getPosicion()+bus.getLength())>= meta) {
                    hayGanador=true;
                    bus.setGanador();
                }
            }
        } while (!hayGanador);
    }
    
    public static void limpiarPantalla() {
        
        for (int i  = 0; i < 40; i++) {
            
            System.out.println();
            
        }
        
    }
}
