package com.anynone.moveon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import android.os.AsyncTask;
import android.view.View;


import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    String TAG="";
    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Ouvrir().execute();
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Fermer().execute();
            }
        });


    }

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    private class Ouvrir extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Log.i(TAG, "doInBackground: "+run("http://192.168.1.10:8080/up"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
    private class Fermer extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Log.i(TAG, "doInBackground: "+run("http://192.168.1.10:8080/down"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

}