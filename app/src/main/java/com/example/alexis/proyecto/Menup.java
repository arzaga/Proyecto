package com.example.alexis.proyecto;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.alexis.proyecto.ControlSesion.ControlSesion;

public class Menup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menup);

        Resources res = getResources();

        final TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);

        spec.setIndicator("",
                res.getDrawable(R.mipmap.ic_launcher));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("",
                res.getDrawable(R.mipmap.ic_atleta));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("",
                res.getDrawable(R.mipmap.ic_salud));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("",
                res.getDrawable(R.mipmap.ic_gymbrowser));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);


        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {


                 // display the name of the tab whenever a tab is changed
                 Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();

               }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mNuevoPlan:
                Intent lanzar = new Intent(getBaseContext(), Calculo.class);
                startActivity(lanzar);

                break;
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
