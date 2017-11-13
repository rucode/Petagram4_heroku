package com.rubach.petagram.Presentador;

import android.content.Context;

import com.rubach.petagram.actividades.IDetalleActivityView;
import com.rubach.petagram.db.ConstructorMascotas;
import com.rubach.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ronald on 07/08/16.
 */
public class DetalleActivityPresenter implements IDetalleActivityPresenter {

    private IDetalleActivityView iIDetalleActivityView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    public DetalleActivityPresenter(IDetalleActivityView iIDetalleActivityView, Context context) {
        this.context=context;
        this.iIDetalleActivityView=iIDetalleActivityView;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas=new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerTopCincoMascotas();  //top 5
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iIDetalleActivityView.inicializarAdaptadorRV(iIDetalleActivityView.crearAdaptador(mascotas));
        iIDetalleActivityView.generarLinearLayoutVertical();
    }
}
