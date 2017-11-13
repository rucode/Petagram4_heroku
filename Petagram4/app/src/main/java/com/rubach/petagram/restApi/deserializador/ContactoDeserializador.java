package com.rubach.petagram.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.rubach.petagram.pojo.MascotaInstagram;
import com.rubach.petagram.restApi.JsonKey;
import com.rubach.petagram.restApi.model.ContactoResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Ronald on 14/09/17.
 */

public class ContactoDeserializador implements JsonDeserializer<ContactoResponse> {
    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        ContactoResponse contactoResponse= gson.fromJson(json,ContactoResponse.class);
        JsonArray contactoResponseData=json.getAsJsonObject().getAsJsonArray(JsonKey.MEDIA_RESPONSE_ARRAY);

        contactoResponse.setMascotaInstagrams(deserializarContactoDeJson((contactoResponseData)));

        return contactoResponse;
    }

    private ArrayList<MascotaInstagram> deserializarContactoDeJson(JsonArray contactoResponseData){
        ArrayList<MascotaInstagram> mascotaInstagrams =new ArrayList<>();
        for (int i=0;i<contactoResponseData.size();i++){
            JsonObject contactoResponseDataObject=contactoResponseData.get(i).getAsJsonObject();
            JsonObject userJson     =contactoResponseDataObject.getAsJsonObject(JsonKey.USER);
            String id               =userJson.get(JsonKey.USER_ID).getAsString();
            String nombreCompleto   =userJson.get(JsonKey.USER_FULLNAME).getAsString();

            JsonObject imageJson    =contactoResponseDataObject.getAsJsonObject(JsonKey.MEDIA_IMAGE);
            JsonObject stdResolutionJson=imageJson.getAsJsonObject(JsonKey.MEDIA_STANDAR_RESOLUTION);

            String urlFoto          =stdResolutionJson.get(JsonKey.MEDIA_URL).getAsString();

            JsonObject likesJson    =contactoResponseDataObject.getAsJsonObject(JsonKey.MEDIA_LIKES);
            int likes               =likesJson.get(JsonKey.MEDIA_LIKES_COUNT).getAsInt();

            MascotaInstagram mascotaInstagramActual =new MascotaInstagram();
            mascotaInstagramActual.setId(id);
            mascotaInstagramActual.setNombreCompleto(nombreCompleto);
            mascotaInstagramActual.setLikes(likes);
            mascotaInstagramActual.setUrlFoto(urlFoto);

            mascotaInstagrams.add(mascotaInstagramActual);



        }
        return mascotaInstagrams;

    }

}
