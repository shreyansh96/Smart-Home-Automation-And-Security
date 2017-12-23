package com.champ.sa.smarthome;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;


public class Room4 extends AppCompatActivity {
    ToggleButton button1;
    ToggleButton button2;
    ToggleButton button3;
    ToggleButton button4;
    ToggleButton button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

        button1=(ToggleButton)findViewById(R.id.lightToggle);
        button2=(ToggleButton)findViewById(R.id.fanToggle);
        button3=(ToggleButton)findViewById(R.id.acToggle);
        button4=(ToggleButton)findViewById(R.id.sensingToggle);
        button5=(ToggleButton)findViewById(R.id.nightLampToggle);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button1.isChecked()) {
                    Toast.makeText(Room4.this, "Light's ON!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Room4.this, "Light's OFF!", Toast.LENGTH_LONG).show();
                }
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button2.isChecked()) {
                    Toast.makeText(Room4.this, "Fan ON!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Room4.this, "Fan OFF!", Toast.LENGTH_LONG).show();
                }
            }

        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button3.isChecked()) {
                    Toast.makeText(Room4.this, "Air conditioning ON!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Room4.this, "Air conditioning OFF!", Toast.LENGTH_LONG).show();
                }
            }

        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button4.isChecked()) {
                    Toast.makeText(Room4.this, "Automatic sensing ON!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Room4.this, "Automatic sensing OFF!", Toast.LENGTH_LONG).show();
                }
            }

        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button5.isChecked()) {
                    Toast.makeText(Room4.this, "Night Lamp ON!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Room4.this, "Night Lamp OFF!", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}