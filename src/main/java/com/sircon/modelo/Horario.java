package com.sircon.modelo;


import java.util.*;

/**
 * 
 */
public class Horario {

    /**
     * Default constructor
     */
    public Horario() {
    }

    /**
     * 
     */
    public String codHorario;

    /**
     * 
     */
    public String dia;

    /**
     * 
     */
    public String horaInicio;

    /**
     * 
     */
    public String horaFin;

    public String getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(String codHorario) {
        this.codHorario = codHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }


}