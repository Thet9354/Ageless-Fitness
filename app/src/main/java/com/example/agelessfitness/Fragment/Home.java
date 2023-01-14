package com.example.agelessfitness.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.agelessfitness.R;
import com.example.agelessfitness.Workout_Activity;


public class Home extends Fragment {

    private ImageView imgView_profile, btn_startWheelChair, btn_startLegStretches;

    private LinearLayout ll_wheelChair, ll_legStretches;

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

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

        //LinearLayout
        ll_wheelChair = v.findViewById(R.id.ll_wheelChair);
        ll_legStretches = v.findViewById(R.id.ll_legStretches);

        //Imageview
        imgView_profile = v.findViewById(R.id.imgView_profile);
        btn_startWheelChair = v.findViewById(R.id.btn_startWheelChair);
        btn_startLegStretches = v.findViewById(R.id.btn_startLegStretches);

        pageDirectories();
    }


    private void pageDirectories() {

        ll_wheelChair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, Workout_Activity.class));
            }
        });
    }
}