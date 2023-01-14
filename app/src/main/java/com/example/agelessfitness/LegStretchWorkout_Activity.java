package com.example.agelessfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LegStretchWorkout_Activity extends AppCompatActivity {

    private ImageView btn_back;

    private CardView cv_hamstringStretch, cv_quadStretch, cv_calfStretch, cv_innerThighStretch;

    private LinearLayout ll_hamstringStretchDemo, ll_quadStretchDemo, ll_calfStretchDemo, ll_innerThighStretchDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_stretch_workout);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        cv_hamstringStretch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hamstringExpand();
            }
        });

        cv_quadStretch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quadStretchExpand();
            }
        });

        cv_calfStretch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calfStretchExpand();
            }
        });

        cv_innerThighStretch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                innerThighExpand();
            }
        });
    }

    private void innerThighExpand() {

        int v = (ll_innerThighStretchDemo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_innerThighStretchDemo, new AutoTransition());
        ll_innerThighStretchDemo.setVisibility(v);
    }

    private void calfStretchExpand() {

        int v = (ll_calfStretchDemo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_calfStretchDemo, new AutoTransition());
        ll_calfStretchDemo.setVisibility(v);
    }

    private void quadStretchExpand() {

        int v = (ll_quadStretchDemo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_quadStretchDemo, new AutoTransition());
        ll_quadStretchDemo.setVisibility(v);
    }

    private void hamstringExpand() {

        int v = (ll_hamstringStretchDemo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(ll_hamstringStretchDemo, new AutoTransition());
        ll_hamstringStretchDemo.setVisibility(v);
    }

    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);

        //CardView
        cv_hamstringStretch = findViewById(R.id.cv_hamstringStretch);
        cv_quadStretch = findViewById(R.id.cv_quadStretch);
        cv_calfStretch = findViewById(R.id.cv_calfStretch);
        cv_innerThighStretch = findViewById(R.id.cv_innerThighStretch);

        //LinearLayout
        ll_hamstringStretchDemo = findViewById(R.id.ll_hamstringStretchDemo);
        ll_quadStretchDemo = findViewById(R.id.ll_quadStretchDemo);
        ll_calfStretchDemo = findViewById(R.id.ll_calfStretchDemo);
        ll_innerThighStretchDemo = findViewById(R.id.ll_innerThighStretchDemo);


    }
}