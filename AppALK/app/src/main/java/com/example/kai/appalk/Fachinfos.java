package com.example.kai.appalk;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ExpandableListView;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fachinfos extends HomeScreen
{
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fachinfos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try
        {
            getSupportActionBar().setTitle("Fachinformationen");
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

        //pdfView = (PDFView) findViewById(R.id.pdfView);
        //pdfView.setVisibility(View.INVISIBLE);

        ExpandableListView listView = findViewById(R.id.fi_expLv);
        //listView.setVisibility(View.VISIBLE);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
        {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l)
            {
                String a = "" + listAdapter.getGroup(i);
                String b = "" + listAdapter.getChild(i, i1);
                pdfShow(a, b);
                return false;
            }
        });
    }

    private void initData()
    {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("ACARIZAX®");
        listDataHeader.add("ALK-depot SQ®");
        listDataHeader.add("ALK start SQ®");
        listDataHeader.add("AVANZ®");
        listDataHeader.add("GRAZAX®");
        listDataHeader.add("Pangramin® Ultra");
        listDataHeader.add("SLIToneUltra®");
        listDataHeader.add("Insektengifte");
        listDataHeader.add("Jext®");
        listDataHeader.add("Diagnostika");

        List<String> acarizax = new ArrayList<>();
        acarizax.add("Gebrauchs- und Fachinformation");

        List<String> depotSQ = new ArrayList<>();
        depotSQ.add("Gebrauchs- und Fachinformation Baumpollen");
        depotSQ.add("Gebrauchs- und Fachinformation Gräserpollen");
        depotSQ.add("Gebrauchs- und Fachinformation Insekten");
        depotSQ.add("Gebrauchs- und Fachinformation Milben");
        depotSQ.add("Gebrauchs- und Fachinformation NPP");
        depotSQ.add("Gebrauchs- und Fachinformation N");

        List<String> startSQ = new ArrayList<>();
        startSQ.add("Gebrauchs- und Fachinformation Birke und Frühblüher");
        startSQ.add("Gebrauchs- und Fachinformation Gräsermischung und Roggen");

        List<String> avanz = new ArrayList<>();
        avanz.add("Fachinformation Gräser");
        avanz.add("Gebrauchsinformation Gräser");
        avanz.add("Fachinformationen Bäume");
        avanz.add("Gebrauchsinformation Bäume");
        avanz.add("Fachinformation Milben");
        avanz.add("Gebrauchsinformation Milben");
        avanz.add("Fachinformation Diverse Allergene");
        avanz.add("Gebrauchsinformation Diverse Allergene");

        List<String> grazax = new ArrayList<>();
        grazax.add("Fachinformation");
        grazax.add("Gebrauchsinformation");

        List<String> pangramin = new ArrayList<>();
        pangramin.add("Gebrauchs- und Fachinformation");

        List<String> slitone = new ArrayList<>();
        slitone.add("Fachinformation Gräser");
        slitone.add("Gebrauchsinformation Gräser");
        slitone.add("Fachinformation Frühblüher");
        slitone.add("Gebrauchsinformation Frühblüher");
        slitone.add("Fachinformation Milben");
        slitone.add("Gebrauchsinformation Milben");

        List<String> insektengifte = new ArrayList<>();
        insektengifte.add("ALK-depot SQ® Fachinformation Insekten");
        insektengifte.add("ALK-depot SQ® Gebrauchsinformation Insekten");
        insektengifte.add("ALK-lyophilisiert SQ® Fachinformation Insekten");
        insektengifte.add("ALK-lyophilisiert SQ® Gebrauchsinformation Insekten");
        insektengifte.add("Reless® Fachinformation Insekten");
        insektengifte.add("Reless® Gebrauchsinformation Insekten");

        List<String> jext = new ArrayList<>();
        jext.add("Fachinformation 150");
        jext.add("Fachinformation 300");
        jext.add("Gebrauchsinformation 150");
        jext.add("Gebrauchsinformation 300");

        List<String> diagnostika = new ArrayList<>();
        diagnostika.add("ALK-prick Gebrauchs- und Fachinformation Positiv-Kontrolle");
        diagnostika.add("ALK-prick Gebrauchsinformation Negativ-Kontrolle");
        diagnostika.add("ALK-prick Fachinformation Negativ-Kontrolle");
        diagnostika.add("ALK-prick Gebrauchs- und Fachinformation Pollen");
        diagnostika.add("ALK-prick Gebrauchs- und Fachinformation Nahrungsmittel");
        diagnostika.add("ALK-prick Gebrauchs- und Fachinformation Tierhaare");
        diagnostika.add("ALK-prick Gebrauchs- und Fachinformation Milben");
        diagnostika.add("ALK-prick Gebrauchs- und Fachinformation Schimmelpilze");
        diagnostika.add("ALK-prick Gebrauchs- und Fachinformation Insekten");
        diagnostika.add("ALK-lyophisiert SQ");
        diagnostika.add("ALK-lyophilisiert SQ Insektengifte");

        listHash.put(listDataHeader.get(0), acarizax);
        listHash.put(listDataHeader.get(1), depotSQ);
        listHash.put(listDataHeader.get(2), startSQ);
        listHash.put(listDataHeader.get(3), avanz);
        listHash.put(listDataHeader.get(4), grazax);
        listHash.put(listDataHeader.get(5), pangramin);
        listHash.put(listDataHeader.get(6), slitone);
        listHash.put(listDataHeader.get(7), insektengifte);
        listHash.put(listDataHeader.get(8), jext);
        listHash.put(listDataHeader.get(9), diagnostika);
    }

    private void pdfShow(String a, String b)
    {
        String dateiName = a + " " + b + ".pdf";
        Intent intent = new Intent(this, FachinfosPDF.class);
        intent.putExtra("name", dateiName);
        startActivity(intent);
    }
}
