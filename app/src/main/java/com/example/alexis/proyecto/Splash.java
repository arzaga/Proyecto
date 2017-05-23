package com.example.alexis.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent splash = new Intent(getApplicationContext(),Principal.class);
               startActivity(splash);
               finish();
           }
       },
       3000);
    }
}
