package com.example.kai.appalk;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Kontakt extends HomeScreen
        implements AdapterView.OnItemSelectedListener
{
    Spinner kontaktdaten;
    TextView kontaktanzeige;
    Button emailSenden;
    String empfaengermail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakt);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try
        {
            getSupportActionBar().setTitle("Kontakt");
        }
        catch (NullPointerException n)
        {
            System.out.println("Nullpointer Exception");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        empfaengermail = "";
        emailSenden = findViewById(R.id.emailKontakt);
        emailSenden.setEnabled(false);

        kontaktanzeige = findViewById(R.id.kontaktanzeige);
        kontaktdaten = findViewById(R.id.kontaktdaten);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.kontaktArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kontaktdaten.setAdapter(adapter);
        kontaktdaten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (kontaktdaten.getSelectedItem().toString())
                {
                    case "-":
                        empfaengermail = "";
                        emailSenden.setEnabled(false);
                        break;
                    case "Deutsche Zentrale":
                        emailSenden.setEnabled(true);
                        empfaengermail = "info-deutschland@alk.net";
                        kontaktanzeige.setText("ALK-Abelló Arzneimittel GmbH\n" +
                                "\n" +
                                "Griegstraße 75, Haus 25\n" +
                                "DE-22763 Hamburg\n" +
                                "\n" +
                                "E-mail: info-deutschland@alk.net\n" +
                                "T (+49) 40 703845-0\n" +
                                "F (+49) 40 703845-5588");
                        break;
                    case "Kundenservice":
                        emailSenden.setEnabled(false);
                        empfaengermail = "";
                        kontaktanzeige.setText("Unser Auftragsteam ist von montags bis freitags von 9:00 bis 12:00 Uhr für Sie da!\n" +
                                "\n" +
                                "Per Telefon: 040 703845 - 100\n" +
                                "Per Fax: 040 703845 - 55 88\n" +
                                "Per Post: ALK-Abelló Arzneimittel GmbH, Postfach, 22758 Hamburg");
                        break;
                    case "Medizinischer Kundenservice":
                        emailSenden.setEnabled(true);
                        empfaengermail = "medizin@alk.net";
                        kontaktanzeige.setText("Bei Fragen zur Behandlung mit ALK-Präparaten kontaktieren Sie bitte unseren medizinischen Kundenservice:\n" +
                                "\n" +
                                "Telefon 040-703845-300\n" +
                                "Fax 040-703845-5530\n" +
                                "Mail medizin@alk.net oder arzneimittelsicherheit@alk-abello.de");
                        break;
                    case "Buchhaltung":
                        emailSenden.setEnabled(true);
                        empfaengermail = "service@alk.net";
                        kontaktanzeige.setText("Bei Fragen zum Zahlungsstand wenden Sie sich bitte an\n" +
                                " unsere Buchhaltung: Telefon 040-703845-400 \n" +
                                "Mail: service@alk.net");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    public void senden(View view)
    {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("application/image");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{empfaengermail});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Kontanktaufnahme über die App");
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }
}
