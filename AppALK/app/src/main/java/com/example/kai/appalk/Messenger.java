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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Messenger extends HomeScreen
{
    private EditText frageInput;
    private Spinner spinnerOben;
    private Spinner spinnerUnten;
    private RadioButton arztRB;
    private RadioButton apothekerRB;
    private Button fragen;

    ArrayAdapter<CharSequence> apothekerAdapter;
    ArrayAdapter<CharSequence> arztKAdapter;
    ArrayAdapter<CharSequence> arztProduktAdapter;
    ArrayAdapter<CharSequence> arztSonstigesAdapter;
    ArrayAdapter<CharSequence> kontaktweiseAdapter;
    String frage;

    TextView frageTitel;

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

        apothekerAdapter = ArrayAdapter.createFromResource(this,
                R.array.apothekerFragen, R.layout.spinner_layout);
        arztKAdapter = ArrayAdapter.createFromResource(this,
                R.array.arztKategorien, R.layout.spinner_layout);
        arztProduktAdapter = ArrayAdapter.createFromResource(this,
                R.array.arztFragenProdukte, R.layout.spinner_layout);
        arztSonstigesAdapter = ArrayAdapter.createFromResource(this,
                R.array.arztFragenSonstiges, R.layout.spinner_layout);
        kontaktweiseAdapter = ArrayAdapter.createFromResource(this,
                R.array.kontaktierAuswahl, R.layout.spinner_layout);

        apothekerAdapter.setDropDownViewResource(R.layout.spinner_layout);
        arztKAdapter.setDropDownViewResource(R.layout.spinner_layout);
        arztProduktAdapter.setDropDownViewResource(R.layout.spinner_layout);
        arztSonstigesAdapter.setDropDownViewResource(R.layout.spinner_layout);
        kontaktweiseAdapter.setDropDownViewResource(R.layout.spinner_layout);

        spinnerOben = findViewById(R.id.spinner2);
        spinnerUnten = findViewById(R.id.spinner3);
        spinnerUnten.setVisibility(View.INVISIBLE);
        spinnerOben.setVisibility(View.INVISIBLE);

        frageTitel = findViewById(R.id.textView26);
        frageTitel.setVisibility(View.INVISIBLE);

        arztRB = findViewById(R.id.radioButton3);
        apothekerRB = findViewById(R.id.radioButton4);

        frageInput = findViewById(R.id.editText11);
        frageInput.setVisibility(View.INVISIBLE);
        fragen = findViewById(R.id.button2);
        fragen.setEnabled(false);
        fragen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (frage.equals("E-Mail") || frage.equals("SMS") || frage.equals("Per Anruf"))
                {
                    String empfaenger = "daniel.schitz@web.de";
                    String betreff = "Kunde möchte per " + frage + " kontaktiert werden";
                    String nutzerFrage = "" + frageInput.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{empfaenger});
                    intent.putExtra(Intent.EXTRA_SUBJECT, betreff);
                    intent.putExtra(Intent.EXTRA_TEXT, nutzerFrage);

                    intent.setType("messege/rfc822");
                    startActivity(Intent.createChooser(intent, "Send Email"));
                }
                else
                {
                    Intent i = new Intent(Messenger.this, MessengerFrageAusgabe.class);
                    i.putExtra("frage", frage);
                    startActivity(i);
                }
            }
        });

        spinnerOben.setAdapter(arztKAdapter);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                // checkedId is the RadioButton selected
                // RadioButton rb=(RadioButton)findViewById(checkedId);
                spinnerOben.setVisibility(View.VISIBLE);
                spinnerUnten.setVisibility(View.INVISIBLE);
                frageInput.setVisibility(View.INVISIBLE);
                frageTitel.setVisibility(View.INVISIBLE);
                fragen.setEnabled(false);
                if (checkedId != 2131689693)
                {
                    spinnerOben.setAdapter(arztKAdapter);
                    spinnerOben.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                    {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
                        {
                            switch (position)
                            {
                                case 0:
                                    spinnerUnten.setVisibility(View.INVISIBLE);
                                    break;

                                case 1:
                                    spinnerUnten.setVisibility(View.VISIBLE);
                                    spinnerUnten.setAdapter(arztProduktAdapter);
                                    spinnerUnten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                                    {
                                        @Override
                                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
                                        {
                                            switch (position)
                                            {
                                                case 0:
                                                    break;
                                                case 1:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                                case 2:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                                case 3:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                                case 4:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                                case 5:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                            }
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> adapterView)
                                        {

                                        }
                                    });
                                    break;
                                case 2:
                                    spinnerUnten.setVisibility(View.VISIBLE);
                                    spinnerUnten.setAdapter(arztSonstigesAdapter);
                                    spinnerUnten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                                    {
                                        @Override
                                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
                                        {
                                            switch (position)
                                            {
                                                case 0:
                                                    break;
                                                case 1:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                                case 2:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                                case 3:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                                case 4:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                                case 5:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    break;
                                            }
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> adapterView)
                                        {

                                        }
                                    });
                                    break;
                                case 3:
                                    spinnerUnten.setVisibility(View.VISIBLE);
                                    spinnerUnten.setAdapter(kontaktweiseAdapter);

                                    spinnerUnten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                                    {
                                        @Override
                                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
                                        {
                                            switch (position)
                                            {
                                                case 0:
                                                    break;
                                                case 1:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    frageInput.setVisibility(View.VISIBLE);
                                                    frageTitel.setVisibility(View.VISIBLE);
                                                    break;
                                                case 2:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    frageInput.setVisibility(View.VISIBLE);
                                                    frageTitel.setVisibility(View.VISIBLE);
                                                    break;
                                                case 3:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    frageInput.setVisibility(View.VISIBLE);
                                                    frageTitel.setVisibility(View.VISIBLE);
                                                    break;
                                            }
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> adapterView)
                                        {

                                        }
                                    });
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView)
                        {

                        }
                    });
                }
                else
                {
                    spinnerOben.setAdapter(apothekerAdapter);
                    spinnerOben.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                    {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
                        {
                            switch (position)
                            {
                                case 0:
                                    break;
                                case 1:
                                    frage = spinnerOben.getAdapter().getItem(position).toString();
                                    fragen.setEnabled(true);
                                    break;
                                case 2:
                                    frage = spinnerOben.getAdapter().getItem(position).toString();
                                    fragen.setEnabled(true);
                                    break;
                                case 3:
                                    frage = spinnerOben.getAdapter().getItem(position).toString();
                                    fragen.setEnabled(true);
                                    break;
                                case 4:
                                    frage = spinnerOben.getAdapter().getItem(position).toString();
                                    fragen.setEnabled(true);
                                    break;
                                case 5:
                                    frage = spinnerOben.getAdapter().getItem(position).toString();
                                    fragen.setEnabled(true);
                                    break;
                                case 6:
                                    frage = spinnerOben.getAdapter().getItem(position).toString();
                                    fragen.setEnabled(true);
                                    break;
                                case 7:
                                    spinnerUnten.setVisibility(View.VISIBLE);
                                    spinnerUnten.setAdapter(kontaktweiseAdapter);
                                    spinnerUnten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                                    {
                                        @Override
                                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
                                        {
                                            switch (position)
                                            {
                                                case 0:
                                                    break;
                                                case 1:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    frageInput.setVisibility(View.VISIBLE);
                                                    frageTitel.setVisibility(View.VISIBLE);
                                                    break;
                                                case 2:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    frageInput.setVisibility(View.VISIBLE);
                                                    frageTitel.setVisibility(View.VISIBLE);
                                                    break;
                                                case 3:
                                                    frage = spinnerUnten.getAdapter().getItem(position).toString();
                                                    fragen.setEnabled(true);
                                                    frageInput.setVisibility(View.VISIBLE);
                                                    frageTitel.setVisibility(View.VISIBLE);
                                                    break;
                                            }
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> adapterView)
                                        {

                                        }
                                    });
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView)
                        {

                        }

                    });
                }
            }
        });

    }
}
