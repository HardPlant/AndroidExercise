package com.kiiren.onepagebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View v){
        this.sendHttpRequest();
    }
    public void sendHttpRequest(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    URL sendMessage = new URL( "http://www.naver.com");
                    HttpsURLConnection myConnection = (HttpsURLConnection) sendMessage.openConnection();

                    myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");

                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                    } else {
                        // Error handling code goes here
                    }
                }
                catch(MalformedURLException e){

                }
                catch(IOException e){

                }

            }
        });
    }
}
