package com.example.kai.appalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Anmelden extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmelden_gui);
        getSupportActionBar().setTitle(R.string.login);
    }

    //führt zur Registration, falls Button angeklickt wurde
    public void zurRegistration (View view)
    {
        startActivity(new Intent(this, Registrieren.class));
    }

    //Führt zum HomeScreen der App, von dem aus alles gesteuert werden kann
    public void zumHomeScreen (View view)
    {
        if (checkAnmeldung())
        {
            startActivity(new Intent(this, HomeScreen.class));
        }
    }

    //Checkt auf Richtigkeit der eingegebenden Daten
    public boolean checkAnmeldung ()
    {
        boolean result = false;
        EditText usernameEditText = findViewById(R.id.et_username);
        String sUsername = usernameEditText.getText().toString();
        if (sUsername.matches(""))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.incorrectData)
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
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
