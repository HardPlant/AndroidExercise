package com.kiiren.onepagebutton;

/**
 * Created by 120897 on 2017-08-07.
 */

public class EventRegistration {
    private CallbackEvent callbackEvent;

    public EventRegistration(CallbackEvent event){
        callbackEvent = event;
    }

    public void doWork(){
        callbackEvent.callbackMethod();
    }
}