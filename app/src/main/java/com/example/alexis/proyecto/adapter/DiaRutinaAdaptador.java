package com.example.alexis.proyecto.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexis.proyecto.DetalleContacto;
import com.example.alexis.proyecto.MainActivity;
import com.example.alexis.proyecto.R;
import com.example.alexis.proyecto.model.DiaRutina;
import com.example.alexis.proyecto.model.Dieta;

import java.util.ArrayList;


/**
 * Created by Alexis on 19/03/2017.
 */
public class DiaRutinaAdaptador extends RecyclerView.Adapter<DiaRutinaAdaptador.DietaViewHolder>{

    ArrayList<DiaRutina> diaRutinas;
    Activity activity;

    public DiaRutinaAdaptador(ArrayList<DiaRutina> diaRutinas, Activity activity) {
        this.diaRutinas= diaRutinas;
        this.activity = activity;
    }

    @Override
    public DietaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_dia_rutina, parent, false);

        return new DietaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final DietaViewHolder dietaViewHolder, int position) {
        final DiaRutina contacto = diaRutinas.get(position);
        dietaViewHolder.imgFoto.setImageResource(contacto.getFoto());
        dietaViewHolder.tvNombre.setText(contacto.getNombre());
        dietaViewHolder.tvTelefono.setText(contacto.getTelefono());


        dietaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, MainActivity.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return diaRutinas.size();
    }

    public static class DietaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvTelefono;


        public DietaViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefono  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);


        }
    }
}
