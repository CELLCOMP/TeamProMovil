package com.example.octavio.teamproapp;

/**
 * Created by octavio on 03-30-18.
 */

public class PromocionesVo {
    private String titulo;
    private String descripcion;

    public PromocionesVo() {
    }

    public PromocionesVo(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
