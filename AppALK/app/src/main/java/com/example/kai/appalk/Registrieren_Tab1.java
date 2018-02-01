package com.example.kai.appalk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Kai on 29.01.2018.
 */

public class Registrieren_Tab1 extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tab1_doccheck, container, false);
        Button button = view.findViewById(R.id.but_tab1weiter);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                nextFragment();
            }
        });
        return view;
    }

    public void nextFragment ()
    {
        /*
        Registrieren_Tab2 tab2 = new Registrieren_Tab2();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.tabItem2, tab2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        */
    }
}
