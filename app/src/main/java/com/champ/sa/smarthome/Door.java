package com.champ.sa.smarthome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class Door extends AppCompatActivity {
    Button doorOpen;
    Button ignore;
    Button refresh;
    private static final String TAG = Room1.class.getName();
    private static final String REQUESTTAG = "first string request";
    private RequestQueue lightRequestQueue;
    private StringRequest stringRequest;
    private String url1 = "http://192.168.225.29/door.php?lock=1";
    private String url2 = "http://192.168.225.29/door.php?lock=0";


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Door.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        doorOpen = (Button) findViewById(R.id.doorOpen);
        ignore = (Button) findViewById(R.id.ignore);
        refresh =(Button) findViewById(R.id.refresh);

       final WebView myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://192.168.225.29/1.jpg");


        Toast.makeText(Door.this, "Updating Image!", Toast.LENGTH_LONG).show();
        myWebView.loadUrl("http://192.168.225.29/1.jpg");


        doorOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestAndChangeState(url1);
                final Toast toast = Toast.makeText(getApplicationContext(), "Door Opened!", Toast.LENGTH_SHORT);
                toast.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 500);
            }
        });

        ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestAndChangeState(url2);
                final Toast toast = Toast.makeText(getApplicationContext(), "Door not opened!", Toast.LENGTH_SHORT);
                toast.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 500);
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            myWebView.loadUrl("http://192.168.225.29/1.jpg");
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


