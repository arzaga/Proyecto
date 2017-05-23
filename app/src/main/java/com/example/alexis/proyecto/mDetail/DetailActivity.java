package com.example.alexis.proyecto.mDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexis.proyecto.R;


public class DetailActivity extends AppCompatActivity {

    TextView nameTxt, txtSeries;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //INITIALIZE VIEWS
        nameTxt= (TextView) findViewById(R.id.nameTxtDetail);
        txtSeries= (TextView) findViewById(R.id.nameTxtDetail);
        img= (ImageView) findViewById(R.id.spacecraftImageDetail);

        //RECEIVE DATA
        Intent i=this.getIntent();
        String name=i.getExtras().getString("NAME_KEY");
        int image=i.getExtras().getInt("IMAGE_KEY");

        //BIND DATA
        nameTxt.setText(name);
        txtSeries.setText(name);
        img.setImageResource(image);
    }

}