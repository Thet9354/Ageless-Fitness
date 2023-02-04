package com.example.agelessfitness.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agelessfitness.PastWorkout_Detail_Activity;
import com.example.agelessfitness.R;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {

    private Context context;
    private ArrayList workout, time, calories;

    public WorkoutAdapter(Context context, ArrayList workout, ArrayList time, ArrayList calories) {
        this.context = context;
        this.workout = workout;
        this.time = time;
        this.calories = calories;
    }

    @NonNull
    @Override
    public WorkoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_workout, parent, false);

        return new WorkoutAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.ViewHolder holder, int position) {

        holder.txtView_workout.setText(String.valueOf(workout.get(position)));
        holder.txtView_time.setText(String.valueOf(time.get(position)));
        holder.txtView_calories.setText(String.valueOf(calories.get(position)));

        holder.cv_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PastWorkout_Detail_Activity.class);
                int pos = holder.getAbsoluteAdapterPosition();

                intent.putExtra("Workout", workout.get(pos).toString());
                intent.putExtra("Time", time.get(pos).toString());
                intent.putExtra("Calories", calories.get(pos).toString());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return workout.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtView_workout, txtView_time, txtView_calories;

        androidx.cardview.widget.CardView cv_workout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtView_workout = itemView.findViewById(R.id.txtView_workout);
            txtView_time = itemView.findViewById(R.id.txtView_time);
            txtView_calories = itemView.findViewById(R.id.txtView_calories);

            cv_workout = itemView.findViewById(R.id.cv_workout);
        }
    }
}
