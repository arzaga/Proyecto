package com.example.alexis.proyecto.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexis.proyecto.R;
import com.example.alexis.proyecto.adapter.DiaRutinaAdaptador;
import com.example.alexis.proyecto.model.DiaRutina;
import com.example.alexis.proyecto.presentador.DiaRutinaFragmentPresenter;

import java.util.ArrayList;


/**
 * Created by Alexis on 19/03/2017.
 */
public class DiaRutinaFragment extends Fragment implements IDiaRutinaFragmentView {
    private ArrayList<DiaRutina> diaRutinas;
    private RecyclerView rvDiaRutinas;
    private Cursor fila;
    private DiaRutinaFragmentPresenter presenter;
//    String UsuarioIniciado; IRecylerViewFragmentPresenter
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_dia_rutina, container, false);

        rvDiaRutinas = (RecyclerView) v.findViewById(R.id.rvDiaRutinas);
        presenter = new DiaRutinaFragmentPresenter(this, getContext());
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
        diaRutinas = new ArrayList<>();
        diaRutinas.add(new DiaRutina(R.drawable.pierna, "PIERNA", "", ""));
        diaRutinas.add(new DiaRutina(R.drawable.pecho, "PECHO", "", ""));
        diaRutinas.add(new DiaRutina(R.drawable.espalda, "ESPALDA", "", ""));
        diaRutinas.add(new DiaRutina(R.drawable.hombro, "HOMBRO", "", ""));
        diaRutinas.add(new DiaRutina(R.drawable.brazo, "BRAZO", "", ""));
    }

public DiaRutinaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new DiaRutinaAdaptador(diaRutinas, getActivity());
        rvDiaRutinas.setAdapter(adaptador);
    }

    @Override
    public void generarLinearLayoutVertical() {
        GridLayoutManager glm = new GridLayoutManager(getContext(),2);

//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvDiaRutinas.setLayoutManager(glm);
    }
//aqui
    @Override
    public DiaRutinaAdaptador crearAdaptador(ArrayList<DiaRutina> diaRutinas) {
        DiaRutinaAdaptador adaptador = new DiaRutinaAdaptador(diaRutinas, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(DiaRutinaAdaptador adaptador) {
        rvDiaRutinas.setAdapter(adaptador);
    }
}
