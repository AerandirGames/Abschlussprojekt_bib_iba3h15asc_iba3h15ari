package com.example.kai.appalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class Messenger extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        final Spinner sp_thema = findViewById(R.id.sp_thema);
        final Spinner sp_infoProdukt = findViewById(R.id.sp_infoProdukt);
        final Spinner sp_infoLieferung = findViewById(R.id.sp_infoLieferung);
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

                        break;

                    case 1:
                        sp_infoProdukt.setVisibility(View.VISIBLE);
                        sp_infoLieferung.setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        sp_infoProdukt.setVisibility(View.INVISIBLE);
                        sp_infoLieferung.setVisibility(View.VISIBLE);
                        break;

                    case 3:
                        sp_infoProdukt.setVisibility(View.INVISIBLE);
                        sp_infoLieferung.setVisibility(View.INVISIBLE);


                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }

    public void changeLayout (View view)
    {

    }
}
