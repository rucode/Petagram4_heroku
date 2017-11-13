package com.rubach.petagram.pojo;

/**
 * Created by Ronald on 14/09/17.
 */

public class MascotaInstagram {

    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int likes=0;

    public MascotaInstagram(String urlFoto, String nombreCompleto, int likes) {
        this.likes = likes;
        this.urlFoto=urlFoto;
        this.nombreCompleto=nombreCompleto;
    }

    public MascotaInstagram() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


}
