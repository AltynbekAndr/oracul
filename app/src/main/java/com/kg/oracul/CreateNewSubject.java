package com.kg.oracul;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CreateNewSubject extends AppCompatActivity {
    Spinner spinner;Typeface typefacen;
    String pathToShrift = "fonts/calibril.ttf";
    String cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_subject);
        spinner = (Spinner) findViewById(R.id.spinner2);
        typefacen = Typeface.createFromAsset(getAssets(), pathToShrift);
        EditText e7 = (EditText) findViewById(R.id.editText7);
        EditText e8 = (EditText) findViewById(R.id.editText8);
        TextView txt38 = (TextView) findViewById(R.id.textView38);
        TextView txt39 = (TextView) findViewById(R.id.textView39);

        txt38.setTypeface(typefacen);
        txt39.setTypeface(typefacen);
        e7.setTypeface(typefacen);
        e8.setTypeface(typefacen);

        ArrayAdapter<?> arrayAdapterM = ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_item);
        arrayAdapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapterM);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] array = getResources().getStringArray(R.array.category);
                Toast.makeText(getApplicationContext(), "" + array[i], Toast.LENGTH_SHORT).show();
                cat = array[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void createSub(View viwe){
        try{
            BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(openFileOutput(cat+".txt", MODE_PRIVATE), "UTF-8"));
            BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(openFileOutput(cat+"2.txt", MODE_PRIVATE), "UTF-8"));
            EditText sub = (EditText) findViewById(R.id.editText7);
            EditText desc = (EditText) findViewById(R.id.editText8);
            String subtxt = sub.getText().toString();
            String desctxt = desc.getText().toString();

            buf.write(subtxt);
            buf2.write(desctxt);
            buf.close();
            buf2.close();


        }catch (IOException ex){}


    }



}
