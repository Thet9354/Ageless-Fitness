package com.example.agelessfitness.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

        ll_beatTheClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.webmd.com/diet/features/is-your-diet-aging-you";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ll_taiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://magazine.circledna.com/health-benefits-of-tai-chi/?utm_source=gdn&utm_medium=cpc&utm_campaign=yearofrabbit23&utm_format=banner&gclid=CjwKCAiAwomeBhBWEiwAM43YIAM_D4FWIunSWzeQfIkrlJuppVWfKZEKHDvgLiy50IOOJdWdD7cDfhoCJWcQAvD_BwE";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ll_running.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.yourcareeverywhere.com/life-stages/healthy-aging/the-health-benefits-of-running-for-seniors.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        btn_beatTheClock_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this cool ass NFT");
                intent.putExtra(Intent.EXTRA_TEXT, "https://www.webmd.com/diet/features/is-your-diet-aging-you");
                startActivity(Intent.createChooser(intent, "Share Via"));
            }
        });

        btn_taiChi_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this cool ass NFT");
                intent.putExtra(Intent.EXTRA_TEXT, "https://magazine.circledna.com/health-benefits-of-tai-chi/?utm_source=gdn&utm_medium=cpc&utm_campaign=yearofrabbit23&utm_format=banner&gclid=CjwKCAiAwomeBhBWEiwAM43YIAM_D4FWIunSWzeQfIkrlJuppVWfKZEKHDvgLiy50IOOJdWdD7cDfhoCJWcQAvD_BwE");
                startActivity(Intent.createChooser(intent, "Share Via"));
            }
        });

        btn_running_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this cool ass NFT");
                intent.putExtra(Intent.EXTRA_TEXT, "https://www.yourcareeverywhere.com/life-stages/healthy-aging/the-health-benefits-of-running-for-seniors.html");
                startActivity(Intent.createChooser(intent, "Share Via"));
            }
        });
    }
}