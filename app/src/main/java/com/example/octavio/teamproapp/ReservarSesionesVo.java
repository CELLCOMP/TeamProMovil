package com.example.octavio.teamproapp;

/**
 * Created by Gamero on 2/5/2018.
 */

public class ReservarSesionesVo {
    private String tipoSesion;
    private String fecha;
    private String nombre;
    private int telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ReservarSesionesVo(String tipoSesion, String fecha, int telefono) {
        this.tipoSesion = tipoSesion;
        this.fecha = fecha;
        this.telefono = telefono;
    }

    public ReservarSesionesVo() {
    }

    public String getTipoSesion() {
        return tipoSesion;
    }

    public void setTipoSesion(String tipoSesion) {
        this.tipoSesion = tipoSesion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
