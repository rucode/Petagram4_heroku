package com.rubach.petagram.actividades;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rubach.petagram.R;
import com.rubach.petagram.adapter.PageAdapter;
import com.rubach.petagram.fragments.RecycleViewFragment;
import com.rubach.petagram.fragments.ResumenFragment;
import com.rubach.petagram.restApi.EndpointsApi;
import com.rubach.petagram.restApi.adapter.RestApiAdapter;
import com.rubach.petagram.restApi.model.UsuarioRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //ArrayList<Mascota> Mascotas;
    //private RecyclerView listaMascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toolbar miActionBar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miActionBar);
        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.cat_footprint_48);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu); // set a custom icon for the default home button
        ab.setDisplayShowHomeEnabled(true);

        //cambios para fragments
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);

        setUpViewPager(); //carga los tabs y el view pager.

        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }
        //

/*
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        //muestro los objetos vertical
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //configuro que se muestra asi en el recicleview
        listaMascotas.setLayoutManager(llm);
        //cargo las mascotas
        InicializarListaMascotas();
        //cargo el adaptador
        inicializarAdaptador();*/
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecycleViewFragment());
        //agrego el fragment de instagram
        fragments.add(new ResumenFragment());

        return fragments;
    }

    private void setUpViewPager(){
        //cargo el view pager con los fragmentes
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        //agrego al tab
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.year_of_dog_48);
    }

    public void onClickSiguiente(View v){
        Intent intent=new Intent(this,DetalleActivity.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_favorite:
                //al seleccionar, voy a la activity detalle.
                Intent intent=new Intent(this, DetalleActivity.class);
                this.startActivity(intent);
            return true;
            case R.id.action_about:
                Intent in=new Intent(this, AboutActivity.class);
                this.startActivity(in);
                return true;
            case R.id.mContacto:
                Intent icont=new Intent(this, contactoActivity.class);
                this.startActivity(icont);
                return true;
            case R.id.cfgCuenta:
                Intent iusu=new Intent(this, UsuarioActivity.class);
                this.startActivity(iusu);
                return true;
            case R.id.cfgNotificaciones:
                EnviarUsuarioApi();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void EnviarUsuarioApi(){
        //envio notificacion a servidor heroku con usuario y token
        RestApiAdapter restApiAdapter=new RestApiAdapter();
        EndpointsApi endpointsApi=restApiAdapter.establecerConexionRestHerokuRestApi();
        Call<UsuarioRespuesta> usuarioRespuestaCall=endpointsApi.registrarUsuarioInstagram("123456","miUsuarioInstagram");

        usuarioRespuestaCall.enqueue(new Callback<UsuarioRespuesta>() {
            @Override
            public void onResponse(Call<UsuarioRespuesta> call, Response<UsuarioRespuesta> response) {
                UsuarioRespuesta usuarioRespuesta=response.body();
                //guardo en el log la respuesta.
                Log.d("ID_HEROKU", usuarioRespuesta.getId());
                Log.d("ID_DISPOSITIVO", usuarioRespuesta.getId_dispositivo());
                Log.d("ID_USUARIO", usuarioRespuesta.getId_usuario_instagram());
            }

            @Override
            public void onFailure(Call<UsuarioRespuesta> call, Throwable t) {
                Log.d("ID_HEROKU", "Error en API");
            }
        });

    }

}
