package com.rubach.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rubach.petagram.adapter.MascotaAdaptador;
import com.rubach.petagram.pojo.Mascota;
import com.rubach.petagram.R;
import com.rubach.petagram.adapter.MascotaAdaptadorMini;

import java.util.ArrayList;

public class ResumenFragment extends Fragment {

    ArrayList<Mascota> Mascotas;
    private RecyclerView listaMascotas;

    public ResumenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_resumen,container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMiMascotas);

        //para mostrarlo como un grid
        GridLayoutManager glm=new GridLayoutManager(getActivity(),3); //2= cantidad de objetos x linea
        listaMascotas.setLayoutManager(glm);


        InicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador(){
        //crea uno objeto y le pasa la lista
        MascotaAdaptadorMini adaptador=new MascotaAdaptadorMini(Mascotas,getActivity());
        //asigno el adaptador.
        listaMascotas.setAdapter(adaptador);
    }


    public void InicializarListaMascotas(){

        Mascotas=new ArrayList<Mascota>();

        Mascotas.add(new Mascota("Ronny",4, R.drawable.pet1));
        Mascotas.add(new Mascota("Ronny",2, R.drawable.pet1));
        Mascotas.add(new Mascota("Ronny",5, R.drawable.pet1));
        Mascotas.add(new Mascota("Ronny",3, R.drawable.pet1));
        Mascotas.add(new Mascota("Ronny",3, R.drawable.pet1));
        Mascotas.add(new Mascota("Ronny",3, R.drawable.pet1));

    }

}