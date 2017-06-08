package com.example.alexis.proyecto;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexis.proyecto.ControlSesion.ControlSesion;

import OpenHelper.SQLite_OpenHelper;

public class Calculo extends AppCompatActivity {
    EditText edtAltura,edtPeso,edtCuello,edtCintura,edtCadera,edtEdad;
    TextView txtCadera;
    RadioButton rbHombre,rbMujer,rbPocoNinguno,rbLigero,rbModerado,rbFuerte;
    RadioGroup rgActividad,rgSexo;
    SQLite_OpenHelper helper= new SQLite_OpenHelper(this,"BD1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
//       mCompartir
        //EditText
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtCuello = (EditText) findViewById(R.id.edtCuello);
        edtCintura = (EditText) findViewById(R.id.edtCintura);
        edtCadera = (EditText) findViewById(R.id.edtCadera);
        edtEdad = (EditText) findViewById(R.id.edtEdad);
        //TextView
        txtCadera = (TextView)findViewById(R.id.txtCadera);
        //RadioButton
        rbHombre =(RadioButton)findViewById(R.id.rbHombre);
        rbMujer =(RadioButton)findViewById(R.id.rbMujer);

        rbPocoNinguno =(RadioButton)findViewById(R.id.rbPocoNinguno);
        rbLigero =(RadioButton)findViewById(R.id.rbLigero);
        rbModerado =(RadioButton)findViewById(R.id.rbModerado);
        rbFuerte =(RadioButton)findViewById(R.id.rbFuerte);

        //RadioGroups
        rgActividad = (RadioGroup)findViewById(R.id.rgActividad);
        rgSexo = (RadioGroup)findViewById(R.id.rgSexo);
        //Valores predefinidos
        edtCadera.setEnabled(false);
        rgSexo.setEnabled(false);
        rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbHombre:
                        //Accion
                        edtCadera.setEnabled(false);
                        rgSexo.setEnabled(false);
                        break;
                    case R.id.rbMujer:
                        //Accion
                        edtCadera.setEnabled(true);
                        rgSexo.setEnabled(true);
                        break;

                }
            }
        });


    }
    public void onClickCalculo(View view){
        String sAltura,sPeso,sCuello,sCintura,sCadera,sEdad;
        sAltura = edtAltura.getText().toString();
        sPeso = edtPeso.getText().toString();
        sCuello = edtCuello.getText().toString();
        sCintura = edtCintura.getText().toString();
        sCadera = edtCadera.getText().toString();
        sEdad = edtEdad.getText().toString();

        if(sAltura.isEmpty()||sPeso.isEmpty()||sCuello.isEmpty()||sCintura.isEmpty()||sEdad.isEmpty()){
            Toast.makeText(this, "Campos Vacíos", Toast.LENGTH_SHORT).show();

        }else{


    calculos();
        }
    }
    public void calculos(){

         double altura,peso,edad,cintura,cuello,cadera;
        //Cambio a int
        altura = Double.parseDouble(edtAltura.getText().toString());
        peso = Double.parseDouble(edtPeso.getText().toString());
        edad = Double.parseDouble(edtEdad.getText().toString());
        cintura = Double.parseDouble(edtCintura.getText().toString());
        cuello = Double.parseDouble(edtCuello.getText().toString());

        double TMB,IngestaDiaria,IMC,pGRASA,CinturaAltura,MasaCorporalMagra;
        //Poco Ejercicio
        //Recibe el usuario
//        Bundle datos = this.getIntent().getExtras();
        String intUser = getIntent().getStringExtra("intUser");


//        Fragment fragment = new Fragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("intUser", intUser);
//        fragment.setArguments(bundle);

    if(rbPocoNinguno.isChecked()) {
    //Accion
        if (rbHombre.isChecked()) {
            //Tasa Metabolica Basal e Ingesta de Calorias Diarias
              TMB = (double) ((10 * peso) + (6.25 * altura) - (5 * edad) + 5);
            IngestaDiaria = (double) (TMB * 1.2);
            //Porcentaje Grasa y Indice de Masa Corporal
            pGRASA=495/(1.0324-0.19077*(Math.log10(cintura-cuello))+0.15456*(Math.log10(altura)))-450;
            IMC=(peso/((altura/100)*(altura/100)));
            //CinturaAltura y Masa Corporal Magra
            MasaCorporalMagra=(peso*(100-pGRASA))/100;
            CinturaAltura=cintura/altura;
            //  Toast.makeText(Calculo.this, " %Grasa: "+pGRASA+" IMC: "+IMC, Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Ingesta Diaria: " + String.format("%.4f", IngestaDiaria) + "\n" +
                    "TMB: " + String.format("%.4f", TMB)+"\n" +
                    "Porcentaje Grasa: "+String.format("%.4f", pGRASA)+"%\n" +
                    "IMC: "+String.format("%.4f", IMC)+"\n" +
                    "Masa Corporal Magra: "+String.format("%.4f",MasaCorporalMagra)+"\n" +
                    "Índice Cintura Altura: "+String.format("%.4f",CinturaAltura))
                    .setTitle("Datos")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent lanzar = new Intent(getBaseContext(), Menutab.class);
                                    startActivity(lanzar);
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();


//            String sIngestaDiaria,sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura;
//            sIngestaDiaria=Double.toString(IngestaDiaria);
//            sTMB=Double.toString(TMB);
//            spGRASA=Double.toString(pGRASA);
//            sIMC=Double.toString(IMC);
//            sMasaCorporalMagra=Double.toString(MasaCorporalMagra);
//            sCinturaAltura=Double.toString(CinturaAltura);
//
//            helper.abrir();
//            helper.insCalculo(sIngestaDiaria,
//                   sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura,intUser);
//            helper.close();

         } else if (rbMujer.isChecked()) {
            //Tasa Metabolica Basal e Ingesta de Calorias Diarias
            TMB = (double) ((10 * peso) + (6.25 * altura) - (5 * edad) - 161);
            IngestaDiaria = (double) (TMB * 1.2);
            cadera = Double.parseDouble(edtCadera.getText().toString());

            //Porcentaje Grasa y Indice de Masa Corporal
            pGRASA=495/(1.29579-0.35004*(Math.log10(cintura+cadera-cuello))+0.22100*(Math.log10(altura)))-450;
            IMC=(peso/((altura/100)*(altura/100)));

            //CinturaAltura y Masa Corporal Magra
            MasaCorporalMagra=(peso*(100-pGRASA))/100;
            CinturaAltura=cintura/altura;
            //  Toast.makeText(Calculo.this, " %Grasa: "+pGRASA+" IMC: "+IMC, Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Ingesta Diaria: " + String.format("%.4f", IngestaDiaria) + "\n" +
                    "TMB: " + String.format("%.4f", TMB)+"\n" +
                    "Porcentaje Grasa: "+String.format("%.4f", pGRASA)+"%\n" +
                    "IMC: "+String.format("%.4f", IMC)+"\n" +
                    "Masa Corporal Magra: "+String.format("%.4f",MasaCorporalMagra)+"\n" +
                    "Índice Cintura Altura: "+String.format("%.4f",CinturaAltura))
                    .setTitle("Datos")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent lanzar = new Intent(getBaseContext(), Menutab.class);
                                    startActivity(lanzar);
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

//            String sIngestaDiaria,sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura;
//            sIngestaDiaria=Double.toString(IngestaDiaria);
//            sTMB=Double.toString(TMB);
//            spGRASA=Double.toString(pGRASA);
//            sIMC=Double.toString(IMC);
//            sMasaCorporalMagra=Double.toString(MasaCorporalMagra);
//            sCinturaAltura=Double.toString(CinturaAltura);
//
//            helper.abrir();
//            helper.insCalculo(sIngestaDiaria,
//                    sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura,intUser);
//            helper.close();
        }
    }else
        //Ejercicio Ligero
    if(rbLigero.isChecked()) {
        //Accion
        if (rbHombre.isChecked()) {
            //Tasa Metabolica Basal e Ingesta de Calorias Diarias
            TMB = (double) ((10 * peso) + (6.25 * altura) - (5 * edad) + 5);
            IngestaDiaria = (double) (TMB * 1.375);
            //Porcentaje Grasa y Indice de Masa Corporal
            pGRASA=495/(1.0324-0.19077*(Math.log10(cintura-cuello))+0.15456*(Math.log10(altura)))-450;
            IMC=(peso/((altura/100)*(altura/100)));
            //CinturaAltura y Masa Corporal Magra
            MasaCorporalMagra=(peso*(100-pGRASA))/100;
            CinturaAltura=cintura/altura;
            //  Toast.makeText(Calculo.this, " %Grasa: "+pGRASA+" IMC: "+IMC, Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Ingesta Diaria: " + String.format("%.4f", IngestaDiaria) + "\n" +
                    "TMB: " + String.format("%.4f", TMB)+"\n" +
                    "Porcentaje Grasa: "+String.format("%.4f", pGRASA)+"%\n" +
                    "IMC: "+String.format("%.4f", IMC)+"\n" +
                    "Masa Corporal Magra: "+String.format("%.4f",MasaCorporalMagra)+"\n" +
                    "Índice Cintura Altura: "+String.format("%.4f",CinturaAltura))
                    .setTitle("Datos")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent lanzar = new Intent(getBaseContext(), Menutab.class);
                                    startActivity(lanzar);
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

//            String sIngestaDiaria,sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura;
//            sIngestaDiaria=Double.toString(IngestaDiaria);
//            sTMB=Double.toString(TMB);
//            spGRASA=Double.toString(pGRASA);
//            sIMC=Double.toString(IMC);
//            sMasaCorporalMagra=Double.toString(MasaCorporalMagra);
//            sCinturaAltura=Double.toString(CinturaAltura);
//
//            helper.abrir();
//            helper.insCalculo(sIngestaDiaria,
//                    sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura,intUser);
//            helper.close();

        }  else if (rbMujer.isChecked()) {
            //Tasa Metabolica Basal e Ingesta de Calorias Diarias
            TMB = (double) ((10 * peso) + (6.25 * altura) - (5 * edad) - 161);
            IngestaDiaria = (double) (TMB * 1.375);
            cadera = Double.parseDouble(edtCadera.getText().toString());

            //Porcentaje Grasa y Indice de Masa Corporal
            pGRASA=495/(1.29579-0.35004*(Math.log10(cintura+cadera-cuello))+0.22100*(Math.log10(altura)))-450;
            IMC=(peso/((altura/100)*(altura/100)));

            //CinturaAltura y Masa Corporal Magra
            MasaCorporalMagra=(peso*(100-pGRASA))/100;
            CinturaAltura=cintura/altura;
            //  Toast.makeText(Calculo.this, " %Grasa: "+pGRASA+" IMC: "+IMC, Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Ingesta Diaria: " + String.format("%.4f", IngestaDiaria) + "\n" +
                    "TMB: " + String.format("%.4f", TMB)+"\n" +
                    "Porcentaje Grasa: "+String.format("%.4f", pGRASA)+"%\n" +
                    "IMC: "+String.format("%.4f", IMC)+"\n" +
                    "Masa Corporal Magra: "+String.format("%.4f",MasaCorporalMagra)+"\n" +
                    "Índice Cintura Altura: "+String.format("%.4f",CinturaAltura))
                    .setTitle("Datos")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent lanzar = new Intent(getBaseContext(), Menutab.class);
                                    startActivity(lanzar);
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

