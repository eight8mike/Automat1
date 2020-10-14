package com.Automat.proyect_dinero.Entidades;

public class Palabra {
    private String tituloGlosario;
    private String concepto;

    public Palabra(){ }

    public Palabra(String titulo_palabra, String fechanacimiento) {
        this.tituloGlosario = titulo_palabra;
        this.concepto = fechanacimiento;
    }

    public String getTituloGlosario() {
        return tituloGlosario;
    }

    public void setTituloGlosario(String tituloGlosario) {
        this.tituloGlosario = tituloGlosario;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
