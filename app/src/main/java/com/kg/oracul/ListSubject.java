package com.kg.oracul;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListSubject extends AppCompatActivity {
    String pathToShrift = "fonts/calibril.ttf";
    Typeface typefacen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_subject);
        typefacen = Typeface.createFromAsset(getAssets(), pathToShrift);
        TextView txt = (TextView)findViewById(R.id.textView48);
       try{ BufferedReader bf2 = new BufferedReader(new InputStreamReader(openFileInput("ПДД.txt"),"UTF-8"));
        String s = bf2.readLine();
           txt.setTypeface(typefacen);
           txt.setText(s);
    }catch (IOException ex){}
    }
    public void tema(View view){
        Intent in = new Intent(getApplicationContext(),ChatPdd.class);
        startActivity(in);
    }
}
