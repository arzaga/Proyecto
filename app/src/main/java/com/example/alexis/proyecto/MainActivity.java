package com.example.alexis.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.alexis.proyecto.mData.SpaceCraft;
import com.example.alexis.proyecto.mRecycler.MyAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Recibe datos de que rutina toca
        Bundle extras      = getIntent().getExtras();
        String nombre      = extras.getString("nombre");
        String telefono    = extras.getString("telefono");
        String email       = extras.getString("email");

        RecyclerView rv= (RecyclerView) findViewById(R.id.rv);
//        rv.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager glm = new GridLayoutManager(this,2);

//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
        if(nombre.equals("PIERNA")){
            rv.setLayoutManager(glm);
            MyAdapter adapter=new MyAdapter(this, Pierna.getPierna());
            rv.setAdapter(adapter);
        }else if(nombre.equals("PECHO")){
            rv.setLayoutManager(glm);
            MyAdapter adapter=new MyAdapter(this, Pecho.getPecho());
            rv.setAdapter(adapter);
        }else if(nombre.equals("ESPALDA")){
            rv.setLayoutManager(glm);
            MyAdapter adapter=new MyAdapter(this, Espalda.getEspalda());
            rv.setAdapter(adapter);
        }else if(nombre.equals("HOMBRO")){
            rv.setLayoutManager(glm);
            MyAdapter adapter=new MyAdapter(this, Hombro.getHombro());
            rv.setAdapter(adapter);
        }else if(nombre.equals("BRAZO")){
            rv.setLayoutManager(glm);
            MyAdapter adapter=new MyAdapter(this, Brazo.getBrazo());
            rv.setAdapter(adapter);
        }

    }
    public static class Pierna {

        public static ArrayList<SpaceCraft> getPierna()
        {
            ArrayList<SpaceCraft> spaceCrafts=new ArrayList<>();
            SpaceCraft spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Sentadilla libre");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.sentadillalibre);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Prensa");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.prensa);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Abductores Internos");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.abductoresinternos);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Peso muerto rumano");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.pesomuertorumano);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Femoral Acostado");
            spaceCraft.setSeries("3/15");
            spaceCraft.setImage(R.drawable.femoralacostado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Elevacion de talon de pie");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.elevaciontalondepie);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Elevación de talones Costurera");
            spaceCraft.setSeries("3/15");
            spaceCraft.setImage(R.drawable.costurera);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Pecho {

        public static ArrayList<SpaceCraft> getPecho()
        {
            ArrayList<SpaceCraft> spaceCrafts=new ArrayList<>();
            SpaceCraft spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Press de banca Horizontal");
            spaceCraft.setSeries("4/6,6,8,8");
            spaceCraft.setImage(R.drawable.pressbancohorizontal);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Press con mancuernas\t");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.pressmanchoriz);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Aperturas banco inclinado");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.aperturasinclinado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Fondos en paralelas");
            spaceCraft.setSeries("3/fallo");
            spaceCraft.setImage(R.drawable.fondosenparalelas);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Extensiones acostado");
            spaceCraft.setSeries("3/10-12");
            spaceCraft.setImage(R.drawable.extencionesacostado);
            spaceCrafts.add(spaceCraft);


            //RETURN COLLECTION
            return spaceCrafts;
        }

    }

    public static class Espalda {

        public static ArrayList<SpaceCraft> getEspalda()
        {
            ArrayList<SpaceCraft> spaceCrafts=new ArrayList<>();
            SpaceCraft spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Dominadas");
            spaceCraft.setSeries("3/fallo");
            spaceCraft.setImage(R.drawable.dominadas);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Remo con barra");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.remoconbarra);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Remo sentado en polea");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.remosentadopolea);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Jalón en polea");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.jalonpolea);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Hombro {

        public static ArrayList<SpaceCraft> getHombro()
        {
            ArrayList<SpaceCraft> spaceCrafts=new ArrayList<>();
            SpaceCraft spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Press militar con Barra");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.presshombrobarra);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Remo con barra de pie");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.remobarradepie);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Elevación lateral");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.elevacioneslaterales);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Encogimiento con barra");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.encogimientoconbarra);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Encogimiento con mancuernas");
            spaceCraft.setSeries("2/10");
            spaceCraft.setImage(R.drawable.encogimientoconmancuerna);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Brazo {

        public static ArrayList<SpaceCraft> getBrazo()
        {
            ArrayList<SpaceCraft> spaceCrafts=new ArrayList<>();
            SpaceCraft spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Curl de brazos con barra");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.curlbisepdepie);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Curl predicador");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.curlpredicador);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Curl de brazos en banco inclinado");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.currlbisepinclinado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Press California");
            spaceCraft.setSeries("3/6,6,8");
            spaceCraft.setImage(R.drawable.pecho);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Jalon en polea, barra recta");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.jalonpoleabarrarecta);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new SpaceCraft();
            spaceCraft.setName("Copa a una mano");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.copaunamano);
            spaceCrafts.add(spaceCraft);


            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
}