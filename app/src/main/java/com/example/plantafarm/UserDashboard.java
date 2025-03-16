package com.example.plantafarm;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.WeakHashMap;

public class UserDashboard extends AppCompatActivity {



    Vibrator vibrator;
    Dialog dialog,dialog2;
    TextView txtViewAll;

    CardView cardCrops,cardCamera,cardCalendar;

    ImageView open_menu,open_notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.lt));
        setContentView(R.layout.user_dashboard_layout);

        open_menu = (ImageView) findViewById(R.id.open_menu);
        open_notification = (ImageView) findViewById(R.id.open_notification);
        txtViewAll = (TextView) findViewById(R.id.txtViewAll);
        cardCrops = (CardView) findViewById(R.id.cardCrops);
        cardCamera = (CardView) findViewById(R.id.cardCamera);
        cardCalendar = (CardView) findViewById(R.id.cardCalendar);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        dialog = new Dialog(this);
        dialog2 = new Dialog(this);

        cardCrops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                openCrops();
            }
        });
        cardCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                openCalendar();
            }
        });
        cardCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                openCamera();
            }
        });
        open_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                showMenu();
            }
        });
        open_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                openNotification();
            }
        });
        txtViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                openHistory();
            }
        });

    }


    private void showMenu(){
        dialog.setContentView(R.layout.user_menu_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Window window = dialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.TOP | Gravity.START;

        LinearLayout nav_profile = dialog.findViewById(R.id.nav_profile);
        LinearLayout nav_calendar = dialog.findViewById(R.id.nav_calendar);
        LinearLayout nav_soil = dialog.findViewById(R.id.nav_soil);
        LinearLayout nav_feedback = dialog.findViewById(R.id.nav_feedback);
        LinearLayout nav_recommend = dialog.findViewById(R.id.nav_recommend);
        LinearLayout nav_legal = dialog.findViewById(R.id.nav_legal);
        LinearLayout nav_start = dialog.findViewById(R.id.nav_start);
        LinearLayout nav_settings= dialog.findViewById(R.id.nav_settings);
        LinearLayout nav_out= dialog.findViewById(R.id.nav_out);

        TextView txt_user = dialog.findViewById(R.id.txt_user);
        TextView txt_id = dialog.findViewById(R.id.txt_id);

        nav_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();
                openProfile();
            }
        });
        nav_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();
                openCalendar();
            }
        });
        nav_soil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();
                openSoilMonitoring();
            }
        });
        nav_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();
                showFeedback();
            }
        });
        nav_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();
                showRecommend();
            }
        });
        nav_legal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();
                openLegalNotice();
            }
        });
        nav_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();

            }
        });
        nav_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();

            }
        });
        nav_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog.dismiss();
                showLogOut();
            }
        });
        dialog.show();
    }
    private void showLogOut(){
        dialog2.setContentView(R.layout.confirm_logout_dialog);
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog2.setCancelable(false);
        Button btnYes = dialog2.findViewById(R.id.btnYes);
        Button btnNo = dialog2.findViewById(R.id.btnNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog2.dismiss();
                Intent intent = new Intent(UserDashboard.this, SoilMonitoring.class);;
                startActivity(intent);
                Animatoo.animateSwipeRight(UserDashboard.this);
                finish();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog2.dismiss();
            }
        });
        dialog2.show();
    }
    private void showFeedback(){
        dialog2.setContentView(R.layout.feedback_dialog);
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog2.setCancelable(false);
        Button btnSubmit = dialog2.findViewById(R.id.btnSubmit);
        Button btnCancel = dialog2.findViewById(R.id.btnCancel);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog2.dismiss();
            }
        });
        dialog2.show();
    }
    private void showRecommend(){
        dialog2.setContentView(R.layout.recommend_dialog);
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog2.setCancelable(false);
        Button btnCopy = dialog2.findViewById(R.id.btnCopy);
        Button btnCancel = dialog2.findViewById(R.id.btnCancel);
        EditText editBox_des = dialog2.findViewById(R.id.editBox_des);
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                String link = editBox_des.getText().toString();
                showToast("Link copy to clipboard");

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(80);
                dialog2.dismiss();
            }
        });
        dialog2.show();
    }
    private void openNotification(){
        Intent intent = new Intent(UserDashboard.this, UserNotification.class);;
        startActivity(intent);
        Animatoo.animateSwipeLeft(UserDashboard.this);
        finish();
    }
    private void openHistory(){
        Intent intent = new Intent(UserDashboard.this, PredictionHistory.class);;
        startActivity(intent);
        Animatoo.animateSwipeLeft(UserDashboard.this);
        finish();
    }
    private void openCalendar(){
        Intent intent = new Intent(UserDashboard.this, CalendarPage.class);;
        startActivity(intent);
        Animatoo.animateSwipeLeft(UserDashboard.this);
        finish();
    }
    private void openCamera(){
        Intent intent = new Intent(UserDashboard.this, PlantDetector.class);;
        startActivity(intent);
        Animatoo.animateSwipeLeft(UserDashboard.this);
        finish();
    }
    private void openCrops(){
        Intent intent = new Intent(UserDashboard.this, CropsPage.class);;
        startActivity(intent);
        Animatoo.animateSwipeLeft(UserDashboard.this);
        finish();
    }
    private void openSoilMonitoring(){
        Intent intent = new Intent(UserDashboard.this, SoilMonitoring.class);;
        startActivity(intent);
        Animatoo.animateSwipeLeft(UserDashboard.this);
        finish();
    }

    private void openProfile(){
        Intent intent = new Intent(UserDashboard.this, UserProfile.class);;
        startActivity(intent);
        Animatoo.animateSwipeLeft(UserDashboard.this);
        finish();
    }
    private void openLegalNotice(){
        Intent intent = new Intent(UserDashboard.this, LegalNotice.class);;
        startActivity(intent);
        Animatoo.animateSwipeLeft(UserDashboard.this);
        finish();
    }


    private void showToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        showToast("Please press logout button");
    }
}