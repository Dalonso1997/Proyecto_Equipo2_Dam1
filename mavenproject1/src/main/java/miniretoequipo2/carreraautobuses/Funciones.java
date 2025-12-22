/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniretoequipo2.carreraautobuses;

import java.util.ArrayList;

/**
 *
 * @author DAM104 estas funciones estan copiadas de otro ejercicio y adaptadas a lo necesitado aquí
 */
public class Funciones {
    
    public static void limpiar() {
        try {
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando = new ArrayList<>();
            if (sistemaOperativo.contains("Windows")) {
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");

            } else {
                comando.add("bash");
                comando.add("-c");
                comando.add("clear");
            }

            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();

        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla: " + e.getMessage());
        }
    }
    
}
