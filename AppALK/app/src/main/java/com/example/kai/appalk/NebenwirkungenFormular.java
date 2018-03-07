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
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK)
        {
            photo = (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(photo);
            BitmapDrawable drawable = new BitmapDrawable(getResources(), photo);
            imgUri = Environment.getExternalStorageDirectory().getAbsolutePath();
            File dir = new File(imgUri);
            File file = new File(dir, "image.jpeg");
            FileOutputStream fOut = null;
            try
            {
                fOut = new FileOutputStream(file);
                photo.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                fOut.flush();
                fOut.close();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void nwfSendMail(View view)
    {
        if (checkFormular())
        {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("application/image");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"alkpv@trash-mail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nebenwirkungsmeldung");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Informationen Patient:\n" +
                    "Geburtsdatum: " + gebDat.getText().toString() + ", Geschlecht: " + getGeschlecht() + ", Größe: "
                    + groesse.getText().toString() + "cm, Gewicht: " + gewicht.getText().toString() + "kg\nInformationen Präparat:\n" +
                    "Name des Präparats: " + name.getText().toString() + ", Chargen-Nr: " + cNr.getText().toString() + "\n" +
                    "Informationen der Reaktion:\nBeschreibung der Reaktion: " + beschr.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_STREAM, photo);
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
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
