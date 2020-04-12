package com.example.gradingapp;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends Fragment {

    EditText editTextSearchIdUpdate;
    EditText edtTextResultId, edtTextResultFirstName, edtTextResultLastName, edtTextResultCourse, edtTextResultCredits, edtTextResultMarks;

    Button buttonSearchIdUpdate, buttonResultEditSubmit;

    String stringSearchId;

    DatabaseHelper dbh;

    public Update() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        editTextSearchIdUpdate = view.findViewById(R.id.editSearchIdUpdate);
        buttonSearchIdUpdate = view.findViewById(R.id.btnSearchIdUpdate);

        edtTextResultId = view.findViewById(R.id.editTextResultId);
        edtTextResultFirstName = view.findViewById(R.id.editTextFirstName);
        edtTextResultLastName = view.findViewById(R.id.editTextResultLastName);
        edtTextResultCourse = view.findViewById(R.id.editTextResultCourse);
        edtTextResultCredits = view.findViewById(R.id.editTextResultCredits);
        edtTextResultMarks = view.findViewById(R.id.editTextResultMarks);

        buttonResultEditSubmit = view.findViewById(R.id.btnResultEditSubmit);

        buttonSearchIdUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new DatabaseHelper(getActivity());
                stringSearchId = editTextSearchIdUpdate.getText().toString();
                Cursor cursor = dbh.searchGrade("id", stringSearchId);

                if (cursor == null) {
                    Toast.makeText(getContext(), "No Record!", Toast.LENGTH_SHORT).show();
                } else {
                    if (cursor.moveToFirst()) {
                        do {
                            edtTextResultId.setText(cursor.getString(cursor.getColumnIndex("id")));
                            edtTextResultFirstName.setText(cursor.getString(cursor.getColumnIndex("firstName")));
                            edtTextResultLastName.setText(cursor.getString(cursor.getColumnIndex("lastName")));
                            edtTextResultCourse.setText(cursor.getString(cursor.getColumnIndex("course")));
                            edtTextResultCredits.setText(cursor.getString(cursor.getColumnIndex("credits")));
                            edtTextResultMarks.setText(cursor.getString(cursor.getColumnIndex("marks")));
                        } while (cursor.moveToNext());
                    }
                    cursor.close();
                    dbh.close();
                    }
                }
            }
        );

        buttonResultEditSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new DatabaseHelper(getActivity());
                if (edtTextResultFirstName.getText() == null && edtTextResultLastName.getText() == null && edtTextResultCourse.getText() == null && edtTextResultCredits.getText() == null && edtTextResultMarks.getText() == null) {
                    Toast.makeText(getActivity(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    GradeClass gradeObject = new GradeClass();
                    gradeObject.setGradeId(Integer.parseInt(edtTextResultId.getText().toString()));
                    gradeObject.setGradeFirstName(edtTextResultFirstName.getText().toString());
                    gradeObject.setGradeLastName(edtTextResultLastName.getText().toString());
                    gradeObject.setGradeCourse(edtTextResultCourse.getText().toString());
                    gradeObject.setGradeCredits(edtTextResultCredits.getText().toString());
                    gradeObject.setGradeMarks(edtTextResultMarks.getText().toString());
                    int numRowsUpdated = dbh.updateGrade(gradeObject);
                    if (numRowsUpdated > 0) {
                        Toast.makeText(getActivity(), "Record Update Success!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Record Update Failed!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        return view;
    }
}
