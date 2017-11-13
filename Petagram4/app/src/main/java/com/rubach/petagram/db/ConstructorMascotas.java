package com.rubach.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.rubach.petagram.R;
import com.rubach.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ronald on 07/08/16.
 */
public class ConstructorMascotas {
    private Context context;
    private static final Integer STARS = 1;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db=new BaseDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodosLasMascotas();
    }

    public ArrayList<Mascota> obtenerTopCincoMascotas(){
        BaseDatos db=new BaseDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodop5Mascotas();
    }

    public void insertarCincoMascotas(BaseDatos db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Ronny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pet1);

        db.insertarMascota(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Tom");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pet2);

        db.insertarMascota(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Mufi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pet3);

        db.insertarMascota(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Caty");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pet4);

        db.insertarMascota(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Spice");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pet5);

        db.insertarMascota(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Pitufo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pet2);

        db.insertarMascota(contentValues);
    }
    public void darStarsMascota(Mascota mascota){
        BaseDatos db=new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_STARS_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_STARS_NUMERO_STARS,STARS);
        db.insertarStarsMascota(contentValues);
    }

    public int obtenerSarsMascota(Mascota mascota){
        BaseDatos db=new BaseDatos(context);
        return db.obtenerValoracionMascota(mascota);
    }
}
