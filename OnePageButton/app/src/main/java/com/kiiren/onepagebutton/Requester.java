package com.kiiren.onepagebutton;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by 120897 on 2017-08-07.
 */

public class Requester {
    public void sendHttpRequest(){
        /*https://code.tutsplus.com/ko/tutorials/android-from-scratch-using-rest-apis--cms-27117*/
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    /*HTTP 연결 생성*/
                    URL sendMessage = new URL( "https://api.github.com/");
                    HttpsURLConnection myConnection = (HttpsURLConnection) sendMessage.openConnection();
                    /*요청 헤더 추가*/
                    myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");
                    /*응답 읽기*/
                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                        /*응답에서 키 값 추출하기 (여기서는 organization_url*/
                        jsonReader.beginObject(); // Start processing the JSON object
                        while (jsonReader.hasNext()) { // Loop through all keys
                            String key = jsonReader.nextName(); // Fetch the next key
                            if (key.equals("organization_url")) { // Check if desired key
                                // Fetch the value as a String
                                String value = jsonReader.nextString();

                                // Do something with the value
                                // ...

                                break; // Break out of the loop
                            } else {
                                jsonReader.skipValue(); // Skip values of other keys
                            }
                        }
                        /*리소스 해제, 연결 종료*/
                        jsonReader.close();
                        myConnection.disconnect();
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
