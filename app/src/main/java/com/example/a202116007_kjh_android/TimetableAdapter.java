package com.example.a202116007_kjh_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a202116007_kjh_android.BusSchedule;
import com.example.a202116007_kjh_android.R;

import java.util.List;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.TimetableViewHolder> {

    private final List<BusSchedule> schedules;

    public TimetableAdapter(List<BusSchedule> schedules) {
        this.schedules = schedules;
    }

    @NonNull
    @Override
    public TimetableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_timetable, parent, false);
        return new TimetableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimetableViewHolder holder, int position) {
        BusSchedule schedule = schedules.get(position);
        holder.textViewTime.setText(schedule.getTime());
        holder.textViewLocation.setText(schedule.getLocation());
        holder.textViewBus.setText(schedule.getBus());
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public static class TimetableViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTime, textViewLocation, textViewBus;

        public TimetableViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewLocation = itemView.findViewById(R.id.textViewLocation);
            textViewBus = itemView.findViewById(R.id.textViewBus);
        }
    }
}
