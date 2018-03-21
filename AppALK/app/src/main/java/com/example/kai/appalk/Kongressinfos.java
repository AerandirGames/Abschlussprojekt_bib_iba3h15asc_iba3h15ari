package com.example.kai.appalk;


import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;

import com.google.zxing.Result;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Kongressinfos extends HomeScreen implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView mScannerView;
    ProgressDialog progressDialog;
    Result myResult;
    DownloadManager dm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_kongresse);

    }

    public void QRCodeScannen(View view)
    {
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
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

/*

        file=new File(Environment.DIRECTORY_DOWNLOADS);
        list = file.listFiles();

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
        /*
        Intent i = new Intent(this, Kongressinfos.class);
        i.putExtra("ergebnis", erg);
        startActivity(i);*/

    }


}
