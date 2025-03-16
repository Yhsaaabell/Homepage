package com.example.plantafarm;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

public class CalendarPage extends AppCompatActivity {
    ImageView btnBack;
    Vibrator vibrator;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.lt));
        setContentView(R.layout.calendar_page_layout);

        btnBack = findViewById(R.id.btnBack);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        dialog = new Dialog(this);

        MaterialCalendarView calendarView = findViewById(R.id.calendarView);

        // Set the current month and year
        calendarView.setSelectedDate(CalendarDay.today());

        // Highlight specific dates
        calendarView.addDecorator(new EventDecorator(Color.BLACK,
                CalendarDay.from(2025, 0, 14),
                CalendarDay.from(2025, 0, 31)));

        // Change theme colors
        calendarView.setSelectionColor(Color.parseColor("#008000"));
        // Change Month Header Color
        calendarView.setHeaderTextAppearance(R.style.CustomCalendarHeader);

// Change Weekday Labels Color
        calendarView.setWeekDayTextAppearance(R.style.CustomWeekDayLabel);


        btnBack.setOnClickListener(v -> {
            vibrator.vibrate(80);
            returnHome();
        });
    }

    public class EventDecorator implements DayViewDecorator {
        private final int color;
        private final CalendarDay[] dates;

        public EventDecorator(int color, CalendarDay... dates) {
            this.color = color;
            this.dates = dates;
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            for (CalendarDay d : dates) {
                if (day.equals(d)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new DotSpan(8, color)); // Adds a dot below the date
        }
    }

    private void returnHome() {
        Intent intent = new Intent(CalendarPage.this, UserDashboard.class);
        startActivity(intent);
        Animatoo.animateSwipeRight(CalendarPage.this);
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        returnHome();
    }
}
