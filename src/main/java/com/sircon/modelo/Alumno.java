package com.sircon.modelo;


import java.util.*;

/**
 * 
 */
public class Alumno extends Usuario {

    /**
     * Default constructor
     */
    public Alumno() {
    }

    /**
     * 
     */
    public String Usuario;

    /**
     * 
     */
    public Date fechaInscripcion;

    /**
     * 
     */
    public Date fechaSalida;

    /**
     * 
     */
    public String estado;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}