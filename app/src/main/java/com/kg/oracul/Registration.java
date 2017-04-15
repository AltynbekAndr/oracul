package com.kg.oracul;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nbsp.materialfilepicker.utils.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okio.Buffer;

public class Registration extends AppCompatActivity {
    EditText name,phonenumber;
    String sname,snumber;
 /*   InputStream in,in2;
    BufferedReader bf,bf2;
    String s,s2;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = (EditText) findViewById(R.id.editText3);
        phonenumber = (EditText) findViewById(R.id.editText4);
     /*   File f2 = new File("file:///android_asset/login.txt");
        File f3 = new File("file///android_asset/number.txt");
        try {
             in = new FileInputStream(f2);
             InputStreamReader inr = new InputStreamReader(in);
             bf = new BufferedReader(inr);
             in2 = new FileInputStream(f3);
             InputStreamReader inr2 = new InputStreamReader(in);
             bf2 = new BufferedReader(inr2);
             s = bf.readLine();
            s2 = bf2.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(s!=null&&s2!=null&&s.length()>2&&s2.length()>=10){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }*/


    }

    public void regisatration(View view){
        sname = name.getText().toString();
        snumber = phonenumber.getText().toString();
        if(sname!=null&&sname.length()>2){
          if(snumber!=null&&snumber.length()>=10){

              File f2 = new File("file:///android_asset/login.txt");
              File f3 = new File("file///android_asset/number.txt");
              try {
                 FileWriter fw = new FileWriter(f2, false);
                 fw.write(sname);
                 FileWriter fw2 = new FileWriter(f3, false);
                 fw2.write(snumber);
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
