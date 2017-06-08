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
 * Created by Alexis on 19/03/2017.
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

        int aleatoria = (int) (Math.random() * 3) + 1;

         if(aleatoria==1){
             iniciarDieta1();
        }else if(aleatoria==2){
             iniciarDieta2();
         }else{
             iniciarDieta3();
         }


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




    public void iniciarDieta1(){
        dietas = new ArrayList<>();
        dietas.add(new Dieta(R.drawable.oat, "Comida 1",  "\n• 1 vaso de leche descremada con una taza de corn flakes.\n"+
                "• 1(1/2) taza de frijoles cocidos.\n" +
                "• 3 porciones de pan integral.\n" +
                "• 1 fruta (pera, manzana o naranja).\n" +
                "• Agua.", ""));
        dietas.add(new Dieta(R.drawable.milk, "Comida 2", "• Un vaso de leche descremada con seis cucharadas de avena.", ""));
        dietas.add(new Dieta(R.drawable.rice, "Comida 3", "• 1 pechuga de pollo asada o a la plancha\n" +
                "• 1 taza de arroz cocido\n" +
                "• 4 porciones de pan integral ó 4 tortillas de maíz\n" +
                "• Ensalada fresca al gusto\n" +
                "• 1 fruta (manzana, pera o naranja)\n" +
                "• Agua a libre demanda", ""));
        dietas.add(new Dieta(R.drawable.milk, "Comida 4", "• Un vaso de leche descremada con seis cucharadas de avena", ""));
        dietas.add(new Dieta(R.drawable.groceries, "Comida 5", "• 11/4 taza de atún en agua\n" +
                "• 3 porciones de pan integral\n" +
                "• 2 tazas de espinaca cocida\n" +
                "• 1 plátano (macho) cocido\n" +
                "• Agua a libre demanda", ""));

    }

    public void iniciarDieta2(){
        dietas = new ArrayList<>();
            dietas.add(new Dieta(R.drawable.huevos, "Comida 1",  "• 120 g de avena\n"+
                    "• 3 claras de huevo\n"+
                    "• 2 yemas",""));
        dietas.add(new Dieta(R.drawable.atun, "Comida 2", "• 100 g Pan integral\n" +
                "• 80 g de atún", ""));
        dietas.add(new Dieta(R.drawable.oat, "Comida 3", "• 80 g de avena\n" +
                "• 200 g de queso Quark Sin grasa\n" +
                "• cacahuetes 50g", ""));
        dietas.add(new Dieta(R.drawable.salmon, "Comida 4", "• 200 g de salmón\n" +
                "• 100 g de arroz\n" +
                "• Brócoli", ""));
        dietas.add(new Dieta(R.drawable.avena, "Comida 5", "• 120 g de avena\n" +
                "• Manzana", ""));

    }
    public void iniciarDieta3(){
        dietas = new ArrayList<>();
        dietas.add(new Dieta(R.drawable.huevos, "Comida 1",  "• 2 huevos enteros\n" +
                "• 1/2 taza de avena o cereal integral\n" +
                "• 1/2 taza de leche descremada con semillas de linaza, girasol, amapola y calabaza\n" +
                "• 1 naranja",""));
        dietas.add(new Dieta(R.drawable.pavo, "Comida 2", "• atún o pechuga de pavo\n" +
                "• verdura mixta\n" +
                "• 1 cucharada de mayonesa baja en grasas\n" +
                "• pan integral\n" +
                "• 1 plátano pequeño\n" +
                "• 6 almendras\n" +
                "• jugo de soya", ""));
        dietas.add(new Dieta(R.drawable.carne, "Comida 3", "• 1 filete de pechuga de pollo u otra carne\n" +
                "• 3/4 tazas de arroz integral o pastas, o legumbres.\n" +
                "• 1/4 pimiento picado\n" +
                "• 1/4 taza de champiñones picados\n" +
                "• 1/4 taza de zanahorias picadas\n" +
                "• 1 cucharada de aceite de oliva", ""));
        dietas.add(new Dieta(R.drawable.yogur, "Comida 4", "• 1 yogurt griego\n" +
                "• 1 cereal integral o avena", ""));
        dietas.add(new Dieta(R.drawable.filete, "Comida 5", "• 1 filete de pollo u otra carne\n" +
                "• 1 pan integral\n" +
                "• 1 cucharada de mayonesa baja en grasas\n" +
                "• vegetales mixtos picados", ""));
        dietas.add(new Dieta(R.drawable.almendras, "Comida 6", "• 1 trozo de queso\n" +
                "• 1 cucharadas de mantequilla de maní natural\n" +
                "• 1/2 taza de avena (medida en crudo o seca)\n" +
                "• 10 almendras u otro fruto seco\n" +
                "• verduras", ""));

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
