package com.rubach.petagram.pojo;

/**
 * Created by Ronald on 13/09/17.
 */

public class UsuarioInstagram {

    private String usuarioInstagram="";
    private int usuarioId=0;

    public String getUsuarioInstagram() {
        return usuarioInstagram;
    }

    public void setUsuarioInstagram(String usuarioInstagram) {
        this.usuarioInstagram = usuarioInstagram;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public UsuarioInstagram(int usuarioId, String usuarioInstagram)
    {
        this.usuarioId=usuarioId;
        this.usuarioInstagram=usuarioInstagram;


    }



}
