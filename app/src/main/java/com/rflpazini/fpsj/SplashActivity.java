package com.rflpazini.fpsj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rflpazini on 4/14/16.
 */
public class SplashActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = new Intent(this, MainActivity.class);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        startIntent();
                    }
                }, 600);
    }

    public void startIntent() {
        startActivity(intent);
        finish();
    }
}
