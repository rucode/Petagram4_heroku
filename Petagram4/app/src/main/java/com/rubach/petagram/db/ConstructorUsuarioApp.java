package com.rubach.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.rubach.petagram.pojo.UsuarioInstagram;

/**
 * Created by Ronald on 14/09/17.
 */

public class ConstructorUsuarioApp {
    private Context context;

    public ConstructorUsuarioApp(Context context){
        this.context=context;
    }

    public  void guardarUsuario(UsuarioInstagram usuarioInstagram){
        BaseDatos db=new BaseDatos(context);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_USERAPP_USERID,usuarioInstagram.getUsuarioId());
        contentValues.put(ConstantesBaseDatos.TABLE_USERAPP_USERNAMEINSTAGRAM,usuarioInstagram.getUsuarioInstagram());
        db.insertarUserNameInstagram(contentValues);
    }
    public  String obtenerUsuarioApp()
    {
        BaseDatos db=new BaseDatos(context);
        return db.obtenerUserNameInstagram();


    }

}
