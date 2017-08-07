package com.kiiren.onepagebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View v){
        Requester requester = new Requester("https://api.github.com/");
        CallbackEvent callbackEvent = new CallbackEvent(){
                @Override
                public void callbackMethod() {
                }
        };
        requester.sendHttpRequest("organization_url", new EventRegistration(callbackEvent));
    }

}
