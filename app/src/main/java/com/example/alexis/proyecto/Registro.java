package com.example.alexis.proyecto;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {
    Button btnGrabUsu;
    EditText txtNomUsu,txtApellidosUsu,txtEmailUsu,txtPassUsu,txtPassConfirm;
    //Crea BDD
    SQLite_OpenHelper helper= new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnGrabUsu= (Button)findViewById(R.id.btnRegistrarUsu);
        txtNomUsu = (EditText) findViewById(R.id.txtNomUsu);
        txtApellidosUsu = (EditText) findViewById(R.id.txtApellidos);
        txtEmailUsu = (EditText) findViewById(R.id.txtCorUsu);
        txtPassUsu = (EditText) findViewById(R.id.txtPassUsu);
        txtPassConfirm = (EditText) findViewById(R.id.txtPassConfirm);



    }

    public void onClickR (View view){
        String pass1,pass2;
        String nomUsu,apellUsu,emailUsu;

        pass1 = txtPassUsu.getText().toString();
        pass2 = txtPassConfirm.getText().toString();
        nomUsu = txtNomUsu.getText().toString();
        apellUsu = txtApellidosUsu.getText().toString();
        emailUsu = txtPassConfirm.getText().toString();
if(pass1.isEmpty()||pass2.isEmpty()||nomUsu.isEmpty()||apellUsu.isEmpty()||emailUsu.isEmpty()){
    Toast.makeText(getApplicationContext(),"Empty Fields",Toast.LENGTH_LONG).show();
}else if(!pass1.equals(pass2)){
            Toast.makeText(getApplicationContext(),"Password aren't the Same, try Again",Toast.LENGTH_LONG).show();
            txtPassConfirm.setText("");
            txtPassUsu.setText("");
        }else {
            helper.abrir();
            helper.insRegUs(String.valueOf(txtNomUsu.getText()),
                    String.valueOf(txtApellidosUsu.getText()),
                    String.valueOf(txtEmailUsu.getText()),
                    String.valueOf(txtPassUsu.getText()));
            helper.close();

            Intent intentReg = new Intent(getApplicationContext(), Principal.class);
            startActivity(intentReg);
            Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
