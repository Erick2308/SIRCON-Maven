package com.sircon.modelo;


import java.util.*;

/**
 * 
 */
public class Notas {

    /**
     * Default constructor
     */
    public Notas() {
    }

    /**
     * 
     */
    public String codNota;

    /**
     * 
     */
    public float nota;

    /**
     * 
     */
    public String comentario;

    public String getCodNota() {
        return codNota;
    }

    public void setCodNota(String codNota) {
        this.codNota = codNota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


}