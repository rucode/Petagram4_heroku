package com.rubach.petagram.restApi;

/**
 * Created by Ronald on 14/09/17.
 */

public class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION="/v1/";
    public static final String ROOT_URL="https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN="36174578.e4fa203.ffe9cf3771cc4a5caf0c59d48e5cd0c3";
    public static final String KEY_ACCESS_TOKEN="?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER="users/self/media/recent/";
    //informacion del mi usuario
    //https://api.instagram.com/v1/users/self/?access_token=36174578.e4fa203.ffe9cf3771cc4a5caf0c59d48e5cd0c3

    //Traer el los ultimoa archivos de fotos subidos por el usuario
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

    public static final String URL_GET_RECENT_MEDIA_USER=KEY_GET_RECENT_MEDIA_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;

    //api para heroku
    public static final String ROOT_URL_HK="https://nameless-bayou-68046.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN="token-device/";
    public static final String KEY_POST_ID_USUARIO_INSTAGRAM="registrar-usuario/";


}
