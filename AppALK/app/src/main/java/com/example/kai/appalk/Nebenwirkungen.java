package com.example.kai.appalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Daniel on 31.01.2018.
 */

public class Nebenwirkungen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nebenwirkungen);
    }

    public void nwZuNwf(View view)
    {
        startActivity(new Intent(this, NebenwirkungenFormular.class));
    }
}