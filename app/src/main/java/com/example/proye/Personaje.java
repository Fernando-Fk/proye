package com.example.proye;

public class Personaje {
    private final String nombre;
    private final String rol;
    private final int imagen;
    private final String region;
    private final String dificultad;
    private final int costo;
    private final String fechaLanzamiento;
    private final String habilidadPrincipal;
    private final int vidaBase;
    private final int manaBase;
    private final boolean esRango;
    private final String historia;

    public Personaje(String nombre, String rol, int imagen, String region, String dificultad, int costo, String fechaLanzamiento, String habilidadPrincipal, int vidaBase, int manaBase, boolean esRango, String historia) {
        this.nombre = nombre;
        this.rol = rol;
        this.imagen = imagen;
        this.region = region;
        this.dificultad = dificultad;
        this.costo = costo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.habilidadPrincipal = habilidadPrincipal;
        this.vidaBase = vidaBase;
        this.manaBase = manaBase;
        this.esRango = esRango;
        this.historia = historia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public int getImagen() {
        return imagen;
    }

    public String getRegion() {
        return region;
    }

    public String getDificultad() {
        return dificultad;
    }

    public int getCosto() {
        return costo;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getHabilidadPrincipal() {
        return habilidadPrincipal;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public int getManaBase() {
        return manaBase;
    }

    public boolean isEsRango() {
        return esRango;
    }

    public String getHistoria() {
        return historia;
    }
}