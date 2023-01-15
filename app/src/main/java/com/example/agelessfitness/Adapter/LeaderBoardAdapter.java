package com.example.agelessfitness.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agelessfitness.Model.LeaderBoardModel;
import com.example.agelessfitness.R;

import java.util.ArrayList;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.CardViewHolder>{

    private ArrayList<LeaderBoardModel> leaderBoardArrayList;
    private Context mContext;

    public LeaderBoardAdapter(Context mContext, ArrayList<LeaderBoardModel> leaderBoardArrayList) {
        this.leaderBoardArrayList = leaderBoardArrayList;
        this.mContext = mContext;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private LeaderBoardAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(LeaderBoardAdapter.OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @NonNull
    @Override
    public LeaderBoardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = LayoutInflater.from(context).
                inflate(R.layout.row_leaderboard, parent, false);

        return new LeaderBoardAdapter.CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderBoardAdapter.CardViewHolder holder, int position) {

        holder.txtView_competitorName.setText(leaderBoardArrayList.get(position).getCompetitorName());
        holder.txtView_competitorCalories.setText(leaderBoardArrayList.get(position).getCompetitorCalories());
        holder.txtView_competitorDuration.setText(leaderBoardArrayList.get(position).getCompetitorDuration());

        holder.imgView_competitor.setImageResource(leaderBoardArrayList.get(position).getCompetitorsImage());
        holder.imgView_competitorProgress.setImageResource(leaderBoardArrayList.get(position).getCompetitorProgressImage());
    }

    @Override
    public int getItemCount() {
        return leaderBoardArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgView_competitor, imgView_competitorProgress;
        private TextView txtView_competitorName, txtView_competitorDuration, txtView_competitorCalories;
        private CardView cv_leaderBoard;
        private LinearLayout ll_leaderBoard;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            //ImageView
            imgView_competitor = itemView.findViewById(R.id.imgView_competitor);
            imgView_competitorProgress = itemView.findViewById(R.id.imgView_competitorProgress);

            //TextView
            txtView_competitorName = itemView.findViewById(R.id.txtView_competitorName);
            txtView_competitorDuration = itemView.findViewById(R.id.txtView_competitorDuration);
            txtView_competitorCalories = itemView.findViewById(R.id.txtView_competitorCalories);

            //CardView
            cv_leaderBoard = itemView.findViewById(R.id.cv_leaderBoard);

            //LinearLayout
            ll_leaderBoard = itemView.findViewById(R.id.ll_leaderBoard);

        }
    }
}
