package com.example.alexis.proyecto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexis.proyecto.ControlSesion.ControlSesion;
import com.example.alexis.proyecto.fragment.RecyclerViewFragment;

import OpenHelper.SQLite_OpenHelper;

public class Principal extends AppCompatActivity {
    Intent inSecun;
    EditText edtPassword,edtUsuario;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtPassword = (EditText) findViewById(R.id.txtPassword);
        edtUsuario = (EditText) findViewById(R.id.txtUsuario);

        if(ControlSesion.isLogin(this)){
            starMenu();
        }

    }
    public void starMenu(){
        inSecun = new Intent(this, Calculo.class);
        startActivity(inSecun);
        finish();
    }

    public void onClickSign(View view){
                //CREAR EL INTENTO
                inSecun = new Intent(this, Registro.class);
                startActivity(inSecun);
    }
    public void onClickLogin(View view){
        String pass,user;
        pass=edtPassword.getText().toString();
                user=edtUsuario.getText().toString();
        if(pass.isEmpty()||user.isEmpty()){
            Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();
        }else{

            SQLite_OpenHelper admin=new SQLite_OpenHelper(this,"BD1",null,1);
            SQLiteDatabase db=admin.getWritableDatabase();
            String usuario=edtUsuario.getText().toString();
            String contrasena=edtPassword.getText().toString();
            fila=db.rawQuery("select Email,Password from usuarios where Email='"+usuario+"' and Password='"+contrasena+"'",null);
            //preguntamos si el cursor tiene algun valor almacenado
            if(fila.moveToFirst()==true){
                //capturamos los valores del cursos y lo almacenamos en variable
                String usua=fila.getString(0);
                String passw=fila.getString(1);

                //preguntamos si los datos ingresados son iguales
                if (usuario.equals(usua)&&contrasena.equals(pass)) {

                    ControlSesion.logIn(this);
                    //si son iguales entonces vamos a otra ventana
                    //Menu es una nueva actividad empty
                    inSecun = new Intent(this, Calculo.class);
                    inSecun.putExtra("intUser",edtUsuario.getText().toString());
                    startActivity(inSecun);
                //Envía los datos el fragment de Dietas
                    Bundle bundle = new Bundle();
                    bundle.putString("UsuarioIniciado", usuario);
                    // set Fragmentclass Arguments
                    RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
                    recyclerViewFragment.setArguments(bundle);

                    finish();
                    //limpiamos las las cajas de texto
                    edtUsuario.setText("");
                    edtPassword.setText("");

                }
            }else{
                Toast.makeText(getBaseContext(),"User not Existent or Wrong User and Pass ",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
