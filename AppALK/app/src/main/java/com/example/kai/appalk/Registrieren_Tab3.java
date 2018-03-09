package com.example.kai.appalk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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

                if (checkBox.isChecked())
                {
                    writeInMySQL();
                }
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

    public void writeInMySQL ()
    {
        db = new MySQLHandler(getApplicationContext());
    }

    public String[] getEntriesFromTab2()
    {
        Registrieren_Tab2 tab2 = new Registrieren_Tab2();
        return tab2.getEntries();
    }
}
