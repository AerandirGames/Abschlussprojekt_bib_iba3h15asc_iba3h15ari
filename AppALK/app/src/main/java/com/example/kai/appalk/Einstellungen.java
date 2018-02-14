package com.example.kai.appalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Einstellungen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

    }

    public void zuEinstellungenNetzwerk (View view)
    {
        startActivity(new Intent(this, EinstellungenNetzwerk.class));
    }

    public void zuEinstellungenAccount (View view)
    {
        startActivity(new Intent(this, EinstellungenAccount.class));
    }

    public void zuEinstellungenImpressum (View view)
    {
        startActivity(new Intent(this, EinstellungenImpressum.class));
    }
}
