package com.kg.oracul;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class AddVideo extends AppCompatActivity {
   Spinner spinner;
   Button b;
   private static final int SELECT_VIDEO = 5;
    ImageView imageView;
    TextView textView;
    File file;
   ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video);

        progressDialog = new ProgressDialog(AddVideo.this);

        b = (Button) findViewById(R.id.button2);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView8);
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

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("video*//*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Выбрать видео"), SELECT_VIDEO);
        /* */
            }
        });


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {

            if (requestCode == SELECT_VIDEO) {
                Drawable dr = getResources().getDrawable(R.drawable.video_icon2);
                imageView.setImageDrawable(dr);
                Uri u = data.getData();
                textView.setText(u.getPath());
                file = new File(u.getPath());

                }

            }
        }



/*  public void upload() throws IOException
    {"http://env-2247367.jelastic.regruhosting.ru/talasagro.com/filee";


    }*/
 public String getMimeType(String path){
     String extension = MimeTypeMap.getFileExtensionFromUrl(path);
     return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
 }
 public void upload2(View view){

     new MyAsync().execute();

    }

class MyAsync extends AsyncTask<Void,Integer,Void>{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setTitle("zagruzka");
        progressDialog.setMessage("jdite");
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







