/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniretoequipo2.carreraautobuses;

import java.util.Scanner;
import miniretoequipo2.carreraautobuses.Autobus;

/**
 *
 * @author DAM104
 */
public class Apuesta {

    int dinero = 100;
    int apuesta = 0;
    Autobus bus;

    public Apuesta(Autobus bus) {
        this.bus=bus;
    }

    public void apostar(int bus) {
        do {
            System.out.println("Tienes " + dinero + " creditos, ¿cuantos apuestas?");
            apuesta = new Scanner(System.in).nextInt();

            if (apuesta < 0 && apuesta > dinero) {  // en caso de no meter bien la apuesta saca mensajes
                if (apuesta > dinero) {
                    System.out.println("Faltan creditos!");
                } else {
                    System.out.println("Numero no valido");
                }
            } else {
                dinero -= apuesta;
            }
        } while (apuesta < 0 && apuesta > dinero);
    }
    
    public void compruebaApuesta(){
        if (bus.isGanador()) {
            System.out.println("Ganaste! Duplicas el dinero");
            dinero += apuesta*2;
        } else{
            System.out.println("Perdiste :(");
        }
    }
}
