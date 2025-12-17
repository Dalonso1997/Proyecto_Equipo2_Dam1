/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carreradebuses;

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
        posicion += (int)(Math.random() * 4); //num 0-3

    }

    public void dibujar() {
        for (int i = 0; i < bus.length; i++) {
            System.out.println(" ".repeat(posicion) + bus[i]);
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
    
}
