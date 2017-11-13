package com.rubach.petagram.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.rubach.petagram.Presentador.DetalleActivityPresenter;
import com.rubach.petagram.Presentador.IDetalleActivityPresenter;
import com.rubach.petagram.R;
import com.rubach.petagram.adapter.MascotaAdaptador;
import com.rubach.petagram.pojo.Mascota;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity implements IDetalleActivityView {

    ArrayList<Mascota> Mascotas;
    private RecyclerView listaMascotas;
    private IDetalleActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        //agrega la toolbar
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //agrega la flecha hacia atras.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.cat_footprint_48);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        //muestro los objetos vertical
        /*LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //configuro que se muestra asi en el recicleview
        listaMascotas.setLayoutManager(llm);*/
        //cargo las mascotas
        //InicializarListaMascotas();
        //cargo el adaptador
        //inicializarAdaptador();
        presenter=new DetalleActivityPresenter(this,this);

    }
    /*public void InicializarListaMascotas(){

        Mascotas=new ArrayList<Mascota>();

        Mascotas.add(new Mascota("Gato",4, R.drawable.pet5));
        Mascotas.add(new Mascota("Perro",5, R.drawable.pet3));
        Mascotas.add(new Mascota("Tom",4, R.drawable.pet2));
        Mascotas.add(new Mascota("Jerry",3, R.drawable.pet1));
        Mascotas.add(new Mascota("Spice",2, R.drawable.pet4));

    }*/

    /*public void inicializarAdaptador(){
        //crea uno objeto y le pasa la lista
        MascotaAdaptador adaptador=new MascotaAdaptador(Mascotas,this);
        //asigno el adaptador.
        listaMascotas.setAdapter(adaptador);
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas,this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
