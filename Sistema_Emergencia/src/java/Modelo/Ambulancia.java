/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author admi
 */
public class Ambulancia {
    int id;
    String placa;
    String iddispo;

    public Ambulancia() {
    }

    public Ambulancia(int id, String placa, String iddispo) {
        this.id = id;
        this.placa = placa;
        this.iddispo = iddispo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getIddispo() {
        return iddispo;
    }

    public void setIddispo(String iddispo) {
        this.iddispo = iddispo;
    }
    
    
    
}
