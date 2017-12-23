package com.champ.sa.smarthome;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;

public class Login extends Activity  {
    Button b1;
    EditText ed1,ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        b1 = (Button)findViewById(R.id.btn_login);
        ed1 = (EditText)findViewById(R.id.input_user);
        ed2 = (EditText)findViewById(R.id.input_password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("user") &&
                        ed2.getText().toString().equals("password")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent main = new Intent(Login.this,MainActivity.class);
                    startActivity(main);


                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();


                }
            }
        });


    }
}