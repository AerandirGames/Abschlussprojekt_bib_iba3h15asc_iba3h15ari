package com.example.kai.appalk;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Einstellungen extends HomeScreen
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try
        {
            getSupportActionBar().setTitle("Einstellungen");
        }
        catch (NullPointerException n)
        {
            System.out.println("Nullpointer Exception");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void zuEinstellungenAccount(View view)
    {
        startActivity(new Intent(this, EinstellungenAccount.class));
    }

    public void zuEinstellungenImpressum(View view)
    {
        startActivity(new Intent(this, EinstellungenImpressum.class));
    }
}
