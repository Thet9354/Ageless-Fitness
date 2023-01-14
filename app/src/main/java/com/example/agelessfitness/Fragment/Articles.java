package com.example.agelessfitness.Fragment;

import android.content.Context;
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

public class Articles extends Fragment {

    private LinearLayout ll_beatTheClock, ll_taiChi, ll_running;

    private ImageView btn_beatTheClock_share, btn_taiChi_share, btn_running_share;

    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_articles, container, false);

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
        ll_beatTheClock = v.findViewById(R.id.ll_beatTheClock);
        ll_taiChi = v.findViewById(R.id.ll_taiChi);
        ll_running = v.findViewById(R.id.ll_running);


        //Imageview
        btn_beatTheClock_share = v.findViewById(R.id.btn_beatTheClock_share);
        btn_taiChi_share = v.findViewById(R.id.btn_taiChi_share);
        btn_running_share = v.findViewById(R.id.btn_running_share);

        pageDirectories();
    }

    private void pageDirectories() {

    }
}