//            String sIngestaDiaria,sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura;
//            sIngestaDiaria=Double.toString(IngestaDiaria);
//            sTMB=Double.toString(TMB);
//            spGRASA=Double.toString(pGRASA);
//            sIMC=Double.toString(IMC);
//            sMasaCorporalMagra=Double.toString(MasaCorporalMagra);
//            sCinturaAltura=Double.toString(CinturaAltura);
//
//            helper.abrir();
//            helper.insCalculo(sIngestaDiaria,
//                    sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura,intUser);
//            helper.close();
        }
    }else
        //Ejercicio Moderado
        if(rbModerado.isChecked()) {
            //Accion
            if (rbHombre.isChecked()) {
                //Tasa Metabolica Basal e Ingesta de Calorias Diarias
                TMB = (double) ((10 * peso) + (6.25 * altura) - (5 * edad) + 5);
                IngestaDiaria = (double) (TMB * 1.55);
                //Porcentaje Grasa y Indice de Masa Corporal
                pGRASA=495/(1.0324-0.19077*(Math.log10(cintura-cuello))+0.15456*(Math.log10(altura)))-450;
                IMC=(peso/((altura/100)*(altura/100)));
                //CinturaAltura y Masa Corporal Magra
                MasaCorporalMagra=(peso*(100-pGRASA))/100;
                CinturaAltura=cintura/altura;
                //  Toast.makeText(Calculo.this, " %Grasa: "+pGRASA+" IMC: "+IMC, Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Ingesta Diaria: " + String.format("%.4f", IngestaDiaria) + "\n" +
                        "TMB: " + String.format("%.4f", TMB)+"\n" +
                        "Porcentaje Grasa: "+String.format("%.4f", pGRASA)+"%\n" +
                        "IMC: "+String.format("%.4f", IMC)+"\n" +
                        "Masa Corporal Magra: "+String.format("%.4f",MasaCorporalMagra)+"\n" +
                        "Índice Cintura Altura: "+String.format("%.4f",CinturaAltura))
                        .setTitle("Datos")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent lanzar = new Intent(getBaseContext(), Menutab.class);
                                        startActivity(lanzar);
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

//                String sIngestaDiaria,sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura;
//                sIngestaDiaria=Double.toString(IngestaDiaria);
//                sTMB=Double.toString(TMB);
//                spGRASA=Double.toString(pGRASA);
//                sIMC=Double.toString(IMC);
//                sMasaCorporalMagra=Double.toString(MasaCorporalMagra);
//                sCinturaAltura=Double.toString(CinturaAltura);
//
//                helper.abrir();
//                helper.insCalculo(sIngestaDiaria,
//                        sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura,intUser);
//                helper.close();
            }  else if (rbMujer.isChecked()) {
                //Tasa Metabolica Basal e Ingesta de Calorias Diarias
                TMB = (double) ((10 * peso) + (6.25 * altura) - (5 * edad) - 161);
                IngestaDiaria = (double) (TMB * 1.55);
                cadera = Double.parseDouble(edtCadera.getText().toString());

                //Porcentaje Grasa y Indice de Masa Corporal
                pGRASA=495/(1.29579-0.35004*(Math.log10(cintura+cadera-cuello))+0.22100*(Math.log10(altura)))-450;
                IMC=(peso/((altura/100)*(altura/100)));

                //CinturaAltura y Masa Corporal Magra
                MasaCorporalMagra=(peso*(100-pGRASA))/100;
                CinturaAltura=cintura/altura;
                //  Toast.makeText(Calculo.this, " %Grasa: "+pGRASA+" IMC: "+IMC, Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Ingesta Diaria: " + String.format("%.4f", IngestaDiaria) + "\n" +
                        "TMB: " + String.format("%.4f", TMB)+"\n" +
                        "Porcentaje Grasa: "+String.format("%.4f", pGRASA)+"%\n" +
                        "IMC: "+String.format("%.4f", IMC)+"\n" +
                        "Masa Corporal Magra: "+String.format("%.4f",MasaCorporalMagra)+"\n" +
                        "Índice Cintura Altura: "+String.format("%.4f",CinturaAltura))
                        .setTitle("Datos")
                        .setCancelable(false)
                        .setNeutralButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent lanzar = new Intent(getBaseContext(), Menutab.class);
                                        startActivity(lanzar);
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

