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
        Button next = view.findViewById(R.id.but_tab2weiter);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                vorname = v.findViewById(R.id.et_vorname);
                name = v.findViewById(R.id.et_nachname);
                email = v.findViewById(R.id.et_mail);
                telnr = v.findViewById(R.id.et_telNr);
                pw = v.findViewById(R.id.et_passwort);
                pwWiederholen = v.findViewById(R.id.et_passwortVerify);
                titel = v.findViewById(R.id.ac_titel);
                anrede = v.findViewById(R.id.sp_anrede);
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
        System.out.println("email ist nicht ok");
        return korrekt;
    }

    public boolean istTelNr(String telnr)
    {
    return true;
    }

    public boolean istSicheresPasswort(String pw)
    {
        return true;

    }

    public boolean stimmenPasswoerterUeberein(String pw,String pwWiederholen)
    {
        return true;

    }

}


