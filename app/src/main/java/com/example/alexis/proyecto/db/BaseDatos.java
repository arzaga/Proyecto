package com.example.alexis.proyecto.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.alexis.proyecto.model.Dieta;

import java.util.ArrayList;

/**
 * Created by Alexis on 19/03/2017.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_CONTACTS + "(" +
                ConstantesBaseDatos.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY, " +
                ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTS_EMAIL + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTS_FOTO + " INTEGER" +
                ")";


        db.execSQL(queryCrearTablaContacto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_CONTACTS);
           onCreate(db);
    }

    public ArrayList<Dieta> obtenerTodosLasDietas() {
        ArrayList<Dieta> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Dieta contactoActual = new Dieta();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            contactos.add(contactoActual);

        }

        db.close();

        return contactos;
    }

    public void insertarDieta(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS,null, contentValues);
        db.close();
    }



}