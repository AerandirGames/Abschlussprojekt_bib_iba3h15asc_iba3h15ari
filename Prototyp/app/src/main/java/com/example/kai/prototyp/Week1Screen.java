package com.example.kai.prototyp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Week1Screen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week1_screen);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/"
                + R.raw.videoplayback;
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse(path));
        videoView.requestFocus();
        videoView.start();
    }
}
