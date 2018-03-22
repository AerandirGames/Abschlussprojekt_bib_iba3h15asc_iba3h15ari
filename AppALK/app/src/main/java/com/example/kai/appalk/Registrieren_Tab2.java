package com.example.kai.appalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Kai on 29.01.2018.
 */

public class Registrieren_Tab2 extends Fragment
{
    private EditText et_vorname, et_name, et_email, et_telnr, et_pw, et_pwWiederholen;
    private Spinner sp_titel, sp_anrede;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tab2_person, container, false);

        et_vorname = view.findViewById(R.id.et_vorname);
        et_name = view.findViewById(R.id.et_nachname);
        et_email = view.findViewById(R.id.et_mail);
        et_telnr = view.findViewById(R.id.et_telNr);
        et_pw = view.findViewById(R.id.et_passwort);
        et_pwWiederholen = view.findViewById(R.id.et_passwortVerify);
        sp_titel = view.findViewById(R.id.ac_titel);
        sp_anrede = view.findViewById(R.id.sp_anrede);

        Button next = view.findViewById(R.id.but_tab2weiter);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Registrieren_Tab3.titel = sp_titel.getSelectedItem().toString();
                Registrieren_Tab3.anrede = sp_anrede.getSelectedItem().toString();
                Registrieren_Tab3.vorname = et_vorname.getText().toString();
                Registrieren_Tab3.name = et_name.getText().toString();
                Registrieren_Tab3.email = et_email.getText().toString();
                Registrieren_Tab3.telnr = et_telnr.getText().toString();
                Registrieren_Tab3.pw = et_pw.getText().toString();
                Registrieren_Tab3.pwWiederholen = et_pwWiederholen.getText().toString();
                datenKorrekt(Registrieren_Tab3.vorname, Registrieren_Tab3.name, Registrieren_Tab3.email, Registrieren_Tab3.telnr,
                        Registrieren_Tab3.pw, Registrieren_Tab3.pwWiederholen, Registrieren_Tab3.anrede);
            }
        });
        return view;
    }

    private void datenKorrekt(String vorname, String name, String mail, String telnr, String pw, String pwWiederholen, String anrede)
    {
        if (anrede.equals("Herr") || anrede.equals("Frau"))
        {
            if (!vorname.equals("") && !vorname.isEmpty() && !name.equals("") && !name.isEmpty())
            {
                if (istMail(mail))
                {
                    if (istTelNr(telnr))
                    {
                        if (istSicheresPasswort(pw))
                        {
                            if (stimmenPasswoerterUeberein(pw, pwWiederholen))
                            {
                                ((Registrieren) getActivity()).setCurrentItem(1, true);
                            }
                        }
                    }
                }
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Bitte geben Sie Ihren Namen ein!")
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
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Bitte geben Sie Ihr Geschlecht an!")
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

    public boolean istMail(String mail)
    {
        boolean korrekt = false;
        if (mail.matches("(\\w{1,}(\\w|\\.){1,})@(\\w{1,}(\\w|\\.){1,}\\.\\w{2,})"))
        {
            korrekt = true;
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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
        return korrekt;
    }

    public boolean istTelNr(String telnr)
    {
        boolean korrekt = false;
        if (telnr.matches("([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})|([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})|([\\+(]?(\\d){2,}[)]?[- \\.]?(\\d){2,}[- \\.]?(\\d){2,})"))
        {
            korrekt = true;
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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
        return korrekt;
    }

    public boolean istSicheresPasswort(String pw)
    {
        boolean korrekt = false;
        if (pw.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,25})"))
        {
            korrekt = true;
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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
        return korrekt;
    }

    public boolean stimmenPasswoerterUeberein(String pw, String pwWiederholen)
    {
        boolean korrekt = false;
        if (pw.equals(pwWiederholen))
        {
            korrekt = true;
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Bitte geben Sie das gleiche Passwort ein!")
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        return korrekt;
    }
}