package com.example.gradingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GradeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GradeClass> mList;
    public GradeListAdapter (List<GradeClass> list, Context context) {
        super();
        mList = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextId, mTextFirstName, mTextLastName, mTextCourse, mTextCredits, mTextMarks;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextId = itemView.findViewById(R.id.textViewId);
            mTextFirstName = itemView.findViewById(R.id.textViewFirstName);
            mTextLastName = itemView.findViewById(R.id.textViewLastName);
            mTextCourse = itemView.findViewById(R.id.textViewCourse);
            mTextCredits = itemView.findViewById(R.id.textViewCredits);
            mTextMarks = itemView.findViewById(R.id.textViewMarks);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        GradeClass gradeAdapter = mList.get(position);
        ((ViewHolder) viewHolder).mTextId.setText(Integer.toString(gradeAdapter.getGradeId()));
        ((ViewHolder) viewHolder).mTextFirstName.setText(gradeAdapter.getGradeFirstName());
        ((ViewHolder) viewHolder).mTextLastName.setText(gradeAdapter.getGradeLastName());
        ((ViewHolder) viewHolder).mTextCourse.setText(gradeAdapter.getGradeCourse());
        ((ViewHolder) viewHolder).mTextCredits.setText(gradeAdapter.getGradeCredits());
        ((ViewHolder) viewHolder).mTextMarks.setText(gradeAdapter.getGradeMarks());
    }

    @Override
    public int getItemCount() { return mList.size(); }

}
