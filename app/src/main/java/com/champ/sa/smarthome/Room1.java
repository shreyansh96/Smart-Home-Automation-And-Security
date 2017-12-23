package com.champ.sa.smarthome;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class Room1 extends AppCompatActivity {
    private static final String TAG = Room1.class.getName();
    private static final String REQUESTTAG = "first string request";
    ToggleButton button1;
    ToggleButton button2;
    ToggleButton button3;
    ToggleButton button4;
    ToggleButton button5;

    private RequestQueue lightRequestQueue;
    private StringRequest stringRequest;
    private String url1 = "http://192.168.225.29/room1.php?light=1";
    private String url2 = "http://192.168.225.29/room1.php?light=0";
    private String url3 = "http://192.168.225.29/room1.php?fan=1";
    private String url4 = "http://192.168.225.29/room1.php?fan=0";
    private String url5 = "http://192.168.225.29/room1.php?ac=1";
    private String url6 = "http://192.168.225.29/room1.php?ac=0";

    // private DiskBasedCache mCache;
    // private com.android.volley.Network mNetwork;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Room1.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

        button1 = (ToggleButton) findViewById(R.id.lightToggle);
        button2 = (ToggleButton) findViewById(R.id.fanToggle);
        button3 = (ToggleButton) findViewById(R.id.acToggle);
        button4 = (ToggleButton) findViewById(R.id.sensingToggle);
        button5 = (ToggleButton) findViewById(R.id.nightLampToggle);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (button1.isChecked()) {

                    final Toast toast = Toast.makeText(getApplicationContext(), "Light's ON!", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 500);

                    sendRequestAndChangeState(url1);

                } else {
                    final Toast toast = Toast.makeText(getApplicationContext(), "Light's OFF!", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 500);

                    sendRequestAndChangeState(url2);

                }
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button2.isChecked()) {
                    Toast.makeText(Room1.this, "Fan ON!", Toast.LENGTH_LONG).show();
                    sendRequestAndChangeState(url3);

                } else {
                    Toast.makeText(Room1.this, "Fan OFF!", Toast.LENGTH_LONG).show();
                    sendRequestAndChangeState(url4);

                }
            }

        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button3.isChecked()) {
                    Toast.makeText(Room1.this, "Air conditioning ON!", Toast.LENGTH_LONG).show();
//                    sendRequestAndChangeState(url5);

                } else {
                    Toast.makeText(Room1.this, "Air conditioning OFF!", Toast.LENGTH_LONG).show();
//                    sendRequestAndChangeState(url6);

                }
            }

        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button4.isChecked()) {
                    Toast.makeText(Room1.this, "Automatic sensing ON!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Room1.this, "Automatic sensing OFF!", Toast.LENGTH_LONG).show();
                }
            }

        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (button5.isChecked()) {
                    Toast.makeText(Room1.this, "Night Lamp ON!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Room1.this, "Night Lamp OFF!", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    private void sendRequestAndChangeState(String url) {

        lightRequestQueue = VolleySingleton.getInstance(this.getApplicationContext()).getRequestQueue(this.getApplicationContext());
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG, "Error :" + error.toString());
            }
        });
        stringRequest.setTag(REQUESTTAG);
        lightRequestQueue.add(stringRequest);
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (lightRequestQueue != null) {
            lightRequestQueue.cancelAll(REQUESTTAG);

        }
    }

}
