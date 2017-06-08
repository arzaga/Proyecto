package com.example.alexis.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alexis.proyecto.mData.mDataRutinas;
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
        int aleatoria = (int) (Math.random() * 2) + 1;
        if(nombre.equals("PIERNA")){
            rv.setLayoutManager(glm);
            if(aleatoria==1){
                MyAdapter adapter=new MyAdapter(this, Pierna.getPierna());
                rv.setAdapter(adapter);
            }else{
                MyAdapter adapter=new MyAdapter(this, Pierna2.getPierna2());
                rv.setAdapter(adapter);
            }

        }else if(nombre.equals("PECHO")){
            rv.setLayoutManager(glm);

            if(aleatoria==1){
                MyAdapter adapter=new MyAdapter(this, Pecho.getPecho());
                rv.setAdapter(adapter);
            }else{
                MyAdapter adapter=new MyAdapter(this, Pecho2.getPecho2());
                rv.setAdapter(adapter);
            }

        }else if(nombre.equals("ESPALDA")){
            rv.setLayoutManager(glm);

            if(aleatoria==1){
                MyAdapter adapter=new MyAdapter(this, Espalda.getEspalda());
                rv.setAdapter(adapter);
            }else{
                MyAdapter adapter=new MyAdapter(this, Espalda2.getEspalda2());
                rv.setAdapter(adapter);
            }

        }else if(nombre.equals("HOMBRO")){
            rv.setLayoutManager(glm);

            if(aleatoria==1){
                MyAdapter adapter=new MyAdapter(this, Hombro.getHombro());
                rv.setAdapter(adapter);
            }else{
                MyAdapter adapter=new MyAdapter(this, Hombro2.getHombro2());
                rv.setAdapter(adapter);
            }

        }else if(nombre.equals("BRAZO")){
            rv.setLayoutManager(glm);

            if(aleatoria==1){
                MyAdapter adapter=new MyAdapter(this, Brazo.getBrazo());
                rv.setAdapter(adapter);
            }else{
                MyAdapter adapter=new MyAdapter(this, Brazo2.getBrazo2());
                rv.setAdapter(adapter);
            }

        }

    }
    public static class Pierna {

        public static ArrayList<mDataRutinas> getPierna()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Sentadilla libre");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.sentadillalibre);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Prensa");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.prensa);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Abductores Internos");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.abductoresinternos);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Peso muerto rumano");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.pesomuertorumano);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Femoral Acostado");
            spaceCraft.setSeries("3/15");
            spaceCraft.setImage(R.drawable.femoralacostado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Elevacion de talon de pie");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.elevaciontalondepie);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Elevación de talones Costurera");
            spaceCraft.setSeries("3/15");
            spaceCraft.setImage(R.drawable.costurera);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Pierna2 {

        public static ArrayList<mDataRutinas> getPierna2()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Sentadilla libre");
            spaceCraft.setSeries("4/12,10,10,8");
            spaceCraft.setImage(R.drawable.sentadillalibre);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Extencion de Cuádricep");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.extencioncuadricep);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Peso muerto rumano");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.pesomuertorumano);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Femoral Acostado");
            spaceCraft.setSeries("3/15");
            spaceCraft.setImage(R.drawable.femoralacostado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Femoral de Pie");
            spaceCraft.setSeries("2/12");
            spaceCraft.setImage(R.drawable.elevaciontalondepie);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Elevación de talones Costurera");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.costurera);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Pecho {

        public static ArrayList<mDataRutinas> getPecho()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press de banca Horizontal");
            spaceCraft.setSeries("4/6,6,8,8");
            spaceCraft.setImage(R.drawable.pressbancohorizontal);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press con mancuernas\t");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.pressmanchoriz);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Aperturas banco inclinado");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.aperturasinclinado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Fondos en paralelas");
            spaceCraft.setSeries("3/fallo");
            spaceCraft.setImage(R.drawable.fondosenparalelas);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Extensiones acostado");
            spaceCraft.setSeries("3/10-12");
            spaceCraft.setImage(R.drawable.extencionesacostado);
            spaceCrafts.add(spaceCraft);


            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Pecho2 {

        public static ArrayList<mDataRutinas> getPecho2()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press Inclinado");
            spaceCraft.setSeries("4/10,8,8,10");
            spaceCraft.setImage(R.drawable.pressbancoinclinado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press de banco Horizontal");
            spaceCraft.setSeries("3/10,8,10");
            spaceCraft.setImage(R.drawable.pressbancohorizontal);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Aperturas banco Inclinado");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.aperturasinclinado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press Declinado");
            spaceCraft.setSeries("3/10,8,10");
            spaceCraft.setImage(R.drawable.pressdeclinado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Pullover");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.pullovermancuernapecho);
            spaceCrafts.add(spaceCraft);


            //RETURN COLLECTION
            return spaceCrafts;
        }

    }

    public static class Espalda {

        public static ArrayList<mDataRutinas> getEspalda()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Dominadas");
            spaceCraft.setSeries("3/fallo");
            spaceCraft.setImage(R.drawable.dominadas);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Remo con barra");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.remoconbarra);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Remo sentado en polea");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.remosentadopolea);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Jalón en polea");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.jalonpolea);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Espalda2 {

        public static ArrayList<mDataRutinas> getEspalda2()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Dominadas");
            spaceCraft.setSeries("3/9");
            spaceCraft.setImage(R.drawable.dominadas);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Jalón Trasnuca");
            spaceCraft.setSeries("4/12,10,10,12");
            spaceCraft.setImage(R.drawable.jalontrasnuca);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Jalón al Pecho");
            spaceCraft.setSeries("3/12,10,12");
            spaceCraft.setImage(R.drawable.jalonpolea);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Remo a una mano Mancuerna");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.remoaunamano);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Hombro {

        public static ArrayList<mDataRutinas> getHombro()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press militar con Barra");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.presshombrobarra);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Remo con barra de pie");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.remobarradepie);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Elevación lateral");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.elevacioneslaterales);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Encogimiento con barra");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.encogimientoconbarra);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Encogimiento con mancuernas");
            spaceCraft.setSeries("2/10");
            spaceCraft.setImage(R.drawable.encogimientoconmancuerna);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Hombro2 {

        public static ArrayList<mDataRutinas> getHombro2()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press militar con Mancuernas");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.presshombrosmancuernas);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Elevación Frontal con disco");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.elevacionfrontaldisco);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Elevación lateral");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.elevacioneslaterales);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Pájaros");
            spaceCraft.setSeries("2/8");
            spaceCraft.setImage(R.drawable.pajaronlateraleshombro);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Encogimiento con mancuernas");
            spaceCraft.setSeries("2/10");
            spaceCraft.setImage(R.drawable.encogimientoconmancuerna);
            spaceCrafts.add(spaceCraft);
            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Brazo {

        public static ArrayList<mDataRutinas> getBrazo()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Curl de brazos con barra");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.curlbisepdepie);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Curl predicador");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.curlpredicador);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Curl de brazos en banco inclinado");
            spaceCraft.setSeries("3/12");
            spaceCraft.setImage(R.drawable.currlbisepinclinado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press California");
            spaceCraft.setSeries("3/6,6,8");
            spaceCraft.setImage(R.drawable.presscalifornia);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Jalon en polea, barra recta");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.jalonpoleabarrarecta);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Copa a una mano");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.copaunamano);
            spaceCrafts.add(spaceCraft);


            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
    public static class Brazo2 {

        public static ArrayList<mDataRutinas> getBrazo2()
        {
            ArrayList<mDataRutinas> spaceCrafts=new ArrayList<>();
            mDataRutinas spaceCraft=null;

            //ADD DATA TO COLLECTION
            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Curl de brazos con barra");
            spaceCraft.setSeries("3/12,10,8");
            spaceCraft.setImage(R.drawable.curlbisepdepie);
            spaceCrafts.add(spaceCraft);


            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Curl martillo");
            spaceCraft.setSeries("3/10");
            spaceCraft.setImage(R.drawable.curlmartillo);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Curl predicador con Mancuerna");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.curlpredicadormancuerna);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Curl concentrado");
            spaceCraft.setSeries("2/10");
            spaceCraft.setImage(R.drawable.curlconcentrado);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Jalon en polea, barra recta");
            spaceCraft.setSeries("4/12,10,8,10");
            spaceCraft.setImage(R.drawable.jalonpoleabarrarecta);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Press Francés con Mancuernas");
            spaceCraft.setSeries("3/8");
            spaceCraft.setImage(R.drawable.pressfrancesmancuernas);
            spaceCrafts.add(spaceCraft);

            spaceCraft=new mDataRutinas();
            spaceCraft.setName("Fondos");
            spaceCraft.setSeries("3/10,8,10");
            spaceCraft.setImage(R.drawable.fondosbancos);
            spaceCrafts.add(spaceCraft);


            //RETURN COLLECTION
            return spaceCrafts;
        }

    }
}