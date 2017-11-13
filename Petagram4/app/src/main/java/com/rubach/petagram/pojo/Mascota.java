package com.rubach.petagram.pojo;

/**
 * Created by Ronald on 20/07/16.
 */
public class Mascota {

    private int id;
    private String nombre;
    private int valoracion;
    private int foto;

    public Mascota(String nombre, int valoracion, int foto) {
        this.nombre = nombre;
        this.valoracion = valoracion;
        this.foto = foto;
    }

    public Mascota() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
