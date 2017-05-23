package com.example.alexis.proyecto.fragment;

import com.example.alexis.proyecto.adapter.DietaAdaptador;
import com.example.alexis.proyecto.model.Dieta;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 21/04/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public DietaAdaptador crearAdaptador(ArrayList<Dieta> dietas);

    public void inicializarAdaptadorRV(DietaAdaptador adaptador);


}
