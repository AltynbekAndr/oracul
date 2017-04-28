package com.kg.oracul;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private static final int SELECT_VIDEO = 5;
    private static final int SELECT_IMAGE = 9;
    File file;
    ProgressDialog progressDialog;
    Spinner spinner;
    String pathToShrift = "fonts/calibril.ttf";
    Typeface  typefacen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typefacen = Typeface.createFromAsset(getAssets(), pathToShrift);

        progressDialog = new ProgressDialog(MainActivity.this);
        LinearLayout main1 = (LinearLayout)findViewById(R.id.mainlinear1);
        LinearLayout main2 = (LinearLayout)findViewById(R.id.mainlinear2);
        main1.setVisibility(main1.GONE);
        main2.setVisibility(main2.VISIBLE);
       WebView wv = (WebView)findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("http://www.youtube.com");
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });



    }



    public void main(View view){
     setContentView(R.layout.activity_main);
      LinearLayout main1 = (LinearLayout)findViewById(R.id.mainlinear1);
      LinearLayout main2 = (LinearLayout)findViewById(R.id.mainlinear2);
      main1.setVisibility(main1.GONE);
      main2.setVisibility(main2.VISIBLE);

    }
    public void addVideoIntent(View view){
        setContentView(R.layout.activity_add_video);
        LinearLayout main1 = (LinearLayout)findViewById(R.id.addlinear1);
        LinearLayout main2 = (LinearLayout)findViewById(R.id.addlinear2);
        main1.setVisibility(main1.GONE);
        main2.setVisibility(main2.VISIBLE);
        TextView category = (TextView) findViewById(R.id.textView9);
        category.setTypeface(typefacen);

        spinner = (Spinner) findViewById(R.id.spinner);
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
    public void categories(View view){
        setContentView(R.layout.activity_categori);
        LinearLayout main1 = (LinearLayout)findViewById(R.id.categoriilinear1);
        LinearLayout main2 = (LinearLayout)findViewById(R.id.categoriilinear2);
        main1.setVisibility(main1.GONE);
        main2.setVisibility(main2.VISIBLE);
        TextView pdd = (TextView) findViewById(R.id.textView13);
        TextView corupciya = (TextView) findViewById(R.id.textView14);
        TextView nasilie = (TextView) findViewById(R.id.textView15);
        TextView narushenie = (TextView) findViewById(R.id.textView16);
        TextView other = (TextView) findViewById(R.id.textView17);
        TextView mylastvideo = (TextView) findViewById(R.id.textView23);

        pdd.setTypeface(typefacen);
        corupciya.setTypeface(typefacen);
        nasilie.setTypeface(typefacen);
        narushenie.setTypeface(typefacen);
        other.setTypeface(typefacen);
        mylastvideo.setTypeface(typefacen);
    }
    public void chats(View view){
        setContentView(R.layout.activity_chats);
        LinearLayout main1 = (LinearLayout)findViewById(R.id.chatlinear1);
        LinearLayout main2 = (LinearLayout)findViewById(R.id.chatlinear2);
        main1.setVisibility(main1.GONE);
        main2.setVisibility(main2.VISIBLE);

        TextView pdd = (TextView) findViewById(R.id.textView31);
        TextView corupciya = (TextView) findViewById(R.id.textView32);
        TextView nasilie = (TextView) findViewById(R.id.textView33);
        TextView narushenie = (TextView) findViewById(R.id.textView34);
        TextView other = (TextView) findViewById(R.id.textView35);
        TextView mylastvideo = (TextView) findViewById(R.id.textView36);
        TextView createtxt = (TextView) findViewById(R.id.textView37);

        pdd.setTypeface(typefacen);
        corupciya.setTypeface(typefacen);
        nasilie.setTypeface(typefacen);
        narushenie.setTypeface(typefacen);
        other.setTypeface(typefacen);
        mylastvideo.setTypeface(typefacen);
        createtxt.setTypeface(typefacen);
    }
    public void profile(View view){
        setContentView(R.layout.activity_setttings);
        LinearLayout main1 = (LinearLayout)findViewById(R.id.profilelinear1);
        LinearLayout main2 = (LinearLayout)findViewById(R.id.profilelinear2);
        main1.setVisibility(main1.GONE);
        main2.setVisibility(main2.VISIBLE);
        EditText ename = (EditText) findViewById(R.id.editText5);
        EditText enumber = (EditText) findViewById(R.id.editText6);
       try {
           BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("name.txt"), "UTF-8"));
           BufferedReader bf2 = new BufferedReader(new InputStreamReader(openFileInput("number.txt"), "UTF-8"));
           String s = bf.readLine();
           String s2 = bf2.readLine();
           bf.close();
           bf2.close();
           ename.setText(s);
           enumber.setText(s2);
       }catch(IOException ex){}
       }
    public void addPhoto(View view){
        Intent pickPhoto = new Intent(Intent.ACTION_PICK);
        pickPhoto.setType("image/*");
        startActivityForResult(pickPhoto, SELECT_IMAGE);

    }
    public void myvideos(View view){
    Intent intent = new Intent(getApplicationContext(),MyVideos.class);
        startActivity(intent);

    }
    public void editprofile(View view){
        EditText name = (EditText) findViewById(R.id.editText5);
        EditText phonenumber = (EditText) findViewById(R.id.editText6);
        try{
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(openFileOutput("name.txt", MODE_PRIVATE),"UTF-8"));
            BufferedWriter bf2 = new BufferedWriter(new OutputStreamWriter(openFileOutput("number.txt",MODE_PRIVATE),"UTF-8"));
            bf.write(name.getText().toString());
            bf2.write(phonenumber.getText().toString());
            bf.close();
            bf2.close();
            Toast.makeText(getApplicationContext(),"сохранено",Toast.LENGTH_SHORT).show();
        }catch (IOException ex){}
    }
    public void web1(View view){

      Intent intent = new Intent(getApplicationContext(),Pdd.class);
        startActivity(intent);
    }
    public void web2(View view){

        Intent intent = new Intent(getApplicationContext(),Corrupciya.class);
        startActivity(intent);
    }
    public void web3(View view){

        Intent intent = new Intent(getApplicationContext(),Nasilie.class);
        startActivity(intent);
    }
    public void createSubject(View view){
        Intent intent = new Intent(getApplicationContext(),CreateNewSubject.class);
        startActivity(intent);
    }
    public void pddintent(View viwe){
        Intent in = new Intent(getApplicationContext(),ListSubject.class);
        startActivity(in);


    }

    public void selectVideo(View view){
         Intent intent = new Intent();
         intent.setType("video*//*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(Intent.createChooser(intent, "Выбрать видео"), SELECT_VIDEO);
     }
    public String getMimeType(String path){
        String extension = MimeTypeMap.getFileExtensionFromUrl(path);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
    }
    public void upload2(View view){
        if(file!=null&&file.getName()!=null){
            EditText description = (EditText) findViewById(R.id.editText);
            EditText map = (EditText) findViewById(R.id.editText2);
            try {
                BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(openFileOutput("description.txt", MODE_PRIVATE), "UTF-8"));
                BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(openFileOutput("map.txt", MODE_PRIVATE), "UTF-8"));
                buf.write(description.getText().toString());
                buf2.write(map.getText().toString());
                buf.close();
                buf2.close();

            }catch(IOException ex){}
            new MyAsync().execute();

        }
        Toast.makeText(getApplicationContext(), "Выберите видео для загрузки", Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {

            if (requestCode == SELECT_VIDEO) {
                Drawable dr = getResources().getDrawable(R.drawable.video_icon2);
                ImageView imageView =(ImageView) findViewById(R.id.imageView);
                imageView.setImageDrawable(dr);
                Uri u = data.getData();
                file = new File(u.getPath());
                TextView textView = (TextView) findViewById(R.id.textView8);
                textView.setText(file.getName());
               try {
                   BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(openFileOutput("namefile.txt", MODE_PRIVATE), "UTF-8"));
                   buf.write(u.getPath());
                   buf.close();

               }catch(IOException ex){}
               try {
                   BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(openFileOutput("time.txt", MODE_PRIVATE), "UTF-8"));
                   BufferedWriter bf2 = new BufferedWriter(new OutputStreamWriter(openFileOutput("file.txt", MODE_PRIVATE), "UTF-8"));
                   bf.write(Calendar.getInstance().getTime().toString());
                   bf2.write(file.getName());
                   bf.close();
                   bf2.close();
               }catch(IOException ex){}
            }else if(requestCode == SELECT_IMAGE){
                ImageButton imgb = (ImageButton) findViewById(R.id.moiimageButton);
                imgb.setVisibility(imgb.GONE);
                ImageView imgv = (ImageView) findViewById(R.id.imageView6);
                imgv.setVisibility(imgv.VISIBLE);
                Uri uri = data.getData();
                try{
                    InputStream input = getContentResolver().openInputStream(uri);
                    Bitmap bitmap = BitmapFactory.decodeStream(input);
                    imgv.setImageBitmap(bitmap);
            }catch(IOException ex){}
            }
        }
    }


    class MyAsync extends AsyncTask<Void,Integer,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setTitle("Отправка");
            progressDialog.setMessage("ждите");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            String content_type = getMimeType(file.getPath());
            OkHttpClient client = new OkHttpClient();
            RequestBody fileBody  = RequestBody.create(MediaType.parse(content_type),file);
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("type",content_type)
                    .addFormDataPart("uploaded_file",file.getName().toString(),fileBody)
                    .build();

            Request request =  new Request.Builder()
                    .url("http://env-2247367.jelastic.regruhosting.ru/talasagro.com/filee")
                    .post(requestBody)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                if(!response.isSuccessful()){
                    throw new IOException("Error :"+response);
                }
            }catch(IOException ex){}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.cancel();
        }
    }
}