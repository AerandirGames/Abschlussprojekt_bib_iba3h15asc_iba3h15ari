package com.example.kai.appalk;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NebenwirkungenFormular extends AppCompatActivity
{
    private Calendar myCalendar;
    private Button button;
    private ImageView iv;
    private TextView gebDat, groesse, gewicht, name, cNr, beschr;
    private RadioButton geschlechtM;
    private String imgUri;
    private Bitmap photo;
    private File f;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nebenwirkungen_formular);

        myCalendar = Calendar.getInstance();
        button = findViewById(R.id.button7);
        iv = findViewById(R.id.listView);
        gebDat = findViewById(R.id.nwfGebDat);
        groesse = findViewById(R.id.editText6);
        gewicht = findViewById(R.id.editText7);
        name = findViewById(R.id.editText8);
        cNr = findViewById(R.id.editText9);
        beschr = findViewById(R.id.editText10);
        geschlechtM = findViewById(R.id.radioButton);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        gebDat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new DatePickerDialog(NebenwirkungenFormular.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }


    public void nwfSendMail(View view)
    {
        if (checkFormular())
        {

        }
    }

    public boolean checkFormular()
    {
        boolean rtrn = true;
        /*if (!gebDat.getText().toString().isEmpty() && !groesse.getText().toString().isEmpty() &&
                !gewicht.getText().toString().isEmpty() && !name.getText().toString().isEmpty() &&
                !cNr.getText().toString().isEmpty() && !beschr.getText().toString().isEmpty())
        {
            rtrn = true;
        }*/

        return rtrn;
    }

    private void updateLabel()
    {
        String myFormat = "dd.MM.yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.GERMANY);

        gebDat.setText(sdf.format(myCalendar.getTime()));
    }

    public String getGeschlecht()
    {
        String geschlecht;
        if (geschlechtM.isChecked())
        {
            geschlecht = "männlich";
        }
        else
        {
            geschlecht = "weiblich";
        }
        return geschlecht;
    }
}
