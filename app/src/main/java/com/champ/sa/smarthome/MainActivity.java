package com.champ.sa.smarthome;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Toast;
        import android.widget.ToggleButton;



public class MainActivity extends Activity {

    ToggleButton tbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbutton = (ToggleButton)findViewById(R.id.toggleButton1);

        tbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(tbutton.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Toggle button is on", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "Toggle button is Off", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}