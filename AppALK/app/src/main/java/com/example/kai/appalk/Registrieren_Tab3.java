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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by Kai on 29.01.2018.
 */

public class Registrieren_Tab3 extends Fragment
{
    private String[] tab2entries;
    private EditText et_praxisName, et_adresse, et_plz, et_stadt, et_praxisTel, et_praxisMail;
    private String praxisName, adresse, plz, stadt, praxisTel, praxisMail;
    private CheckBox checkBox;
    private MySQLHandler db;
    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tab3_praxis, container, false);
        Button registrieren = view.findViewById(R.id.but_tab3register);
        Button back = view.findViewById(R.id.but_tab3zur);

        et_praxisName = view.findViewById(R.id.et_praxisName);
        et_adresse = view.findViewById(R.id.et_adresse);
        et_plz = view.findViewById(R.id.et_plz);
        et_stadt = view.findViewById(R.id.et_stadt);
        et_praxisTel = view.findViewById(R.id.et_praxisTelNr);
        et_praxisMail = view.findViewById(R.id.et_praxisMail);
        checkBox = view.findViewById(R.id.checkBox);

        registrieren.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                praxisName = et_praxisName.getText().toString();
                adresse = et_adresse.getText().toString();
                plz = et_plz.getText().toString();
                stadt = et_stadt.getText().toString();
                praxisTel = et_praxisTel.getText().toString();
                praxisMail = et_praxisMail.getText().toString();
                tab2entries = getEntriesFromTab2();


                //if (checkBox.isEnabled())
                //{
                    if (praxisMail.matches("(\\w{1,}(\\w|\\.){1,})@(\\w{1,}(\\w|\\.){1,}\\.\\w{2,})") || praxisMail.isEmpty())
                    {
                        user = new User(tab2entries[0], tab2entries[1], tab2entries[2], tab2entries[3], tab2entries[4], tab2entries[5], tab2entries[6],
                                praxisName, adresse, plz, stadt, praxisTel, praxisMail);
                        writeInMySQL();
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
               /* }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Sie müssen unsere Datenschutzbestimmungen und AGBs akzeptieren!")
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id)
                                {

                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }*/
            }
        });

        back.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {
                ((Registrieren) getActivity()).setCurrentItem(1, true);
            }
        });
        return view;
    }

    public void writeInMySQL()
    {
        db = new MySQLHandler(this.getContext());
    }

    public String[] getEntriesFromTab2()
    {
        Registrieren_Tab2 tab2 = new Registrieren_Tab2();
        return tab2.getEntries();
    }
}
