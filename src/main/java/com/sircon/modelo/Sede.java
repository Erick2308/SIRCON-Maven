package com.sircon.modelo;


import java.util.*;

/**
 * 
 */
public class Sede {

    /**
     * Default constructor
     */
    public Sede() {
    }

    /**
     * 
     */
    public String codSede;

    /**
     * 
     */
    public String nombre;

    /**
     * 
     */
    public String direccion;

    /**
     * 
     */
    public int telefono;

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


}