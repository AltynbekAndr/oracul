package com.kg.oracul;

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

public class CreateNewSubject extends AppCompatActivity {
    Spinner spinner;Typeface typefacen;
    String pathToShrift = "fonts/calibril.ttf";
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
