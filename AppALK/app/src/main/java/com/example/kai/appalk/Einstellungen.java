package com.example.kai.appalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class Einstellungen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        try
        {
            getSupportActionBar().setTitle(R.string.einstellungen);
        }
        catch(NullPointerException n)
        {
            System.out.println("Nullpointer Exception");
        }
    }
}