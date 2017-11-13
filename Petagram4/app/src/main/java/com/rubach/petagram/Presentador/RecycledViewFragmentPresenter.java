package com.rubach.petagram.Presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rubach.petagram.db.ConstructorMascotas;
import com.rubach.petagram.fragments.IRecycleViewFragmentView;
import com.rubach.petagram.pojo.Mascota;
import com.rubach.petagram.pojo.MascotaInstagram;
import com.rubach.petagram.restApi.EndpointsApi;
import com.rubach.petagram.restApi.adapter.RestApiAdapter;
import com.rubach.petagram.restApi.model.ContactoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ronald on 07/08/16.
 */
public class RecycledViewFragmentPresenter implements IRecycledViewFragmentPresenter {

    private IRecycleViewFragmentView iRecycledViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private ArrayList<MascotaInstagram> mascotasInstagram;

    public RecycledViewFragmentPresenter(IRecycleViewFragmentView iRecycledViewFragmentView, Context context) {
        this.context=context;
        this.iRecycledViewFragmentView=iRecycledViewFragmentView;
        //obtenerMascotasBaseDatos();
        obtenerMediosRecientes();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas=new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecycledViewFragmentView.inicializarAdaptadorRV(iRecycledViewFragmentView.crearAdaptador(mascotas));
        iRecycledViewFragmentView.generarLinearLayoutVertical();
    }
    @Override
    public void mostrarMascotasInstagramRV() {
        iRecycledViewFragmentView.inicializarAdaptadorRVInstagram(iRecycledViewFragmentView.crearAdaptadorInstagram(mascotasInstagram));
        iRecycledViewFragmentView.generarLinearLayoutVertical();
    }
    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.contruyeJsonDeserializadorMediaRecent();

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                mascotasInstagram = contactoResponse.getMascotaInstagrams();
                mostrarMascotasInstagramRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "algo paso intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("Fallo la conexion", t.toString());
            }
        });
    }
}
