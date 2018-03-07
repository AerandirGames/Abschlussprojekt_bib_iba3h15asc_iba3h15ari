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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class Messenger extends HomeScreen
{
    private EditText frageInput;
    private String user1 = "user", user2 = "Ally";
    public static ArrayList<MessengerMessage> messageList;
    public static MessengerMessageAdapter messageAdapter;
    ListView msgListView;
    public Button senden;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        senden = findViewById(R.id.but_send);
        senden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendTextMessage(v);
            }
        });

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

        });
    }



    public void sendTextMessage(View v)
    {
        frageInput = findViewById(R.id.et_frageInput);

        messageList = new ArrayList<>();
        messageAdapter = new MessengerMessageAdapter(this, messageList);
        msgListView.setAdapter(messageAdapter);

        String message = frageInput.getEditableText().toString();
        if (!message.equalsIgnoreCase("")) {
            final MessengerMessage msg = new MessengerMessage(user1, user2, message, true);
            msg.body = message;
            frageInput.setText("");
            messageAdapter.add(msg);
            messageAdapter.notifyDataSetChanged();
        }
    }
}
