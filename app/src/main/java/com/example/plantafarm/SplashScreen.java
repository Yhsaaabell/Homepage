package com.example.plantafarm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.green));
        setContentView(R.layout.splash_screen_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, UserDashboard.class));
                Animatoo.animateCard(SplashScreen.this);
                finish();
                //In this code, The page will display for 3 seconds then after that, it proceed to login page.
            }
        }, 3000); //3000
    }
}