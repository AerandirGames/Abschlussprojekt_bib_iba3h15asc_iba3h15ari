package com.example.kai.appalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fachinfos extends AppCompatActivity
{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fachinfos);

        listView = (ExpandableListView) findViewById(R.id.fi_expLv);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
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
        acarizax.add("GIFI ACARIZAX");

        List<String> depotSQ = new ArrayList<>();
        depotSQ.add("GIFI Baumpollen");
        depotSQ.add("GIFI Gräserpollen");
        depotSQ.add("GIFI Insekten");
        depotSQ.add("GIFI Milben");
        depotSQ.add("GIFI NPP");
        depotSQ.add("GIFI N");

        List<String> startSQ = new ArrayList<>();
        startSQ.add("GIFI Birke und Frühblüher");
        startSQ.add("GIFI Gräsermischung und Roggen");

        List<String> avanz = new ArrayList<>();
        avanz.add("Gräser Fachinformation");
        avanz.add("Gräser Gebrauchsinformation");
        avanz.add("Bäume Fachinformationen");
        avanz.add("Bäume Gebrauchsinformation");
        avanz.add("Milben Fachinformation");
        avanz.add("Milben Gebrauchsinformation");
        avanz.add("Diverse Allergene Fachinformation");
        avanz.add("Diverse Allergene Gebrauchsinformation");

        List<String> grazax = new ArrayList<>();
        grazax.add("Fachinformation");
        grazax.add("Gebrauchsinformation");

        List<String> pangramin = new ArrayList<>();
        pangramin.add("Gebrauchs- und Fachinformation");

        List<String> slitone = new ArrayList<>();
        slitone.add("Gräser Fachinformation");
        slitone.add("Gräser Gebrauchsinformation");
        slitone.add("Frühblüher Fachinformation");
        slitone.add("Frühblüher Gebrauchsinformation");
        slitone.add("Milben Fachinformation");
        slitone.add("Milben Gebrauchsinformation");

        List<String> insektengifte = new ArrayList<>();
        insektengifte.add("ALK-depot SQ® Insekten Fachinformation");
        insektengifte.add("ALK-depot SQ® Insekten Gebrauchsinformation");
        insektengifte.add("ALK-lyophilisiert SQ® Insekten Fachinformation");
        insektengifte.add("ALK-lyophilisiert SQ® Insekten Gebrauchsinformation");
        insektengifte.add("Reless® Insekten Fachinformation");
        insektengifte.add("Reless® Insekten Gebrauchsinformation");

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
}
