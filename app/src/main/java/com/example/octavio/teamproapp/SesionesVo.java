package com.example.octavio.teamproapp;

/**
 * Created by octavio on 03-28-18.
 */

public class SesionesVo {
    private String titulo;
    private int imagen;

    public SesionesVo() {
    }

    public SesionesVo(String titulo, int imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
