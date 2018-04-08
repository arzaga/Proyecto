package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alexis on 19/03/2017..
 */
//S
public class SQLite_OpenHelper extends SQLiteOpenHelper{

    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table usuarios(_ID integer primary key autoincrement, " +
                "Nombre text, " +
                "Apellidos text, " +
                "Email text, " +
                "Password text);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void abrir(){
        //Metodo para ABRIR BDD
        this.getReadableDatabase();
    }

    public void cerrar(){
        //Metodo para CERRAR BDD
        this.close();

    }

    public void insRegUs(String nom, String apell,String email,String pass){
        //Método que permite insertar registros  en la tabla Usuario

        ContentValues valores= new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Apellidos",apell);
        valores.put("Email",email);
        valores.put("Password",pass);
        this.getWritableDatabase().insert("usuarios", null, valores);
    }
//    public void insCalculo(String dbIngestaDiaria, String dbTMB,String dbpGRASA,String dbIMC,String dbMasaCorporalMagra,String dbCinturaAltura, String db_IDTabUsu){
//        //Método que permite insertar registros  en la tabla Usuario
//
//        ContentValues valores= new ContentValues();
//        valores.put("IngestaDiaria",dbIngestaDiaria);
//        valores.put("TMB",dbTMB);
//        valores.put("pGRASA",dbpGRASA);
//        valores.put("IMC",dbIMC);
//        valores.put("MasaCorporalMagra",dbMasaCorporalMagra);
//        valores.put("CinturaAltura",dbCinturaAltura);
//        valores.put("_IDTabUsu",db_IDTabUsu);
//        this.getWritableDatabase().insert("calculo", null, valores);
//
//
//
//    }
    public Cursor ConsultarUsuPas(String usu, String pas){
    Cursor mCursor=null;
        mCursor=this.getReadableDatabase().query("usuarios", new String[]{"_ID",
                "Nombre","Apellido","Email","Password"},"Correo like '"+usu+"'" +
                "and Password like '"+pas+'"', null,null,null,null);

    return mCursor;

    }
//    public Cursor ConsultarCalculo(String db_IDTabUsu, String pas){
//        Cursor mCursor=null;
//        mCursor=this.getReadableDatabase().query("usuarios", new String[]{"_ID",
//                "Nombre","Apellido","Email","Password"},"Correo like '"+db_IDTabUsu+"'" +
//                "and Password like '"+pas+'"', null,null,null,null);
//
//        return mCursor;
//
//    }


}
