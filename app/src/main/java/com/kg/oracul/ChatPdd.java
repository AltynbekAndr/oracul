package com.kg.oracul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatPdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_pdd);
        try{  /*<item>ПДД</item>
    <item>Коррупция</item>
    <item>Нарушение в общ.месте</item>
    <item>Насилие</item>
    <item>Прочее</item>*/
            BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("ПДД.txt"),"UTF-8"));
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(openFileInput("ПДД2.txt"),"UTF-8"));
            String s = bf.readLine();
            String s2 = bf2.readLine();
            TextView sub = (TextView)findViewById(R.id.textView45);
            TextView sub2 = (TextView)findViewById(R.id.textView46);
            sub.setText(s);
            sub2.setText(s2);
        }catch (IOException ex){}
    }
    public void addComm(View view){
        EditText edit = (EditText)findViewById(R.id.editText9);
        TextView sub = (TextView)findViewById(R.id.textView47);
        sub.setText(edit.getText().toString());
    }

}
