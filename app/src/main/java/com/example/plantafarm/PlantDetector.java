package com.example.plantafarm;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.WeakHashMap;

public class PlantDetector extends AppCompatActivity {
    ImageView btnBack;
    Vibrator vibrator;
    CardView cardCapture, cardUpload;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.lt));
        setContentView(R.layout.plant_detector_layout);

        btnBack = (ImageView) findViewById(R.id.btnBack);
        cardCapture = (CardView) findViewById(R.id.card_capture);
        cardUpload = (CardView) findViewById(R.id.card_upload);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        dialog = new Dialog(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                returnHome();
            }
        });
        cardCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                showCaptureDialog();
            }
        });
        cardUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);

            }
        });
    }
    private void showCaptureDialog(){
        dialog.setContentView(R.layout.capture_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        Button btnClose = dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void returnHome(){
        Intent intent = new Intent(PlantDetector.this, UserDashboard.class);;
        startActivity(intent);
        Animatoo.animateSwipeRight(PlantDetector.this);
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