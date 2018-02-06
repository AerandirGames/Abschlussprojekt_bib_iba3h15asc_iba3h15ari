package com.example.kai.prototyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterName extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText2);
                String code = editText.getText().toString();
                if (code.equals("ALK2018"))
                {
                    Intent i = new Intent(EnterName.this, FirstCode.class);
                    startActivity(i);
                }
            }
        });
    }
}
