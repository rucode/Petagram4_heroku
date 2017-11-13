package com.rubach.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rubach.petagram.db.ConstructorMascotas;
import com.rubach.petagram.pojo.Mascota;
import com.rubach.petagram.R;

import java.util.ArrayList;

/**
 * Created by Ronald on 23/07/16.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    public MascotaAdaptador(ArrayList<Mascota> mascotas , Activity activity){
        //constructor
        this.Mascotas=mascotas;
        this.activity=activity;

    }
    Activity activity;  //solo es para mostar el toast
    ArrayList<Mascota> Mascotas;
    //inflar el layour y lo psara al vewholder para el obtenga los view
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //asociamos el layour al recicledview
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);  //le paso el view al contacto view holder.
    }
    //asocia cada elemento de la lista a cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota =Mascotas.get(position);
        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvValoracionCv.setText(String.valueOf(mascota.getValoracion()));

        //agrego un evento onclik para que cuando lo pulsen dispare una accion.
        mascotaViewHolder.imgFotoMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mensaje por pantalla


                Toast.makeText(activity,mascota.getNombre(),Toast.LENGTH_SHORT).show();
                //ahora vamos a la pantalla de editar contacto.
                /*Intent intent=new Intent(activity, DetalleContacto.class);
                intent.putExtra("Nombre",contacto.getNombre());
                intent.putExtra("Telefono",contacto.getTelefono());
                intent.putExtra("Email",contacto.getEmail());
                activity.startActivity(intent);*/

            }
        });

        //evento del boton votar
        mascotaViewHolder.btnVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorMascotas constructorMascotas=new ConstructorMascotas (activity);
                constructorMascotas.darStarsMascota(mascota);

                //Toast.makeText(activity,"Votacion aceptada" + mascota.getNombre(),Toast.LENGTH_SHORT).show();
                //muestro en pantalla los nuevos valores
                mascotaViewHolder.tvValoracionCv.setText(String.valueOf(constructorMascotas.obtenerSarsMascota(mascota) ));

            }
        });
    }

    @Override
    public int getItemCount() {
        //Cantidad de elemetos que contiene mi lista
        return Mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //declaro cada uno de los view
        private ImageView imgFotoMascota;
        private TextView tvNombreCV;
        private TextView tvValoracionCv;
        private ImageButton btnVotar;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            tvNombreCV=(TextView) itemView.findViewById(R.id.tvNombreCV);
            tvValoracionCv=(TextView) itemView.findViewById(R.id.tvValoracionCv);
            btnVotar=(ImageButton) itemView.findViewById(R.id.btnVotar);

        }
    }

}
