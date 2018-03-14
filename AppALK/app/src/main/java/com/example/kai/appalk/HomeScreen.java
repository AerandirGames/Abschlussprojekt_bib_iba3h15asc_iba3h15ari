package com.example.kai.appalk;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class HomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.faq)
        {
            startActivity(new Intent(this, Messenger.class));
        }
        else if (id == R.id.kontakt)
        {
            startActivity(new Intent(this, Kontakt.class));
        }
        else if (id == R.id.kongresse)
        {
            startActivity(new Intent(this, Kongressinfos.class));
        }
        else if (id == R.id.nebenwirkungen)
        {
            startActivity(new Intent(this, Nebenwirkungen.class));
        }
        else if (id == R.id.fachinfos)
        {
            startActivity(new Intent(this, Fachinfos.class));
        }
        else if (id == R.id.einstellungen)
        {
            startActivity(new Intent(this, Einstellungen.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }

}
