package com.example.android.remote;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Ahalya on 6/23/2016.
 */
public class Remote extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote);

        Button togg=(Button)findViewById(R.id.BtnToggle);

        togg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    new AsyncTask<Void,Void,Void>(){
                        @Override
                        protected Void doInBackground(Void... params) {
                            try {
                                HttpClient client = new DefaultHttpClient();
                                URI website = new URI("http://192.168.1.7/?pin=10");
                                HttpGet request = new HttpGet();
                                request.setURI(website);
                                client.execute(request);
                            }catch(Exception e){
                                    Log.e("sss","sss",e);
                                }
                            return null;
                        }
                    }.execute();

                }


        });
    }
}
