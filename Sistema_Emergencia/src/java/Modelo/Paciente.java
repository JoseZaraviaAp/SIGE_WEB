/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author admi
 */
public class Paciente {
    int id_paciente;
    String dni;
    String nombre;
    String apellido;
    Date fechanac;
    String direccion;
    String thumbnail;
    String estado;
    String tsangre;
    Double peso;
    Double talla;
    String contacto;
    String alergias;

    public Paciente() {
    }

    public Paciente(int id_paciente, String dni, String nombre, String apellido, Date fechanac, String direccion, String thumbnail, String estado, String tsangre, Double peso, Double talla, String contacto, String alergias) {
        this.id_paciente = id_paciente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanac = fechanac;
        this.direccion = direccion;
        this.thumbnail = thumbnail;
        this.estado = estado;
        this.tsangre = tsangre;
        this.peso = peso;
        this.talla = talla;
        this.contacto = contacto;
        this.alergias = alergias;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTsangre() {
        return tsangre;
    }

    public void setTsangre(String tsangre) {
        this.tsangre = tsangre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    
    
    
}
