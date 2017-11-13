package com.rubach.petagram.restApi;

import com.rubach.petagram.pojo.UsuarioInstagram;
import com.rubach.petagram.restApi.model.ContactoResponse;
import com.rubach.petagram.restApi.model.UsuarioRespuesta;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ronald on 14/09/17.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();

    // metodos para llamar al api en heroku
    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_USUARIO_INSTAGRAM)
    Call<UsuarioRespuesta> registrarUsuarioInstagram(@Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram);



}
