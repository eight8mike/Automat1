package com.Automat.proyect_dinero.Entidades;

public class FormatosManufactura {
    private String tituloEquipoManufactura;
    private String descripcionManufactura;
    private String linkManufactura;
    private int imagenid;

    public FormatosManufactura(){ }

    public FormatosManufactura(String tituloEquipoManufactura, String descripcionManufactura, String linkManufactura, int imagenid) {
        this.tituloEquipoManufactura = tituloEquipoManufactura;
        this.descripcionManufactura = descripcionManufactura;
        this.linkManufactura = linkManufactura;
        this.imagenid = imagenid;
    }

    public String getTituloEquipoManufactura() {
        return tituloEquipoManufactura;
    }

    public void setTituloEquipoManufactura(String tituloEquipoManufactura) {
        this.tituloEquipoManufactura = tituloEquipoManufactura;
    }

    public String getDescripcionManufactura() {
        return descripcionManufactura;
    }

    public void setDescripcionManufactura(String descripcionManufactura) {
        this.descripcionManufactura = descripcionManufactura;
    }

    public String getLinkManufactura() {
        return linkManufactura;
    }

    public void setLinkManufactura(String linkManufactura) {
        this.linkManufactura = linkManufactura;
    }

    public int getImagenid() {
        return imagenid;
    }

    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }
}
