package com.Automat.proyect_dinero.Entidades;

public class EquipoMateriales {
    private String tituloEquipoMateriales;
    private String descripcionMateriales;
    private int imagenid;

    public EquipoMateriales(){ }

    public EquipoMateriales(String tituloEquipoMateriales, String descripcionMateriales, int imagenid) {
        this.tituloEquipoMateriales = tituloEquipoMateriales;
        this.descripcionMateriales = descripcionMateriales;
        this.imagenid = imagenid;
    }

    public String getTituloEquipoMateriales() {
        return tituloEquipoMateriales;
    }

    public void setTituloEquipoMateriales(String tituloEquipoMateriales) {
        this.tituloEquipoMateriales = tituloEquipoMateriales;
    }

    public String getDescripcionMateriales() {
        return descripcionMateriales;
    }

    public void setDescripcionMateriales(String descripcionMateriales) {
        this.descripcionMateriales = descripcionMateriales;
    }

    public int getImagenid() {
        return imagenid;
    }

    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }
}
