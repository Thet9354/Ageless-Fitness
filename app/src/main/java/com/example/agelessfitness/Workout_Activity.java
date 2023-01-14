package com.example.agelessfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Workout_Activity extends AppCompatActivity {

    private ImageView btn_back;

    private CardView cv_armRaises, cv_sideTwist, cv_airplaneArms, cv_chestExpansions;

    private LinearLayout ll_armRaises, ll_armRaisesDemo, ll_sideTwistDemo, ll_airplaneArmsDemo, ll_chestExpansionsDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        initWidget();



        pageDirectories();
    }

    private void pageDirectories() {

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