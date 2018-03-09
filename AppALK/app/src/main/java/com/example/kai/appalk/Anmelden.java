package com.example.kai.appalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class Anmelden extends AppCompatActivity
{
    String val;
    boolean autologin_b;
    Switch autologin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        DatenbankManager dbm;
        Cursor res;

        dbm = new DatenbankManager(this);
        res = dbm.getSwitchValue();
        System.out.println(String.valueOf(res.getCount()));
        if (res.getCount() == 0)
        {
            System.out.println("schritt1");
            dbm.insertV();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_anmelden_gui);
            //getSupportActionBar().setTitle(R.string.login);
        }
        else
        {
            while (res.moveToNext())
            {
                val = res.getString(1);
            }

            if (Integer.parseInt(val) == 1)
            {
                super.onCreate(savedInstanceState);
                startActivity(new Intent(this, HomeScreen.class));
            }
            else
            {
                System.out.println("db eintrag ist 0");
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_anmelden_gui);
               // getSupportActionBar().setTitle(R.string.login);

                autologin = (Switch) findViewById(R.id.sw_angemeldetBleiben);
                autologin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
                    {
                        autologin_b = autologin.isChecked();
                        if (autologin_b)
                        {
                            System.out.println("auf true");
                            autologin_b = true;
                        }
                        else
                        {
                            System.out.println("auf false");
                            autologin_b = false;
                        }
                    }
                });

               /* autologin.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        autologin_b = autologin.isChecked();
                        if (autologin_b)
                        {
                            System.out.println("auf true");
                            autologin_b = true;
                        }
                        else
                        {
                            System.out.println("auf false");
                            autologin_b = false;
                        }
                    }
                });*/
            }
        }
    }

    //führt zur Registration, falls Button angeklickt wurde
    public void zurRegistration(View view)
    {
        startActivity(new Intent(this, Registrieren.class));
    }

    //Führt zum HomeScreen der App, von dem aus alles gesteuert werden kann
    public void zumHomeScreen(View view)
    {
        if (checkAnmeldung())
        {
            //hier switch wert in datenbank aktuallisieren
            DatenbankManager db = new DatenbankManager(this);
            if (autologin_b && Integer.parseInt(val) == 0)
            {
                db.updateAutoLogTrue();
            }
            else if (autologin_b && Integer.parseInt(val) == 1)
            {
                db.updateAutoLogFalse();
            }


            startActivity(new Intent(this, HomeScreen.class));
        }
    }

    //Checkt auf Richtigkeit der eingegebenden Daten
    public boolean checkAnmeldung()
    {
        boolean result = false;
        EditText usernameEditText = findViewById(R.id.et_username);
        String sUsername = usernameEditText.getText().toString();
        if (sUsername.matches(""))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.incorrectData)
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            //do things
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else
        {
            result = true;
        }
        return result;
    }
}
