package com.example.octavio.teamproapp;

/**
 * Created by octavio on 03-26-18.
 */

public class CategoriasVo {
    private String nombre;
    private String descripcion;
    private int imagenPreview;

    public CategoriasVo() {
    }

    public CategoriasVo(String nombre, String descripcion, int imagenPreview) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenPreview = imagenPreview;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenPreview() {
        return imagenPreview;
    }

    public void setImagenPreview(int imagenPreview) {
        this.imagenPreview = imagenPreview;
    }
}
