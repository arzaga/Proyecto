package com.example.alexis.proyecto.model;

import android.content.ContentValues;
import android.content.Context;


import com.example.alexis.proyecto.R;
import com.example.alexis.proyecto.db.BaseDatos;
import com.example.alexis.proyecto.db.ConstantesBaseDatos;

import java.util.ArrayList;


/**
 * Created by anahisalgado on 21/04/16.
 */
public class ConstructorDietas{


    private Context context;
    public ConstructorDietas(Context context) {
        this.context = context;
    }

    public ArrayList<Dieta> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
//        insertarTresDietas(db);
        return  db.obtenerTodosLasDietas();
    }



//    public void insertarTresDietas(BaseDatos db){
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_ID, "1");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Comida 1");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,
//                "\n• 1 vaso de leche descremada con una taza de corn flakes.\n"+
//                "• 1(1/2) taza de frijoles cocidos.\n" +
//                "• 3 porciones de pan integral.\n" +
//                "• 1 fruta (pera, manzana o naranja).\n" +
//                "• Agua.");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "anahi@gmail.com");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.atleta);
//
//        db.insertarDieta(contentValues);
//
//
//        contentValues = new ContentValues();
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_ID, "2");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Comida 2");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "• Un vaso de leche descremada con seis cucharadas de avena.");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "pedro@gmail.com");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.milk);
//
//        db.insertarDieta(contentValues);
//
//        contentValues = new ContentValues();
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_ID, "3");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Comida 3");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,
//                "• 1 pechuga de pollo asada o a la plancha\n" +
//                "• 1 taza de arroz cocido\n" +
//                "• 4 porciones de pan integral ó 4 tortillas de maíz\n" +
//                "• Ensalada fresca al gusto\n" +
//                "• 1 fruta (manzana, pera o naranja)\n" +
//                "• Agua a libre demanda");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "mireya@gmail.com");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rice);
//
//        db.insertarDieta(contentValues);
//
//        contentValues = new ContentValues();
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_ID, "4");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Comida 4");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,
//                "• Un vaso de leche descremada con seis cucharadas de avena");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "mireya@gmail.com");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.milk);
//
//        db.insertarDieta(contentValues);
//
//        contentValues = new ContentValues();
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_ID, "5");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Comida 5");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,
//                "• 11/4 taza de atún en agua\n" +
//                        "• 3 porciones de pan integral\n" +
//                        "• 2 tazas de espinaca cocida\n" +
//                        "• 1 plátano (macho) cocido\n" +
//                        "• Agua a libre demanda");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "mireya@gmail.com");
//        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.groceries);
//
//        db.insertarDieta(contentValues);
//
//
//
//    }




}
