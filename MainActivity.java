package com.example.gabi2.agendacontato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent HomeIntent = new Intent(MainActivity.this,cadastro.class);
                startActivity(HomeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
