package com.kg.oracul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void addVideoIntent(View view){
        Intent intent = new Intent(getApplicationContext(), AddVideo.class);
         startActivity(intent);
    }









}