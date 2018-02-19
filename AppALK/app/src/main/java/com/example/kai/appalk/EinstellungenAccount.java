package com.example.kai.appalk;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EinstellungenAccount extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen_account);
    }

    public void abmelden(View view)
    {
        DatenbankManager dbm =new DatenbankManager(this);
        String input = "";
        Cursor res = dbm.getSwitchValue();
        while (res.moveToNext()) {
            input = res.getString(1);
        }
        if(input.equals("1")) {

            dbm.updateAutoLogFalse();
        }
        startActivity(new Intent(this, Anmelden.class));
    }
}
