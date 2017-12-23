package com.champ.sa.smarthome;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class VolleySingleton {
    public static VolleySingleton minstance;
    private RequestQueue mRequestQueue;

    public static VolleySingleton getInstance(Context context) {
        if (minstance == null) {
            minstance = new VolleySingleton(context);
        }
        return minstance;
    }

    private VolleySingleton(Context context) {
        mRequestQueue = getRequestQueue(context);
    }

    public RequestQueue getRequestQueue(Context context) {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
        return mRequestQueue;
    }
}
