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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Anmelden extends AppCompatActivity
{
    private String val, sUsername, sPw;
    private boolean autologin_b;
    private Switch autologin;
    private RequestQueue requestQueue;
    private String showUserUrl = "http://192.168.1.34/android_connect/showUser.php";
    private EditText usernameEditText, pwEditText;
    private UserDatenbankManager userDBM;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        DatenbankManager dbm;
        Cursor res;

        dbm = new DatenbankManager(this);
        userDBM = new UserDatenbankManager(this);
        res = dbm.getSwitchValue();
        requestQueue = Volley.newRequestQueue(this.getApplicationContext());
        if (res.getCount() == 0)
        {
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
                startActivity(new Intent(this, Messenger.class));
            }
            else
            {
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
                            autologin_b = true;
                        }
                        else
                        {
                            autologin_b = false;
                        }
                    }
                });
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
        usernameEditText = findViewById(R.id.et_username);
        pwEditText = findViewById(R.id.et_passwort);
        sUsername = usernameEditText.getText().toString();
        sPw = pwEditText.getText().toString();
        getData();
    }

    //Checkt auf Richtigkeit der eingegebenden Daten
    public boolean checkAnmeldung()
    {
        boolean result = false;
        if (!sUsername.equals(userDBM.getEmail()) || !sPw.equals(userDBM.getPw()))
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

    public void getData()
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, showUserUrl, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    JSONArray users = response.getJSONArray("user");
                    for (int i = 0; i < users.length(); i++)
                    {
                        JSONObject user = users.getJSONObject(i);
                        String name = user.getString("Email");
                        if (name.equals(usernameEditText.getText().toString()))
                        {
                            if (userDBM.getEmail() == null || userDBM.getEmail().equals(""))
                            {
                                userDBM.insertUser(user.getString("Name"), user.getString("Vorname"),
                                        user.getString("Anrede"), user.getString("Namenszusatz"),
                                        user.getString("Handynr"), user.getString("Email"),
                                        user.getString("Praxis"), user.getString("Adresse"),
                                        user.getString("PLZ"), user.getString("Stadt"),
                                        user.getString("Praxisnr"), user.getString("Adresszusatz"),
                                        user.getString("Passwort"));
                            }
                            else
                            {
                                userDBM.updateUser(user.getString("Name"), user.getString("Vorname"),
                                        user.getString("Anrede"), user.getString("Namenszusatz"),
                                        user.getString("Handynr"), user.getString("Email"),
                                        user.getString("Praxis"), user.getString("Adresse"),
                                        user.getString("PLZ"), user.getString("Stadt"),
                                        user.getString("Praxisnr"), user.getString("Adresszusatz"),
                                        user.getString("Passwort"));
                            }
                        }
                    }
                    if (checkAnmeldung())
                    {
                        //hier switch wert in datenbank aktuallisieren
                        DatenbankManager db = new DatenbankManager(getApplicationContext());
                        if (autologin_b && Integer.parseInt(val) == 0)
                        {
                            db.updateAutoLogTrue();
                        }
                        else if (autologin_b && Integer.parseInt(val) == 1)
                        {
                            db.updateAutoLogFalse();
                        }
                        startActivity(new Intent(getApplicationContext(), Messenger.class));
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
