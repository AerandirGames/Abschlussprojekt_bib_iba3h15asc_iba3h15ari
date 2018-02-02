package com.example.kai.appalk;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Registrieren extends AppCompatActivity
{
    private Registrieren_SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);

        mSectionsPageAdapter = new Registrieren_SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        Registrieren_SectionsPageAdapter adapter = new Registrieren_SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Registrieren_Tab1(), "DocCheck");
        adapter.addFragment(new Registrieren_Tab2(), "Personen daten");
        adapter.addFragment(new Registrieren_Tab3(), "Praxisdaten");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setCurrentItem(int item, boolean smoothScroll)
    {
        mViewPager.setCurrentItem(item, smoothScroll);
    }
}
