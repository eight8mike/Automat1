package com.Automat.proyect_dinero.Entidades;

public class Equipo {
    private String tituloEquipo;
    private String descripcion;
    private int imagenid;

    public Equipo(String tituloEquipo, String descripcion, int imagenid) {
        this.tituloEquipo = tituloEquipo;
        this.descripcion = descripcion;
        this.imagenid = imagenid;
    }

    public String getTituloEquipo() {
        return tituloEquipo;
    }

    public void setTituloEquipo(String tituloEquipo) {
        this.tituloEquipo = tituloEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenid() {
        return imagenid;
    }

    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }
}
