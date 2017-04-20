package com.kg.oracul;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyVideos extends AppCompatActivity {
    String pathToShrift = "fonts/calibril.ttf";
    Typeface typefacen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_videos);
        String s=null,s2=null;
        typefacen = Typeface.createFromAsset(getAssets(), pathToShrift);
        TextView category = (TextView) findViewById(R.id.textView24);
        TextView category2 = (TextView) findViewById(R.id.textView26);
        category.setTypeface(typefacen);
        category2.setTypeface(typefacen);
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("file.txt"),"UTF-8"));
            s = bf.readLine();
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(openFileInput("time.txt"),"UTF-8"));
            s2 = bf2.readLine();
            TextView txt = (TextView) findViewById(R.id.textView25);
            txt.setText(s);
            TextView txt2 = (TextView) findViewById(R.id.textView27);
            txt2.setText(s2);

            bf.close();
            bf2.close();
        }catch (IOException ex){}
     Button b = (Button) findViewById(R.id.buttonbb);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyVideos.this);
                builder.setTitle("Собщение");
                builder.setMessage("Список пуст");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.icon_dont_send);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(getApplicationContext(), "ля ля ля", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
