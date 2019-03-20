package com.example.projectoneandroidmine.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.projectoneandroidmine.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences sharedPreferences = getSharedPreferences("LoginActivity", MODE_PRIVATE);
        boolean authenticated = sharedPreferences.getBoolean("authenticated", false);

        if (authenticated) {
            setIntent(HomeActivity.class);
        } else {
            setIntent(LoginActivity.class);
        }
    }

    public void setIntent(final Class aClass) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, aClass));
            }
        }, 3000);
    }
}
