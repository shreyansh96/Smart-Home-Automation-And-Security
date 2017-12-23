package com.champ.sa.smarthome;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.IntentFilter;



public class MainActivity extends AppCompatActivity {
    ImageButton room1;
    ImageButton room2;
    ImageButton room3;
    ImageButton room4;
    ImageButton room5;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        room1 = (ImageButton) findViewById(R.id.room1);
        room2 = (ImageButton) findViewById(R.id.room2);
        room3 = (ImageButton) findViewById(R.id.room3);
        room4 = (ImageButton) findViewById(R.id.room4);
        room5 = (ImageButton) findViewById(R.id.room5);


        room1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Drawing Room", Toast.LENGTH_LONG).show();
                Intent o = new Intent(MainActivity.this, Room1.class);
                startActivity(o);

            }
        });

        room2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Master Bed Room", Toast.LENGTH_LONG).show();
                Intent o = new Intent(MainActivity.this, Room2.class);
                startActivity(o);

            }
        });

        room3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Kitchen", Toast.LENGTH_LONG).show();
                Intent o = new Intent(MainActivity.this, Room3.class);
                startActivity(o);

            }
        });

        room4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Children Bed Room", Toast.LENGTH_LONG).show();
                Intent o = new Intent(MainActivity.this, Room4.class);
                startActivity(o);

            }
        });


        room5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Balcony and Lobby", Toast.LENGTH_LONG).show();
                Intent o = new Intent(MainActivity.this, Room5.class);
                startActivity(o);

            }
        });



    }
}