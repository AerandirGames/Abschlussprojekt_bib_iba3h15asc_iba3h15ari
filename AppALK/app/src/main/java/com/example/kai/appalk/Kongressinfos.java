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

    public void onClick(View view)
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
        /*
        myResult = result;
        Log.v("handleResult",result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan result");
        builder.setMessage(result.getText());

        progressDialog = new ProgressDialog(Kongressinfos.this);
        progressDialog.setMessage("Datei wird heruntergeladen...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        new Thread(new Runnable(){
            @Override
            public void run() {
                downloadFile(myResult.getText());
            }
        }).start();

        AlertDialog ad = builder.create();
        ad.show();
*/
        //mScannerView
        myResult = result;
        dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(result.getText());
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setDescription("Datei wird heruntergeladen....");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        String nameOfFile = URLUtil.guessFileName(result.getText(),null, MimeTypeMap.getFileExtensionFromUrl(result.getText()));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, nameOfFile);

        dm.enqueue(request);

    }

    private void downloadFile(String a) {


        dm = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(a);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference;
        reference = dm.enqueue(request);
        /*try {
            URL fileurl = new URL(a);
            URLConnection uc = fileurl.openConnection();
            uc.connect();
            InputStream ic = new BufferedInputStream(uc.getInputStream(),8192);

            File downloadordner = new File(Environment.getExternalStorageDirectory(),"Download");

            if(!downloadordner.exists())
            {
                downloadordner.mkdirs();

            }

            final File downloadedFile = new File(downloadordner, "kongressbeispiel" + System.currentTimeMillis() + "pdf");

            OutputStream outputStream = new FileOutputStream(downloadedFile);
            byte[] buffer = new byte[1024];

            int read;
            while((read = ic.read(buffer))!= -1)
            {
                outputStream.write(buffer,0,read);
            }

            outputStream.flush();
            outputStream.close();
            ic.close();


        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
