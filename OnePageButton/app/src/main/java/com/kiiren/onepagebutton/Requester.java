package com.kiiren.onepagebutton;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by 120897 on 2017-08-07.
 */

public class Requester {
    private String dest;
    private HttpsURLConnection myConnection = null;
    private JsonReader jsonReader = null;

    Requester(String URL){
        this.dest = URL;
    }
    private boolean Connect(){
        try{/*HTTP 연결 생성*/
            URL sendMessage = new URL(dest);
            myConnection = (HttpsURLConnection) sendMessage.openConnection();
        }
        catch(MalformedURLException e){
        }
        catch(IOException e){
        }
        return true;
    }
    private void getResponse(){
        if(myConnection == null) return;
        /*응답 읽기*/
        try {
            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader =
                        new InputStreamReader(responseBody, "UTF-8");
                JsonReader jsonReader = new JsonReader(responseBodyReader);
            }
        }
        catch(IOException e){
        }
    }
    private boolean extract(String desiredKey, EventRegistration callback){
        if(jsonReader == null) return false;
        boolean isSuccessed = false;
        try {
            /*응답에서 키 값 추출하기 (여기서는 organization_url*/
            jsonReader.beginObject(); // Start processing the JSON object
            while (jsonReader.hasNext()) { // Loop through all keys
                String key = jsonReader.nextName(); // Fetch the next key
                if (key.equals(desiredKey)) { // Check if desired key
                    // Fetch the value as a String
                    String value = jsonReader.nextString();
                    callback.doWork();

                    // Do something with the value
                    // ...
                    return isSuccessed;
                } else {
                    jsonReader.skipValue(); // Skip values of other keys
                }
            }
        }
        catch(IOException e){
        }
        return isSuccessed;
    }
    public boolean sendHttpRequest(final String desiredKey, final EventRegistration callback){
        if(myConnection == null) return false;
        /*https://code.tutsplus.com/ko/tutorials/android-from-scratch-using-rest-apis--cms-27117*/
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    Connect();
                    /*요청 헤더 추가*/
                    myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");
                    getResponse();
                    extract(desiredKey, callback);
                    jsonReader.close();
                    myConnection.disconnect();
                        /*리소스 해제, 연결 종료*/
                    }
                catch(IOException e) {
                }
            }
        });
        return true;
    }
    private boolean setRequestMethod(String method){
        if(myConnection == null) return false;
        try {
            myConnection.setRequestMethod(method);
        }
        catch (ProtocolException e){
        }
        return true;
    }
}
