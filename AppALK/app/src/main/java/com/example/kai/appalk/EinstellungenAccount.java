package com.example.kai.appalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EinstellungenAccount extends AppCompatActivity
{
    private UserDatenbankManager userDBM;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen_account);
        userDBM = new UserDatenbankManager(this);
        System.out.println(userDBM.getNid());
    }

    public void setSendAnrede(View view)
    {
        Spinner sp_titel = findViewById(R.id.spinner);
        String titel = sp_titel.getSelectedItem().toString();
        if (!titel.equals("-"))
        {
            userDBM.updateTitel(titel);
            Toast.makeText(this, "Daten wurden geändert", Toast.LENGTH_LONG).show();
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bitte geben Sie einen korrekten Titel ein")
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
    }

    public void setSendName(View view)
    {
        EditText et_name = findViewById(R.id.editText4);
        String name = et_name.getText().toString();
        if (!name.equals("") && !name.isEmpty())
        {
            userDBM.updateName(name);
            Toast.makeText(this, "Daten wurden geändert", Toast.LENGTH_LONG).show();
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bitte geben Sie neue Daten ein")
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
    }

    public void setSendEmail(View view)
    {
        EditText et_email = findViewById(R.id.editText);
        String email = et_email.getText().toString();
        if (!email.equals("") && !email.isEmpty())
        {
            if (email.matches("(\\w{1,}(\\w|\\.){1,})@(\\w{1,}(\\w|\\.){1,}\\.\\w{2,})"))
            {
                userDBM.updateEmail(email);
                Toast.makeText(this, "Daten wurden geändert", Toast.LENGTH_LONG).show();
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Bitte geben Sie eine gültige E-Mail Adresse ein!")
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bitte geben Sie neue Daten ein")
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
    }

    public void setSendTel(View view)
    {
        EditText et_tel = findViewById(R.id.editText2);
        String tel = et_tel.getText().toString();
        if (!tel.equals("") && !tel.isEmpty())
        {
            if (tel.matches("^[0-9]*${6,25}"))
            {
                userDBM.updateTel(tel);
                Toast.makeText(this, "Daten wurden geändert", Toast.LENGTH_LONG).show();
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Bitte geben Sie eine gültige Telefonnummer ein!")
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bitte geben Sie neue Daten ein")
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
    }

    public void setSendPw(View view)
    {
        EditText et_pw = findViewById(R.id.editText3);
        String pw = et_pw.getText().toString();
        if (!pw.equals("") && !pw.isEmpty())
        {
            if (pw.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,25})"))
            {
                userDBM.updatePasswort(pw);
                Toast.makeText(this, "Daten wurden geändert", Toast.LENGTH_LONG).show();
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Bitte geben Sie ein gültiges Passwort ein, dass minimal 6 und maximal 25 Zeichen enthält!")
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bitte geben Sie neue Daten ein")
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
    }

    public void setSendPraxis(View view)
    {
        EditText et_praxisName = findViewById(R.id.editText5);
        EditText et_praxisTel = findViewById(R.id.editText15);
        EditText et_praxisAdresse = findViewById(R.id.editText12);
        EditText et_praxisPLZ = findViewById(R.id.editText14);
        EditText et_praxisStadt = findViewById(R.id.editText13);
        EditText et_praxisAdresszs = findViewById(R.id.editText16);
        String praxisName = et_praxisName.getText().toString();
        String praxisTel = et_praxisTel.getText().toString();
        String praxisAdresse = et_praxisAdresse.getText().toString();
        String praxisPLZ = et_praxisPLZ.getText().toString();
        String praxisStadt = et_praxisStadt.getText().toString();
        String praxisAdresszs = et_praxisAdresszs.getText().toString();
        if (!praxisName.isEmpty() && !praxisName.equals("") && !praxisTel.isEmpty() &&
                !praxisTel.equals("") && !praxisAdresse.isEmpty() &&
                !praxisAdresse.equals("") && !praxisPLZ.equals("") &&
                !praxisPLZ.isEmpty() && !praxisStadt.isEmpty() && !praxisStadt.equals(""))
        {
            if (praxisTel.matches("^[0-9]*${6,25}"))
            {
                if (praxisPLZ.length() == 5)
                {
                    userDBM.updatePraxis(praxisName, praxisAdresse, praxisPLZ, praxisStadt, praxisTel, praxisAdresszs);
                    Toast.makeText(this, "Daten wurden geändert", Toast.LENGTH_LONG).show();
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setMessage("Bitte geben Sie eine gültige Postleitzahl ein!")
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Bitte geben Sie eine gültige Telefonnummer ein!")
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Bitte geben Sie neue Daten ein")
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
    }

    public void abmelden(View view)
    {
        DatenbankManager dbm = new DatenbankManager(this);
        String input = "";
        Cursor res = dbm.getSwitchValue();
        while (res.moveToNext())
        {
            input = res.getString(1);
        }
        if (input.equals("1"))
        {
            dbm.updateAutoLogFalse();
        }
        userDBM.deleteUser();
        startActivity(new Intent(this, Anmelden.class));
    }
}
