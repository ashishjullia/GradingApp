package com.example.gradingapp;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewGrades extends Fragment {

    private RecyclerView mRecyclerview;
    private List<GradeClass> mList = new ArrayList<>();
    private GradeListAdapter mAdapter;
    DatabaseHelper dbh;

    public ViewGrades() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_grades, container, false);

        mRecyclerview = view.findViewById(R.id.recyclerView);

        dbh = new DatabaseHelper(getActivity());
        Cursor cursor = dbh.viewData();

        if (cursor == null) {
            Toast.makeText(getContext(), "No Record!", Toast.LENGTH_SHORT).show();
            return view;
        } else {
            if (cursor.moveToFirst()) {
                do {
                    GradeClass gradeObj = new GradeClass();
                    gradeObj.setGradeId(cursor.getInt(cursor.getColumnIndex("id")));
                    gradeObj.setGradeFirstName(cursor.getString(cursor.getColumnIndex("firstName")));
                    gradeObj.setGradeLastName(cursor.getString(cursor.getColumnIndex("lastName")));
                    gradeObj.setGradeCourse(cursor.getString(cursor.getColumnIndex("course")));
                    gradeObj.setGradeCredits(cursor.getString(cursor.getColumnIndex("credits")));
                    gradeObj.setGradeMarks(cursor.getString(cursor.getColumnIndex("marks")));
                    mList.add(gradeObj);
                } while (cursor.moveToNext());
            }
            cursor.close();
            dbh.close();
            bindAdapter();
            return view;
        }
        //return view;
    }

    private void bindAdapter() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerview.setLayoutManager(layoutManager);
        mAdapter = new GradeListAdapter(mList, getContext());
        mRecyclerview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
