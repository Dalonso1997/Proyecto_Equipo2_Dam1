/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.carreradebuses;

/**
 *
 * @author DAM104
 */
public class CarreraDeBuses {

    public static void main(String[] args) {
        
        Autobus a1= new Autobus();
        Autobus a2= new Autobus();
        Autobus[] buses={a1, a2};
        Carrera c= new Carrera(50,buses);
        c.iniciar();
    }
}
