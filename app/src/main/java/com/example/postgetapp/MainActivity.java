package com.example.postgetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.postgetapp.connectInternet.DownloadJSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView getData, postData;
    static String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q=hanoi&appid=5dbe8ff588869c7d2cad6de077f5fcc6&fbclid=IwAR3UZRNfZrZVYfFKbVpsQuODlZoZMmfCVD94zHILLQEBuJeesCZ3zwR8ueE";
    static String POST_URL = "https://jsonplaceholder.typicode.com/posts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addEvent();
    }

    private void addControl() {
        getData = findViewById(R.id.getData);
        postData = findViewById(R.id.postData);
    }

    private void addEvent() {
        doGet();
        doPost();
    }

    private void doGet() {
        DownloadJSON downloadJSON = new DownloadJSON(GET_URL);
        downloadJSON.execute();
        try {
            String datajson = downloadJSON.get();
            Log.d("data get", datajson);
            getData.setText(datajson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doPost() {
        List<HashMap<String, Object>> atttr = new ArrayList<>();
        HashMap<String, Object> body = new HashMap<>();
        body.put("userId", 123);
        body.put("title", "dấdad");
        body.put("body", "ơueiuqwe");
        atttr.add(body);
        DownloadJSON downloadJSON = new DownloadJSON(POST_URL, atttr);
        downloadJSON.execute();
        try {
            String datajson = downloadJSON.get();
            Log.d("data get", datajson);
            postData.setText(datajson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}