package com.Automat.proyect_dinero.Entidades;

public class EquipoTorno {
    private String tituloEquipoTorno;
    private String descripcionTorno;
    private int imagenid;

    public EquipoTorno(){ }

    public EquipoTorno(String tituloEquipoTorno, String descripcionTorno, int imagenid) {
        this.tituloEquipoTorno = tituloEquipoTorno;
        this.descripcionTorno = descripcionTorno;
        this.imagenid = imagenid;
    }

    public String getTituloEquipoTorno() {
        return tituloEquipoTorno;
    }

    public void setTituloEquipoTorno(String tituloEquipoTorno) {
        this.tituloEquipoTorno = tituloEquipoTorno;
    }

    public String getDescripcionTorno() {
        return descripcionTorno;
    }

    public void setDescripcionTorno(String descripcionTorno) {
        this.descripcionTorno = descripcionTorno;
    }

    public int getImagenid() {
        return imagenid;
    }

    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }
}