//                String sIngestaDiaria,sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura;
//                sIngestaDiaria=Double.toString(IngestaDiaria);
//                sTMB=Double.toString(TMB);
//                spGRASA=Double.toString(pGRASA);
//                sIMC=Double.toString(IMC);
//                sMasaCorporalMagra=Double.toString(MasaCorporalMagra);
//                sCinturaAltura=Double.toString(CinturaAltura);
//
//                helper.abrir();
//                helper.insCalculo(sIngestaDiaria,
//                        sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura,intUser);
//                helper.close();
            }
        }else
            //Ejercicio Fuerte
            if(rbFuerte.isChecked()) {
                //Accion
                if (rbHombre.isChecked()) {
                    //Tasa Metabolica Basal e Ingesta de Calorias Diarias
                    TMB = (double) ((10 * peso) + (6.25 * altura) - (5 * edad) + 5);
                    IngestaDiaria = (double) (TMB * 1.725);
                    //Porcentaje Grasa y Indice de Masa Corporal
                    pGRASA=495/(1.0324-0.19077*(Math.log10(cintura-cuello))+0.15456*(Math.log10(altura)))-450;
                    IMC=(peso/((altura/100)*(altura/100)));
                    //CinturaAltura y Masa Corporal Magra
                    MasaCorporalMagra=(peso*(100-pGRASA))/100;
                    CinturaAltura=cintura/altura;
                    //  Toast.makeText(Calculo.this, " %Grasa: "+pGRASA+" IMC: "+IMC, Toast.LENGTH_LONG).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Ingesta Diaria: " + String.format("%.4f", IngestaDiaria) + "\n" +
                            "TMB: " + String.format("%.4f", TMB)+"\n" +
                            "Porcentaje Grasa: "+String.format("%.4f", pGRASA)+"%\n" +
                            "IMC: "+String.format("%.4f", IMC)+"\n" +
                            "Masa Corporal Magra: "+String.format("%.4f",MasaCorporalMagra)+"\n" +
                            "Índice Cintura Altura: "+String.format("%.4f",CinturaAltura))
                            .setTitle("Datos")
                            .setCancelable(false)
                            .setNeutralButton("Aceptar",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent lanzar = new Intent(getBaseContext(), Menutab.class);
                                            startActivity(lanzar);
                                            finish();
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

//                    String sIngestaDiaria,sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura;
//                    sIngestaDiaria=Double.toString(IngestaDiaria);
//                    sTMB=Double.toString(TMB);
//                    spGRASA=Double.toString(pGRASA);
//                    sIMC=Double.toString(IMC);
//                    sMasaCorporalMagra=Double.toString(MasaCorporalMagra);
//                    sCinturaAltura=Double.toString(CinturaAltura);
//
//                    helper.abrir();
//                    helper.insCalculo(sIngestaDiaria,
//                            sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura,intUser);
//                    helper.close();
                }  else if (rbMujer.isChecked()) {
                    //Tasa Metabolica Basal e Ingesta de Calorias Diarias
                    TMB = (double) ((10 * peso) + (6.25 * altura) - (5 * edad) - 161);
                    IngestaDiaria = (double) (TMB * 1.725);
                    cadera = Double.parseDouble(edtCadera.getText().toString());

                    //Porcentaje Grasa y Indice de Masa Corporal
                    pGRASA=495/(1.29579-0.35004*(Math.log10(cintura+cadera-cuello))+0.22100*(Math.log10(altura)))-450;
                    IMC=(peso/((altura/100)*(altura/100)));

                    //CinturaAltura y Masa Corporal Magra
                    MasaCorporalMagra=(peso*(100-pGRASA))/100;
                    CinturaAltura=cintura/altura;
                    //  Toast.makeText(Calculo.this, " %Grasa: "+pGRASA+" IMC: "+IMC, Toast.LENGTH_LONG).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Ingesta Diaria: " + String.format("%.4f", IngestaDiaria) + "\n" +
                            "TMB: " + String.format("%.4f", TMB)+"\n" +
                            "Porcentaje Grasa: "+String.format("%.4f", pGRASA)+"%\n" +
                            "IMC: "+String.format("%.4f", IMC)+"\n" +
                            "Masa Corporal Magra: "+String.format("%.4f",MasaCorporalMagra)+"\n" +
                            "Índice Cintura Altura: "+String.format("%.4f",CinturaAltura))
                            .setTitle("Datos")
                            .setCancelable(false)
                            .setNeutralButton("Aceptar",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                            Intent lanzar = new Intent(getBaseContext(), Menutab.class);
                                            startActivity(lanzar);
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

//                    String sIngestaDiaria,sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura;
//                    sIngestaDiaria=Double.toString(IngestaDiaria);
//                    sTMB=Double.toString(TMB);
//                    spGRASA=Double.toString(pGRASA);
//                    sIMC=Double.toString(IMC);
//                    sMasaCorporalMagra=Double.toString(MasaCorporalMagra);
//                    sCinturaAltura=Double.toString(CinturaAltura);
//
//                    helper.abrir();
//                    helper.insCalculo(sIngestaDiaria,
//                            sTMB,spGRASA,sIMC,sMasaCorporalMagra,sCinturaAltura,intUser);
//                    helper.close();
                }
            }else {

            }





}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_exit, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mExit:
                Intent inSecun = new Intent(this, Principal.class);
                startActivity(inSecun);
                ControlSesion.logOut(this);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
