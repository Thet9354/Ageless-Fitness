package com.example.agelessfitness;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.Serializable;

public class Workout_Activity extends AppCompatActivity {

    private ImageView btn_back, imgView_wheelChair, btn_startWorkout;

    private CardView cv_armRaises, cv_sideTwist, cv_airplaneArms, cv_chestExpansions;

    private LinearLayout ll_armRaises, ll_armRaisesDemo, ll_sideTwistDemo, ll_airplaneArmsDemo, ll_chestExpansionsDemo;

    private String workouts = "Wheel-Chair Friendly Workout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Workout_Activity.this);
                builder.setTitle("Bluetooth Connection");
                builder.setMessage("Do you want to connect your Bluetooth?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), Bluetooth_Activity.class);
                        intent.putExtra("Workout", workouts);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), Workout_timer.class);
                        intent.putExtra("Workout", workouts);
                        startActivity(intent);
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        cv_armRaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                armRaisesExpand();
            }
        });

        cv_sideTwist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sideTwistExpand();
            }
        });

        cv_airplaneArms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                airplaneArmExpand();
            }
        });

        cv_chestExpansions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chestExpansionExpand();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void chestExpansionExpand() {

        int v = (ll_chestExpansionsDemo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_chestExpansionsDemo, new AutoTransition());
        ll_chestExpansionsDemo.setVisibility(v);
    }

    private void airplaneArmExpand() {

        int v = (ll_airplaneArmsDemo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_airplaneArmsDemo, new AutoTransition());
        ll_airplaneArmsDemo.setVisibility(v);
    }

    private void sideTwistExpand() {

        int v = (ll_sideTwistDemo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_sideTwistDemo, new AutoTransition());
        ll_sideTwistDemo.setVisibility(v);
    }

    private void armRaisesExpand() {
        int v = (ll_armRaisesDemo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_armRaisesDemo, new AutoTransition());
        ll_armRaisesDemo.setVisibility(v);
    }

    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);
        imgView_wheelChair = findViewById(R.id.imgView_wheelChair);
        btn_startWorkout = findViewById(R.id.btn_startWorkout);

        //CardView
        cv_armRaises = findViewById(R.id.cv_armRaises);
        cv_sideTwist = findViewById(R.id.cv_sideTwist);
        cv_airplaneArms = findViewById(R.id.cv_airplaneArms);
        cv_chestExpansions = findViewById(R.id.cv_chestExpansions);


        //LineaLayout
        ll_armRaisesDemo = findViewById(R.id.ll_armRaisesDemo);
        ll_sideTwistDemo = findViewById(R.id.ll_sideTwistDemo);
        ll_airplaneArmsDemo = findViewById(R.id.ll_airplaneArmsDemo);
        ll_chestExpansionsDemo = findViewById(R.id.ll_chestExpansionsDemo);



    }
}