package com.dicoding.tanamanku;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_about);
        setTitle("About");
    }
}
