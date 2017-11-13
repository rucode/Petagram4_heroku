package com.rubach.petagram.fragments;

import com.rubach.petagram.adapter.MascotaAdaptador;
import com.rubach.petagram.adapter.MascotaAdaptadorInstagramImg;
import com.rubach.petagram.pojo.Mascota;
import com.rubach.petagram.pojo.MascotaInstagram;

import java.util.ArrayList;


public interface IRecycleViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    public void inicializarAdaptadorRVInstagram(MascotaAdaptadorInstagramImg adaptador);

    public MascotaAdaptadorInstagramImg crearAdaptadorInstagram(ArrayList<MascotaInstagram> MascotasInstagram);
    //para retrofit
    public void generarGridLayout();
}
