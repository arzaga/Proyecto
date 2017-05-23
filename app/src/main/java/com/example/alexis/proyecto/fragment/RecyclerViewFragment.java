package com.example.alexis.proyecto.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.alexis.proyecto.Calculo;
import com.example.alexis.proyecto.ControlSesion.ControlSesion;
import com.example.alexis.proyecto.R;
import com.example.alexis.proyecto.adapter.DietaAdaptador;
import com.example.alexis.proyecto.model.Dieta;
import com.example.alexis.proyecto.presentador.IRecylerViewFragmentPresenter;
import com.example.alexis.proyecto.presentador.RecyclerViewFragmentPresenter;


import java.util.ArrayList;

import OpenHelper.SQLite_OpenHelper;

/**
 * Created by anahisalgado on 20/04/16.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    private ArrayList<Dieta> dietas;
    private RecyclerView rvDietas;
    private Cursor fila;
    private IRecylerViewFragmentPresenter presenter;
//    String UsuarioIniciado;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvDietas = (RecyclerView) v.findViewById(R.id.rvDietas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        inicializarDatos();
        inicializarAdaptador();

        //Recibe Usuario iniciado

//        UsuarioIniciado = getArguments().getString("UsuarioIniciado");

//        SQLite_OpenHelper admin=new SQLite_OpenHelper(getContext(),"BD1",null,1);
//        SQLiteDatabase db=admin.getWritableDatabase();
//        fila=db.rawQuery("select IngestaDiaria,TMB,pGRASA,,IMC,MasaCorporalMagra,CinturaAltura from calculo where _IDTabUsu='"+UsuarioIniciado,null);
//        //preguntamos si el cursor tiene algun valor almacenado
//        if(fila.moveToFirst()==true){
//            //capturamos los valores del cursos y lo almacenamos en variable
//            String IngestaDiaria=fila.getString(0);
//            String TMB=fila.getString(1);
//            String pGRASA=fila.getString(2);
//            String IMC=fila.getString(3);
//            String MasaCorporalMagra=fila.getString(4);
//            String CinturaAltura=fila.getString(5);
//
//
//        }else{
//            Toast.makeText(getContext(),"User not Existent or Wrong User and Pass ",Toast.LENGTH_SHORT).show();
//        }

        return v;
    }




    public void inicializarDatos(){
        dietas = new ArrayList<>();
        dietas.add(new Dieta(R.drawable.oat, "Comida 1",  "\n• 1 vaso de leche descremada con una taza de corn flakes.\n"+
                "• 1(1/2) taza de frijoles cocidos.\n" +
                "• 3 porciones de pan integral.\n" +
                "• 1 fruta (pera, manzana o naranja).\n" +
                "• Agua.", "anahi@gmail.com"));
        dietas.add(new Dieta(R.drawable.milk, "Comida 2", "• Un vaso de leche descremada con seis cucharadas de avena.", "pedro@gmail.com"));
        dietas.add(new Dieta(R.drawable.rice, "Comida 3", "• 1 pechuga de pollo asada o a la plancha\n" +
                "• 1 taza de arroz cocido\n" +
                "• 4 porciones de pan integral ó 4 tortillas de maíz\n" +
                "• Ensalada fresca al gusto\n" +
                "• 1 fruta (manzana, pera o naranja)\n" +
                "• Agua a libre demanda", "mireya@gmail.com"));
        dietas.add(new Dieta(R.drawable.milk, "Comida 4", "• Un vaso de leche descremada con seis cucharadas de avena", "juan@gmail.com"));
        dietas.add(new Dieta(R.drawable.groceries, "Comida 5", "• 11/4 taza de atún en agua\n" +
                "• 3 porciones de pan integral\n" +
                "• 2 tazas de espinaca cocida\n" +
                "• 1 plátano (macho) cocido\n" +
                "• Agua a libre demanda", "juan@gmail.com"));

    }

public DietaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new DietaAdaptador(dietas, getActivity());
        rvDietas.setAdapter(adaptador);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvDietas.setLayoutManager(llm);

    }
//aqui
    @Override
    public DietaAdaptador crearAdaptador(ArrayList<Dieta> dietas) {
        DietaAdaptador adaptador = new DietaAdaptador(dietas, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(DietaAdaptador adaptador) {
        rvDietas.setAdapter(adaptador);
    }
}
