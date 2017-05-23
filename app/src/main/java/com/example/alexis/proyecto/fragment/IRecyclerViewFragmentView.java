package com.example.alexis.proyecto.fragment;

import com.example.alexis.proyecto.adapter.DietaAdaptador;
import com.example.alexis.proyecto.model.Dieta;

import java.util.ArrayList;


/**
 * Created by Alexis on 19/03/2017.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public DietaAdaptador crearAdaptador(ArrayList<Dieta> dietas);

    public void inicializarAdaptadorRV(DietaAdaptador adaptador);


}
