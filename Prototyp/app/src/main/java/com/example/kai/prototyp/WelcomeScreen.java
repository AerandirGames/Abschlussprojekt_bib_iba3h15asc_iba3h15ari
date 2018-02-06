package com.example.kai.prototyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeScreen extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Thread welcomeThread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    super.run();
                    sleep(4000);  //Delay of 4 seconds
                }
                catch (Exception e)
                {
                    System.out.print(e.getMessage());
                }
                finally
                {
                    Intent i = new Intent(WelcomeScreen.this, EnterName.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
