package com.rubach.petagram.restApi.model;

/**
 * Created by Ronald on 12/11/17.
 */

public class UsuarioRespuesta {
    private String id;
    private String id_dispositivo;
    private String id_usuario_instagram;
    //json que devuele el servicio
//    {
//            "id": "-KykzqGZdzCnBBV27jnE",
//            "id_dispositivo": "123",
//            "id_usuario_instagram": "14"
//    }

    public UsuarioRespuesta(String id, String id_dispositivo, String id_usuario_instagram){
        this.id=id;
        this.id_dispositivo=id_dispositivo;
        this.id_usuario_instagram=id_usuario_instagram;


    }
    public UsuarioRespuesta(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getId_usuario_instagram() {
        return id_usuario_instagram;
    }

    public void setId_usuario_instagram(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }
}
