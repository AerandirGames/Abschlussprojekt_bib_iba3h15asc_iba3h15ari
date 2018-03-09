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
    private String vorname, name, email, telnr, pw, pwWiederholen, titel, anrede;
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
                titel = sp_titel.getSelectedItem().toString();
                anrede = sp_anrede.getSelectedItem().toString();
                vorname = et_vorname.getText().toString();
                name = et_name.getText().toString();
                email = et_email.getText().toString();
                telnr = et_telnr.getText().toString();
                pw = et_pw.getText().toString();
                pwWiederholen = et_pwWiederholen.getText().toString();
                datenKorrekt(vorname, name, email, telnr, pw, pwWiederholen, anrede);
            }
        });

        Button back = view.findViewById(R.id.but_tab2zur);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((Registrieren) getActivity()).setCurrentItem(0, true);
            }
        });
        return view;
    }

    private void datenKorrekt(String vorname, String name, String mail, String telnr, String pw, String pwWiederholen, String anrede)
    {
        if (anrede.equals("Herr") || anrede.equals("Frau"))
        {
            System.out.println(anrede);
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
                                ((Registrieren) getActivity()).setCurrentItem(2, true);
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
            System.out.println(anrede);
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
            System.out.println("email ist ok");
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
            System.out.println("email ist nicht ok");
        }
        return korrekt;
    }

    public boolean istTelNr(String telnr)
    {
        boolean korrekt = false;
        if (telnr.matches("^[0-9]*${6,25}"))
        {
            korrekt = true;
            System.out.println("telnr ist ok");
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
            System.out.println("telnr ist nicht ok");
        }
        return korrekt;
    }

    public boolean istSicheresPasswort(String pw)
    {

        boolean korrekt = false;
        if (pw.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,25})"))
        {
            korrekt = true;
            System.out.println("pw ist ok");
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
            System.out.println("pw ist nicht ok");
        }
        return korrekt;
    }

    public boolean stimmenPasswoerterUeberein(String pw, String pwWiederholen)
    {
        boolean korrekt = false;
        if (pw.equals(pwWiederholen))
        {
            korrekt = true;
            System.out.println("passwörter sind gleich");
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
            System.out.println("passwörter sind nicht gleich");
        }
        return korrekt;
    }

    public String[] getEntries()
    {
        return new String[]{vorname, name, email, telnr, pw, pwWiederholen, anrede, titel};

    }
}