package com.example.plantafarm;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.WeakHashMap;

public class UserNotification extends AppCompatActivity {
    ImageView btnBack;
    Vibrator vibrator;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.lt));
        setContentView(R.layout.user_notification_layout);

        btnBack = (ImageView) findViewById(R.id.btnBack);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        dialog = new Dialog(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                returnHome();
            }
        });
    }

    private void returnHome(){
        Intent intent = new Intent(UserNotification.this, UserDashboard.class);;
        startActivity(intent);
        Animatoo.animateSwipeRight(UserNotification.this);
    }


    private void showToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        returnHome();
    }
}