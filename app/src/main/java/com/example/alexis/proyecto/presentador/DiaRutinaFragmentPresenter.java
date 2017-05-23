package com.example.alexis.proyecto.presentador;

import android.content.Context;

import com.example.alexis.proyecto.fragment.DiaRutinaFragment;
import com.example.alexis.proyecto.fragment.IDiaRutinaFragmentView;
import com.example.alexis.proyecto.fragment.IDiaRutinaFragmentView;
import com.example.alexis.proyecto.model.ConstructorDiaRutina;
import com.example.alexis.proyecto.model.ConstructorDietas;
import com.example.alexis.proyecto.model.DiaRutina;
import com.example.alexis.proyecto.model.Dieta;

import java.util.ArrayList;


/**
 * Created by Alexis on 19/03/2017.
 */
public class DiaRutinaFragmentPresenter implements IRecylerViewFragmentPresenter {

    private IDiaRutinaFragmentView IDiaRutinaFragmentView;

    private Context context;
    private ConstructorDiaRutina ConstructorDiaRutina;
    private ArrayList<DiaRutina> diaRutinas;

 
    public DiaRutinaFragmentPresenter(IDiaRutinaFragmentView IDiaRutinaFragmentView, Context context) {
        this.IDiaRutinaFragmentView = IDiaRutinaFragmentView;
        this.context = context;
        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        ConstructorDiaRutina = new ConstructorDiaRutina(context);
        diaRutinas = ConstructorDiaRutina.obtenerDatos();
        mostrarContactosRV();
    }


    @Override
    public void mostrarContactosRV() {
        IDiaRutinaFragmentView.inicializarAdaptadorRV(IDiaRutinaFragmentView.crearAdaptador(diaRutinas));
        IDiaRutinaFragmentView.generarLinearLayoutVertical();
    }
}
