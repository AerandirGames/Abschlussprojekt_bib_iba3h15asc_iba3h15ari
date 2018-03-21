package com.example.kai.appalk;


import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.ScriptGroup;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.zxing.Result;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Kongressinfos extends HomeScreen implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView mScannerView;
    ProgressDialog progressDialog;
    Result myResult;
    DownloadManager dm;
    ArrayAdapter<String> adapter;
    List<String> liste;
    ListView lv;
    ArrayList<String> pfade;
    PDFView pv;
    Uri uri;
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
        catch(NullPointerException n)
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

        lv = findViewById(R.id.listView);

        pv = findViewById(R.id.pdfView);

        liste = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,liste);

        lv.setAdapter(adapter);

        pfade = new ArrayList<String>();

        kongresseAnzeigen();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i)
                {
                    case 0:
                        pv.fromFile(new File(pfade.get(i)));
                        ;
                    break;
                }
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
        String path = Environment.getExternalStorageDirectory().toString()+"/Download";

        AssetManager mgr = getAssets();


        try {

            String list[] = mgr.list(path);
                for (int i=0; i<list.length; ++i)
                {
                    if(list[i].contains("kongress")) {
                        Log.e("FILE:", path + "/" + list[i]);
                        liste.add(list[i]);
                        pfade.add(path+"/" +list[i]);
                    }
                }

        } catch (IOException e) {
            Log.v("List error:", "can't list" + path);
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mScannerView.stopCamera();
    }


    @Override
    public void handleResult(Result result)
    {

        File file=new File(Environment.DIRECTORY_DOWNLOADS);
        File[] list = file.listFiles();
        int fileNumber = list.length;
        System.out.println(fileNumber);

        myResult = result;
        dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(result.getText());
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        String nameOfFile = URLUtil.guessFileName(result.getText(),null, MimeTypeMap.getFileExtensionFromUrl(result.getText()));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);

        dm.enqueue(request);


        String erg = "";
        file=new File(Environment.DIRECTORY_DOWNLOADS);
        list = file.listFiles();
/*



        File mPath = new File((Environment.DIRECTORY_DOWNLOADS + "/" + nameOfFile));
        System.out.println(mPath);
        System.out.println(mPath.getAbsoluteFile());
        */
        if (fileNumber<list.length) {
            erg = "existiert";
        }else
        {
            erg = "existiert nicht";
        }
        System.out.println(erg);

        Intent i = new Intent(this, Kongressinfos.class);
        startActivity(i);

    }


}
