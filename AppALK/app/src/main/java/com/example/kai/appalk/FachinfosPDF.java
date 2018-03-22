package com.example.kai.appalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class FachinfosPDF extends Fachinfos
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fachinfos_pdf);

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null)
        {
            if (b.get("name") != null)
            {
                String dateiName = (String) b.get("name");
                pdfView.fromAsset(dateiName).load();
            }
            else
            {
                pdfView.fromFile((File) b.get("datei")).load();
            }
        }
    }
}
