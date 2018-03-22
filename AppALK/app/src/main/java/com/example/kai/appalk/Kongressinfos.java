package com.example.kai.appalk;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.Result;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Kongressinfos extends HomeScreen implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView mScannerView;
    Result myResult;
    DownloadManager dm;
    ArrayAdapter<String> adapter;
    List<String> liste;
    ListView lv;
    File[] dateien;
    File directory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kongresse);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try
        {
            getSupportActionBar().setTitle(R.string.app_name);
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
        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null)
        {
            Context context = getApplicationContext();
            CharSequence text = (CharSequence) b.get("ergebnis");
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        lv = findViewById(R.id.listView);
        liste = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, liste);
        lv.setAdapter(adapter);
        kongresseAnzeigen();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                File f = new File(directory + "/" + dateien[i].getName());
                Intent ii = new Intent(Kongressinfos.this, FachinfosPDF.class);
                ii.putExtra("datei", f);
                startActivity(ii);
            }
        });
    }

    public void QRCodeScannen(View view)
    {
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    public void kongresseAnzeigen()
    {
        directory = new File(Environment.getExternalStorageDirectory().toString() + "/Download");
        dateien = directory.listFiles();
        for (int i = 0; i < dateien.length; ++i)
        {
            if (dateien[i].getName().contains("kongress"))
                liste.add(dateien[i].getName());
        }
    }

    @Override
    public void handleResult(Result result)
    {
        myResult = result;
        dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(result.getText());
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        String nameOfFile = URLUtil.guessFileName(result.getText(), null, MimeTypeMap.getFileExtensionFromUrl(result.getText()));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);
        dm.enqueue(request);

        Intent i = new Intent(this, Kongressinfos.class);
        i.putExtra("ergebnis", "Datei wurde heruntergeladen.");
        startActivity(i);
    }
}
