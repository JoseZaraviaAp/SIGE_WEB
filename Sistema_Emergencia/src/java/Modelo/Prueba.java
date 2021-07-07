/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;

/**
 *
 * @author admi
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prueba Conexion
        Conexion c = new Conexion();
        if (c.Conexion() !=null) {
            System.out.println("Conexion correcta");
        }else{
            System.out.println("Conexion incorrecta");
                }
    }
    
}
