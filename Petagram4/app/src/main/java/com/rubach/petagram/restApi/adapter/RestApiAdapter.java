package com.rubach.petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rubach.petagram.restApi.ConstantesRestApi;
import com.rubach.petagram.restApi.EndpointsApi;
import com.rubach.petagram.restApi.deserializador.ContactoDeserializador;
import com.rubach.petagram.restApi.model.ContactoResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ronald on 14/09/17.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram( Gson gson){

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsApi.class);
    }

    public Gson contruyeJsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class,new ContactoDeserializador());

        return gsonBuilder.create();

    }

    public EndpointsApi establecerConexionRestHerokuRestApi(){

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_HK)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(EndpointsApi.class);
    }

}
