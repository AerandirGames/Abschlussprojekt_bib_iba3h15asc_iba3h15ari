package com.example.kai.appalk;


import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;


public class Messenger extends HomeScreen
{
    private EditText frageInput;
    private Spinner spinnerOben;
    private Spinner spinnerUnten;
    private RadioButton arztRB;
    private RadioButton apothekerRB;
    private boolean istArzt;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try
        {
            getSupportActionBar().setTitle(R.string.app_name);
        }
        catch(NullPointerException n)
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

        ArrayAdapter<CharSequence> apothekerAdapter = ArrayAdapter.createFromResource(this,
            R.array.apothekerFragen, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> arztKAdapter = ArrayAdapter.createFromResource(this,
                R.array.arztKategorien, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> ArztProduktAdapter = ArrayAdapter.createFromResource(this,
                R.array.arztFragenProdukte, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> ArztSonstigesAdapter = ArrayAdapter.createFromResource(this,
                R.array.arztFragenSonstiges, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> kontaktweiseAdapter = ArrayAdapter.createFromResource(this,
                R.array.kontaktierAuswahl, android.R.layout.simple_spinner_item);

        apothekerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arztKAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArztProduktAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArztSonstigesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kontaktweiseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOben = findViewById(R.id.spinner2);
        spinnerUnten = findViewById(R.id.spinner3);

        arztRB = findViewById(R.id.radioButton3);
        apothekerRB = findViewById(R.id.radioButton4);

        istArzt = true;
        arztRB.setEnabled(true);

        arztRB.setChecked(true);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
               // RadioButton rb=(RadioButton)findViewById(checkedId);
                if(!istArzt)
                {
                    System.out.println("Arzt");
                    istArzt = true;
                }
                else
                    {
                        System.out.println("Apotheker");
                        istArzt = false;
                    }


            }
        });
        /*
        final Spinner sp_thema = findViewById(R.id.sp_thema);
        final Spinner sp_infoProdukt = findViewById(R.id.sp_infoProdukt);
        final Spinner sp_infoLieferung = findViewById(R.id.sp_infoLieferung);
        final Spinner sp_infoIndFrage = findViewById(R.id.sp_infoIndFrage);

        sp_thema.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                switch (position)
                {
                    case 0:
                        sp_infoProdukt.setVisibility(View.INVISIBLE);
                        sp_infoLieferung.setVisibility(View.INVISIBLE);
                        sp_infoIndFrage.setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        sp_infoProdukt.setVisibility(View.VISIBLE);
                        sp_infoLieferung.setVisibility(View.INVISIBLE);
                        sp_infoIndFrage.setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        sp_infoProdukt.setVisibility(View.INVISIBLE);
                        sp_infoLieferung.setVisibility(View.VISIBLE);
                        sp_infoIndFrage.setVisibility(View.INVISIBLE);
                        break;

                    case 3:
                        sp_infoProdukt.setVisibility(View.INVISIBLE);
                        sp_infoLieferung.setVisibility(View.INVISIBLE);
                        sp_infoIndFrage.setVisibility(View.VISIBLE);

                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }

        });*/
    }
}
