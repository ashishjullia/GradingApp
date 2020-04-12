package com.example.gradingapp;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends Fragment {

    RadioGroup groupSearchRecord;
    RadioButton radioButtonSearchId, radioButtonSearchProgramCode;

    TextView txtViewId, txtViewFirstName, txtViewLastName, txtViewCourse, txtViewCredits, txtViewMarks;
    LinearLayout layoutSearchById, layoutSearchByProgramCode;
    Button submitButtonSearchId, submitButtonSearchProgramCode;

    String stringSearchId, stringSearchProgramCode;

    EditText editSearchIdValue, editSearchProgramCodeValue;

    DatabaseHelper dbh;

    public Search() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search, container, false);

        groupSearchRecord = view.findViewById(R.id.radioGroupSearchRecord);
        radioButtonSearchId = view.findViewById(R.id.radioButtonSearchById);
        radioButtonSearchProgramCode = view.findViewById(R.id.radioButtonSearchByProgramCode);

        layoutSearchById = view.findViewById(R.id.linearLayoutSearchById);
        layoutSearchByProgramCode = view.findViewById(R.id.linearLayoutSearchByProgramCode);

        txtViewId = view.findViewById(R.id.textViewId);
        txtViewFirstName = view.findViewById(R.id.textViewFirstName);
        txtViewLastName = view.findViewById(R.id.textViewLastName);
        txtViewCourse = view.findViewById(R.id.textViewCourse);
        txtViewCredits = view.findViewById(R.id.textViewCredits);
        txtViewMarks = view.findViewById(R.id.textViewMarks);

        editSearchIdValue = view.findViewById(R.id.editSearchId);
        editSearchProgramCodeValue = view.findViewById(R.id.editSearchProgramCode);

        groupSearchRecord.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = view.findViewById(checkedId);
                if (rb.getId() == R.id.radioButtonSearchById) {
                    // stringSearchId = editSearchIdValue.getText().toString();
                    layoutSearchById.setVisibility(View.VISIBLE);
                    layoutSearchByProgramCode.setVisibility(View.GONE);
                } else if (rb.getId() == R.id.radioButtonSearchByProgramCode) {
                    // stringSearchProgramCode = editSearchProgramCodeValue.getText().toString();
                    layoutSearchByProgramCode.setVisibility(View.VISIBLE);
                    layoutSearchById.setVisibility(View.GONE);
                }
            }
        });

        submitButtonSearchId = view.findViewById(R.id.btnSearchId);
        submitButtonSearchProgramCode = view.findViewById(R.id.btnSearchProgramCode);

        submitButtonSearchId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new DatabaseHelper(getActivity());
                stringSearchId = editSearchIdValue.getText().toString();
                Cursor cursor = dbh.searchGrade("id", stringSearchId);

                if (cursor == null) {
                    Toast.makeText(getContext(), "No Record!", Toast.LENGTH_SHORT).show();
                } else {
                    if (cursor.moveToFirst()) {
                        do {
                            txtViewId.setText(cursor.getString(cursor.getColumnIndex("id")));
                            txtViewFirstName.setText(cursor.getString(cursor.getColumnIndex("firstName")));
                            txtViewLastName.setText(cursor.getString(cursor.getColumnIndex("lastName")));
                            txtViewCourse.setText(cursor.getString(cursor.getColumnIndex("course")));
                            txtViewCredits.setText(cursor.getString(cursor.getColumnIndex("credits")));
                            txtViewMarks.setText(cursor.getString(cursor.getColumnIndex("marks")));
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                    dbh.close();
                }
            }
        }
        );

        submitButtonSearchProgramCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new DatabaseHelper(getActivity());
                stringSearchProgramCode = editSearchProgramCodeValue.getText().toString();
                Cursor cursor = dbh.searchGrade("course", stringSearchProgramCode);
                if (cursor == null) {
                    Toast.makeText(getContext(), "No Record!", Toast.LENGTH_SHORT).show();
                } else {
                    if (cursor.moveToFirst()) {
                        do {
                            txtViewId.setText(cursor.getString(cursor.getColumnIndex("id")));
                            txtViewFirstName.setText(cursor.getString(cursor.getColumnIndex("firstName")));
                            txtViewLastName.setText(cursor.getString(cursor.getColumnIndex("lastName")));
                            txtViewCourse.setText(cursor.getString(cursor.getColumnIndex("course")));
                            txtViewCredits.setText(cursor.getString(cursor.getColumnIndex("credits")));
                            txtViewMarks.setText(cursor.getString(cursor.getColumnIndex("marks")));
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                    dbh.close();
                 }
                }
            }
        );

        // Inflate the layout for this fragment
        return view;
    }
}
