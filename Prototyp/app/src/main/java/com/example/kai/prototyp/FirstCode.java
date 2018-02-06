package com.example.kai.prototyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstCode extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_code);

        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = findViewById(R.id.editText3);
                String code = editText.getText().toString();
                if (code.equals("Code1"))
                {
                    Intent i = new Intent(FirstCode.this, Week1Screen.class);
                    startActivity(i);
                }
            }
        });
    }
}
