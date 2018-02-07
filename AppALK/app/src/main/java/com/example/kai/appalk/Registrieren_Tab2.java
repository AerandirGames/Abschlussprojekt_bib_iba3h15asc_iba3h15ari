package com.example.kai.appalk;

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
    EditText vorname;
    EditText name;
    EditText email;
    EditText telnr;
    EditText pw;
    EditText pwWiederholen;
    Spinner titel;
    Spinner anrede;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tab2_person, container, false);

        vorname = view.findViewById(R.id.et_vorname);
        name = view.findViewById(R.id.et_nachname);
        email = view.findViewById(R.id.et_mail);
        telnr = view.findViewById(R.id.et_telNr);
        pw = view.findViewById(R.id.et_passwort);
        pwWiederholen = view.findViewById(R.id.et_passwortVerify);
        titel = view.findViewById(R.id.ac_titel);
        anrede = view.findViewById(R.id.sp_anrede);

        Button next = view.findViewById(R.id.but_tab2weiter);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(vorname == null)
                {
                    System.out.println("vorname ist null");
                }
                if(name == null)
                {
                    System.out.println("name ist null");
                }
                if(email == null)
                {
                    System.out.println("mail ist null");
                }
                if(telnr == null)
                {
                    System.out.println("telnr ist null");
                }
                if(pw == null)
                {
                    System.out.println("pw ist null");
                }
                if(pwWiederholen == null)
                {
                    System.out.println("pww ist null");
                }
                if(datenKorrekt(vorname.getText().toString(),name.getText().toString(),email.getText().toString(),telnr.getText().toString(),pw.getText().toString(),pwWiederholen.getText().toString(),titel,anrede))
                {
                    ((Registrieren) getActivity()).setCurrentItem(2, true);
                }
                else
                {

                }
            }
        });

        Button back = view.findViewById(R.id.but_tab2zur);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((Registrieren)getActivity()).setCurrentItem (0, true);
            }
        });



        return view;

    }

    private boolean datenKorrekt(String vorname,String name,String mail,String telnr,String pw,String pwWiederholen,Spinner s1,Spinner s2)
    {
        boolean korrekt = false;

        if(!vorname.equals("")  && !name.equals("") && istMail(mail)&& mail != null  && istTelNr(telnr) && telnr != null  && istSicheresPasswort(pw) && pw != null  && stimmenPasswoerterUeberein(pw,pwWiederholen)&& pwWiederholen != null )
        {
                korrekt = true;
        }
        else
        {
            System.out.println("daten passen nicht");
        }

        return false;
    }


    public boolean istMail(String mail)
    {
        boolean korrekt = false;
        if(mail.matches("(\\w{1,}(\\w|\\.){1,})@(\\w{1,}(\\w|\\.){1,}\\.\\w{2,})"))
        {
            korrekt = true;
            System.out.println("email ist ok");
        }
        else {
            System.out.println("email ist nicht ok");
        }
        return korrekt;
    }

    public boolean istTelNr(String telnr)
    {

        boolean korrekt = false;
        if(telnr.matches("^[0-9]*$"))
        {
            korrekt = true;
            System.out.println("telnr ist ok");
        }
        else {
            System.out.println("telnr ist nicht ok");
        }
        return korrekt;

    }

    public boolean istSicheresPasswort(String pw)
    {

        boolean korrekt = false;
        if(pw.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})"))
        {
            korrekt = true;
            System.out.println("pw ist ok");
        }
        else {
            System.out.println("pw ist nicht ok");
        }
        return korrekt;
    }

    public boolean stimmenPasswoerterUeberein(String pw,String pwWiederholen)
    {
        boolean korrekt = false;
        if(pw.equals(pwWiederholen))
        {
            korrekt = true;
            System.out.println("passwörter sind gleich");
        }
        else {
            System.out.println("passwörter sind nicht gleich");
        }
        return korrekt;

    }

}


