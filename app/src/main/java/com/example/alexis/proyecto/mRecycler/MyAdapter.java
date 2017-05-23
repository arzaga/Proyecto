package com.example.alexis.proyecto.mRecycler;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexis.proyecto.R;
import com.example.alexis.proyecto.mData.SpaceCraft;
import com.example.alexis.proyecto.mDetail.DetailActivity;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/11/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<SpaceCraft> spaceCrafts;

    public MyAdapter(Context c, ArrayList<SpaceCraft> spaceCrafts) {
        this.c = c;
        this.spaceCrafts = spaceCrafts;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        final String name=spaceCrafts.get(position).getName();
        final String Series=spaceCrafts.get(position).getSeries();
        final int image=spaceCrafts.get(position).getImage();

        //BIND DATA
        holder.nameTxt.setText(name);
        holder.txtSeries.setText(Series);
        holder.img.setImageResource(image);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name,Series,image);
                final Dialog miCuadroDialogo= new Dialog(c);
                miCuadroDialogo.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                miCuadroDialogo.setContentView(R.layout.gif);
                TextView txtGif;
                LinearLayout layoutGif;
                final EditText edtPass,edtUsuario, kk;
                ImageView imgView;
                Activity gif;

                imgView=(ImageView) miCuadroDialogo.findViewById(R.id.imgGif);
                txtGif=(TextView)miCuadroDialogo.findViewById(R.id.txtGif);
                layoutGif=(LinearLayout) miCuadroDialogo.findViewById(R.id.layoutGif);
                txtGif.setText(Series);
                imgView.setImageResource(image);
                    imgView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                       miCuadroDialogo.hide();
                        }
                    });

                layoutGif.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        miCuadroDialogo.hide();
                    }
                });
                miCuadroDialogo.show();
                Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return spaceCrafts.size();
    }

    private void openDetailActivity(String s, String name, int image)
    {
//        Intent i=new Intent(c, DetailActivity.class);
//
//        //PACK DATA TO SEND
//        i.putExtra("NAME_KEY",name);
//        i.putExtra("IMAGE_KEY",image);
//
//        //open activity
//        c.startActivity(i);



    }

//    public void onLogin(View view){
//        final Dialog miCuadroDialogo= new Dialog(this);
//        miCuadroDialogo.setContentView(R.layout.usuario);
//        TextView txtPass, txtUsuario;
//        final EditText edtPass,edtUsuario, kk;
//        ImageView imgView;
//        Button btn1;
//
//
//        edtPass=(EditText)miCuadroDialogo.findViewById(R.id.edtPass);
//        edtUsuario=(EditText) miCuadroDialogo.findViewById(R.id.edtUsuario);
//        imgView=(ImageView) miCuadroDialogo.findViewById(R.id.imgView);
//        btn1 = (Button)miCuadroDialogo.findViewById(R.id.btn1);
//        kk=(EditText)findViewById(R.id.edtUsuario);
//        int resource = imagenesID[rgenerador.nextInt(
//                imagenesID.length)];
//        imgView.setImageResource(resource);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String us="alexis",pas="alexis";
//                System.out.print(edtUsuario.getText().toString());
//                if ((edtUsuario.getText().toString().equals(us)) && (edtPass.getText().toString().equals(us))) {
//                    Toast.makeText(miContex, us, Toast.LENGTH_SHORT).show();
//                    miCuadroDialogo.dismiss();
//                    Intent lanzar = new Intent(miContex,Bienvenido.class);
//                    startActivity(lanzar);
//
//                }else{
//                    Toast.makeText(miContex, "Contraseña o Usuario Incorrectos", Toast.LENGTH_LONG).show();
//                }
//
//
//            }
//        });
//        miCuadroDialogo.show();
//    }
}
