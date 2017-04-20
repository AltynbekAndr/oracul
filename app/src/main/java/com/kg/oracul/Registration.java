package com.kg.oracul;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nbsp.materialfilepicker.utils.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import okio.Buffer;

public class Registration extends AppCompatActivity {
    EditText name,phonenumber;
    String sname,snumber;
    String pathToShrift = "fonts/calibril.ttf";
    Typeface typefacen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        typefacen = Typeface.createFromAsset(getAssets(), pathToShrift);
        TextView reg1 = (TextView) findViewById(R.id.textView21);
        TextView reg2 = (TextView) findViewById(R.id.textView22);
        reg1.setTypeface(typefacen);
        reg2.setTypeface(typefacen);
        name = (EditText) findViewById(R.id.editText3);
        phonenumber = (EditText) findViewById(R.id.editText4);
        try {
        BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("name.txt"),"UTF-8"));
        BufferedReader bf2 = new BufferedReader(new InputStreamReader(openFileInput("number.txt"),"UTF-8"));
         String s = bf.readLine();
         String s2 = bf2.readLine();
            if(s!=null&&s2!=null){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                bf.close();bf2.close();
                startActivity(intent);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void regisatration(View view){
        sname = name.getText().toString();
        snumber = phonenumber.getText().toString();
        if(sname!=null&&sname.length()>2){
          if(snumber!=null&&snumber.length()>=10){

              try {
                  BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(openFileOutput("name.txt",MODE_PRIVATE),"UTF-8"));
                  BufferedWriter bf2 = new BufferedWriter(new OutputStreamWriter(openFileOutput("number.txt",MODE_PRIVATE),"UTF-8"));
                  bf.write(name.getText().toString());
                  bf2.write(phonenumber.getText().toString());
                  bf.close();
                  bf2.close();
                  Log.d("LOG","файл записан");
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }


              Intent intent = new Intent(getApplicationContext(), MainActivity.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
              startActivity(intent);

           }else{
              Toast.makeText(getApplicationContext(),"Введен не корректный номер телефона",Toast.LENGTH_SHORT).show();
          }
        }else{
            Toast.makeText(getApplicationContext(),"Введено не корректное имя",Toast.LENGTH_SHORT).show();

        }

    }
}
