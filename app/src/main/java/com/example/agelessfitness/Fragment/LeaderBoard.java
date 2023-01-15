package com.example.agelessfitness.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.agelessfitness.Adapter.LeaderBoardAdapter;
import com.example.agelessfitness.Model.LeaderBoardModel;
import com.example.agelessfitness.R;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class LeaderBoard extends Fragment {

    private CalendarView cv_leaderBoard;
    private com.google.android.material.progressindicator.CircularProgressIndicator PI_calories;
    private TextView txtView_calories;

    private LeaderBoardAdapter leaderBoardAdapter;

    private final ArrayList<LeaderBoardModel> leaderBoardArrayList = new ArrayList<>();

    private Context mContext;

    int[] competitorPic = {R.drawable.john, R.drawable.omar, R.drawable.linda,
            R.drawable.img};

    int[] competitorProgressPic = {R.drawable.up, R.drawable.up, R.drawable.up,
            R.drawable.up};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_leader_board, container, false);

        mContext = getActivity();

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    private void findViews(View v) {

        //CalendarView
        cv_leaderBoard = v.findViewById(R.id.cv_leaderBoard);

        //CircularProgressIndicator
        PI_calories = v.findViewById(R.id.PI_calories);

        //TextView
        txtView_calories = v.findViewById(R.id.txtView_calories);


        initUI();
    }

    private void initUI() {

        showDialog();
    }

    private void showDialog() {

        final Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_layout);

        //TODO: Initialize the recylerView and put whatever happens to it over here

        RecyclerView rv_leaderBoard = dialog.findViewById(R.id.rv_leaderBoard);

        //for better performance of recyclerview.

//        int spaceInPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
//        rv_course.addItemDecoration(new SpaceItemDecoration(spaceInPixels));

        rv_leaderBoard.setHasFixedSize(true);

        leaderBoardAdapter = new LeaderBoardAdapter(getContext(), leaderBoardArrayList);
        rv_leaderBoard.setAdapter(leaderBoardAdapter);

        //layout to contain recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setSmoothScrollbarEnabled(true);
        // orientation of linearlayoutmanager.
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setAutoMeasureEnabled(true);

        //set layoutmanager for recyclerview.
        rv_leaderBoard.setLayoutManager(llm);

        LeaderBoardModel leaderBoardModel;

        String[] competitorName = getResources().getStringArray(R.array.competitor_name);
        String[] competitorDuration = getResources().getStringArray(R.array.competitor_duration);
        String[] competitorCalories = getResources().getStringArray(R.array.competitor_calories);


        for (int i = 0 ; i < competitorName.length; i++)
        {
            leaderBoardModel = new LeaderBoardModel();

            leaderBoardModel.setCompetitorName(competitorName[i]);
            leaderBoardModel.setCompetitorDuration(competitorDuration[i]);
            leaderBoardModel.setCompetitorCalories(competitorCalories[i]);

            leaderBoardModel.setCompetitorsImage(competitorPic[i]);
            leaderBoardModel.setCompetitorProgressImage(competitorProgressPic[i]);


            leaderBoardArrayList.add(leaderBoardModel);
            leaderBoardModel = null;
        }

        if (leaderBoardArrayList != null && leaderBoardArrayList.size() > 0) {
            leaderBoardAdapter = new LeaderBoardAdapter(mContext, leaderBoardArrayList);
            rv_leaderBoard.setAdapter(leaderBoardAdapter);
            leaderBoardAdapter.notifyDataSetChanged();
        }

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }



}