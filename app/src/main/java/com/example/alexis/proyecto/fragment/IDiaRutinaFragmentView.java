package com.example.alexis.proyecto.fragment;

import com.example.alexis.proyecto.adapter.DiaRutinaAdaptador;
import com.example.alexis.proyecto.adapter.DietaAdaptador;
import com.example.alexis.proyecto.model.DiaRutina;
import com.example.alexis.proyecto.model.Dieta;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 21/04/16.
 */
public interface IDiaRutinaFragmentView {

    public void generarLinearLayoutVertical();

    public DiaRutinaAdaptador crearAdaptador(ArrayList<DiaRutina> diaRutinas);

    public void inicializarAdaptadorRV(DiaRutinaAdaptador adaptador);



}
