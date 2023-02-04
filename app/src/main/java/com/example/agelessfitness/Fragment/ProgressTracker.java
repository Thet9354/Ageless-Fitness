package com.example.agelessfitness.Fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.agelessfitness.Adapter.WorkoutAdapter;
import com.example.agelessfitness.Database.WorkoutDatabaseHelper;
import com.example.agelessfitness.R;
import com.example.agelessfitness.posedetector.ChooserActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ProgressTracker extends Fragment {

    private Button btn_poseDetector;

    private androidx.recyclerview.widget.RecyclerView rv_pastProgress;

    ArrayList<String> workout, time, calories;
    WorkoutDatabaseHelper workoutDatabaseHelper;
    WorkoutAdapter workoutAdapter;


    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_progress_tracker, container, false);

        mContext = getActivity();

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    private void findViews(View v) {

        btn_poseDetector = v.findViewById(R.id.btn_poseDetector);

        rv_pastProgress = v.findViewById(R.id.rv_pastProgress);

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {
        btn_poseDetector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ChooserActivity.class));
            }
        });
    }

    private void initUI() {

        workoutDatabaseHelper = new WorkoutDatabaseHelper(mContext);
        workout = new ArrayList<>();
        time = new ArrayList<>();
        calories = new ArrayList<>();

        workoutAdapter = new WorkoutAdapter(mContext, workout, time, calories);
        rv_pastProgress.setAdapter(workoutAdapter);
        rv_pastProgress.setLayoutManager(new LinearLayoutManager(mContext));
        displayData();


    }

    private void displayData() {
        Cursor cursor = workoutDatabaseHelper.getAllData();
        if (cursor.getCount()==0)
        {
            Toast.makeText(mContext, "No existing workout record", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                workout.add(cursor.getString(1));
                time.add(cursor.getString(2));
                calories.add(cursor.getString(3));

            }
        }
    }
}