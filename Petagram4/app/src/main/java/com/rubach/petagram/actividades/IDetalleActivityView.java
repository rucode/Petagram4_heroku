package com.rubach.petagram.actividades;

import com.rubach.petagram.adapter.MascotaAdaptador;
import com.rubach.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ronald on 07/08/16.
 */
public interface IDetalleActivityView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
