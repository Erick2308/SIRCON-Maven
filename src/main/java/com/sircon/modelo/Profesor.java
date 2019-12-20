package com.sircon.modelo;


import java.util.*;

/**
 * 
 */
public class Profesor extends Usuario {

    /**
     * Default constructor
     */
    public Profesor() {
    }

    /**
     * 
     */
    public String codProfesor;

    /**
     * 
     */
    public String profesion;

    /**
     * 
     */
    public float sueldo;

    /**
     * 
     */
    public Date fechaIngreso;

    /**
     * 
     */
    public Date fechaSalida;

    public String getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }


}