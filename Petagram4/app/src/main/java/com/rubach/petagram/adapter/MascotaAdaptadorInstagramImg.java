package com.rubach.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rubach.petagram.R;
import com.rubach.petagram.pojo.MascotaInstagram;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class MascotaAdaptadorInstagramImg extends RecyclerView.Adapter<MascotaAdaptadorInstagramImg.MascotaViewHolder>{

    public MascotaAdaptadorInstagramImg(ArrayList<MascotaInstagram> mascotas , Activity activity){
        //constructor
        this.Contactos=mascotas;
        this.activity=activity;

    }
    Activity activity;  //solo es para mostar el toast
    ArrayList<MascotaInstagram> Contactos;
    //inflar el layour y lo psara al vewholder para el obtenga los view
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //asociamos el layour al recicledview
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_instagram_imagen,parent,false);
        return new MascotaViewHolder(v);  //le paso el view al contacto view holder.
    }
    //asocia cada elemento de la lista a cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder contactoViewHolder, int position) {
        final MascotaInstagram mascotaInstagram =Contactos.get(position);
        //contactoViewHolder.imgFoto.setImageResource(contacto.getUrlFoto());
        Picasso.with(activity)
                .load(mascotaInstagram.getUrlFoto())
                .placeholder(R.drawable.icons8dogbone48)
                .into(contactoViewHolder.imgFoto);

        contactoViewHolder.tvLike.setText(String.valueOf(mascotaInstagram.getLikes()));

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mensaje por pantalla
                Toast.makeText(activity,mascotaInstagram.getNombreCompleto(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        //Cantidad de elemetos que contiene mi lista
        return Contactos.size();
        //return 1;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //declaro cada uno de los view
        private ImageView imgFoto;
        private TextView tvLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            tvLike=(TextView) itemView.findViewById(R.id.tvValoracionCv);

        }
    }

}
