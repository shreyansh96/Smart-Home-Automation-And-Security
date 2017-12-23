package com.champ.sa.smarthome;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.IntentFilter;


public class MainActivity extends AppCompatActivity {
    Button room1;
    Button room2;
    Button room3;
    Button room4;
    Button room5;
//    Button room6;
    Button room9;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Caution!!!")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                        finishAffinity();
                        System.exit(0);
                    }
                }).create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        room1 = (Button) findViewById(R.id.room1);
        room2 = (Button) findViewById(R.id.room2);
        room3 = (Button) findViewById(R.id.room3);
        room4 = (Button) findViewById(R.id.room4);
        room5 = (Button) findViewById(R.id.room5);
//        room6 = (ImageButton) findViewById(R.id.room6);
        room9 = (Button) findViewById(R.id.room9);



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
//        room6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addNotification();
//
//            }
//        });


        room9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Outside the door!", Toast.LENGTH_LONG).show();
                Intent o = new Intent(MainActivity.this, Door.class);
                startActivity(o);

            }
        });


    }
    private void addNotification() {

        NotificationCompat.Builder builder = (android.support.v7.app.NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.r8)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

        Intent notificationIntent = new Intent(this, Door.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
}
}