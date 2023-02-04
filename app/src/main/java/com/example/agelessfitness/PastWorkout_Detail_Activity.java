package com.example.agelessfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PastWorkout_Detail_Activity extends AppCompatActivity {

    private com.google.android.material.progressindicator.CircularProgressIndicator PI_calories;
    private TextView txtView_calories, txtView_pastWorkout, txtView_pastWorkoutTime;

    Intent intent;

    private String workout, time, calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_workout_detail);
        intent = getIntent();

        initWidget();

        getIntentData();

        initUI();
    }

    private void initUI() {

        txtView_calories.setText(calories + "\nKcal");
        txtView_pastWorkout.setText(workout);
        txtView_pastWorkoutTime.setText(time);
        PI_calories.setProgress((int) Double.parseDouble(calories));
    }

    private void getIntentData() {

        workout = intent.getStringExtra("Workout");
        time = intent.getStringExtra("Time");
        calories = intent.getStringExtra("Calories");

    }

    private void initWidget() {

        //com.google.android.material.progressindicator.CircularProgressIndicator
        PI_calories = findViewById(R.id.PI_calories);

        //TextView
        txtView_calories = findViewById(R.id.txtView_calories);
        txtView_pastWorkout = findViewById(R.id.txtView_pastWorkout);
        txtView_pastWorkoutTime = findViewById(R.id.txtView_pastWorkoutTime);
    }
}