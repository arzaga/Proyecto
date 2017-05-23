package com.example.alexis.proyecto.presentador;

import android.content.Context;


import com.example.alexis.proyecto.fragment.IRecyclerViewFragmentView;
import com.example.alexis.proyecto.model.ConstructorDietas;
import com.example.alexis.proyecto.model.Dieta;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 21/04/16.
 */
public class RecyclerViewFragmentPresenter implements IRecylerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;

    private Context context;
    private ConstructorDietas constructorContactos;
    private ArrayList<Dieta> contactos;

    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorDietas(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }


    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
