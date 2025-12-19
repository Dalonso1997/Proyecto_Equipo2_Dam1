/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package miniretoequipo2.carreraautobuses;
/**
 *
 * @author DAM104
 */
public class CarreraDeBuses {

    public static void main(String[] args) throws InterruptedException {
        // CLASE DE PRUEBAS !! se puede borrar
        Autobus a1= new Autobus(1);
        Autobus a2= new Autobus(2);
        Autobus a3= new Autobus(3);
        Autobus[] buses={a1, a2, a3};
        Carrera c= new Carrera(100,buses);
        c.iniciar();
        c.darGanador();
    }
}
