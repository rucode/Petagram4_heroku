package com.rubach.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rubach.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ronald on 07/08/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto="CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + " (" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE   + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO   + " INTEGER " +
                ")";
        String queryCrearTablaLikesContacto="CREATE TABLE " + ConstantesBaseDatos.TABLE_STARS_MASCOTA + " (" +
                ConstantesBaseDatos.TABLE_STARS_MASCOTA_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_STARS_ID_MASCOTA   + " INTEGER, " +
                ConstantesBaseDatos.TABLE_STARS_NUMERO_STARS   + " INTEGER, " +
                "FOREIGN KEY("+ConstantesBaseDatos.TABLE_STARS_ID_MASCOTA+")" +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "("+ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")" ;
        String queryCrearTablaUserappinstagram="CREATE TABLE " + ConstantesBaseDatos.TABLE_USERAPP + " (" +
                ConstantesBaseDatos.TABLE_USERAPP_USERID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_USERAPP_USERNAMEINSTAGRAM   + " TEXT) " ;

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
        //CREO LA TABLA DE USUARIO
        db.execSQL(queryCrearTablaUserappinstagram);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //cuando se actualice ejecuta estos comandos
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_STARS_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_USERAPP);
        //luego que vuelva a crearlas
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> contactos=new ArrayList<Mascota>();
        String query="SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        //abrir la conexion
        SQLiteDatabase db=this.getWritableDatabase();
        //abro un cursos para obtener los resultados
        Cursor registros= db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascota mascotaActual=new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            //cargo los datos de likes de la otra base
            String queryStars="SELECT COUNT("+ConstantesBaseDatos.TABLE_STARS_NUMERO_STARS+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_STARS_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_STARS_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes=db.rawQuery(queryStars,null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setValoracion(registrosLikes.getInt(0));
            }else
            {
                mascotaActual.setValoracion(0);
            }


            contactos.add(mascotaActual);
        }
        db.close();

        return contactos;
    }
    public ArrayList<Mascota> obtenerTodop5Mascotas(){
        ArrayList<Mascota> contactos=new ArrayList<Mascota>();
        //todo modificar el query para que devuelva los 5 mas altas, ahora solo devuelve 5 cualquiera.
        String query="SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " LIMIT 5";
        //abrir la conexion
        SQLiteDatabase db=this.getWritableDatabase();
        //abro un cursos para obtener los resultados
        Cursor registros= db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascota mascotaActual=new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            //cargo los datos de likes de la otra base
            String queryStars="SELECT COUNT("+ConstantesBaseDatos.TABLE_STARS_NUMERO_STARS+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_STARS_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_STARS_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes=db.rawQuery(queryStars,null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setValoracion(registrosLikes.getInt(0));
            }else
            {
                mascotaActual.setValoracion(0);
            }


            contactos.add(mascotaActual);
        }
        db.close();

        return contactos;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public void insertarStarsMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_STARS_MASCOTA,null,contentValues);
        db.close();

    }
    public int obtenerValoracionMascota(Mascota mascota){
        int stars=0;
        String query="SELECT COUNT("+ConstantesBaseDatos.TABLE_STARS_NUMERO_STARS+")" +
                " FROM " + ConstantesBaseDatos.TABLE_STARS_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_STARS_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        while (registros.moveToNext()){
            stars=registros.getInt(0);
        }
        db.close();

        return stars;

    }
    public String obtenerUserNameInstagram(){

        String userName="";
        String query="SELECT  "+ConstantesBaseDatos.TABLE_USERAPP_USERNAMEINSTAGRAM+"" +
                " FROM " + ConstantesBaseDatos.TABLE_USERAPP +
                " WHERE " + ConstantesBaseDatos.TABLE_USERAPP_USERID + "=1" ;
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        while (registros.moveToNext()){
            userName=registros.getString(0);
        }
        db.close();

        return userName;

    }

    public void insertarUserNameInstagram(ContentValues contentValues){
        int cantidadRegistros=0;
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT count(*)  FROM " + ConstantesBaseDatos.TABLE_USERAPP ;
        Cursor registros=db.rawQuery(query,null);
        while (registros.moveToNext()){
            cantidadRegistros=registros.getInt(0);
        }
        if (cantidadRegistros>0)
        {
            //hago un update
            db.update(ConstantesBaseDatos.TABLE_USERAPP,contentValues,ConstantesBaseDatos.TABLE_USERAPP_USERID + "=1",null);
        }else {
            //hago el insert
            db.insert(ConstantesBaseDatos.TABLE_USERAPP, null, contentValues);
            //db.close();
        }
        db.close();
    }

}
