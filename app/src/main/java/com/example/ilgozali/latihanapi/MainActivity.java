package com.example.ilgozali.latihanapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //di gunakan sebagai root basenya saja
    public static final String ROOT_URL = "http://192.168.100.106/tablecostummer/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
