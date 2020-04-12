package com.example.gradingapp;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Delete extends Fragment {

    TextView txtViewId, txtViewFirstName, txtViewLastName, txtViewCourse, txtViewCredits, txtViewMarks;
    EditText edtTextSearchIdDelete;
    Button buttonSearch, buttonDelete;

    String stringSearchId;

    DatabaseHelper dbh;

    public Delete() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        buttonSearch = view.findViewById(R.id.btnSearchIdDelete);
        buttonDelete = view.findViewById(R.id.btnDelete);

        txtViewId = view.findViewById(R.id.textViewId);
        txtViewFirstName = view.findViewById(R.id.textViewFirstName);
        txtViewLastName = view.findViewById(R.id.textViewLastName);
        txtViewCourse = view.findViewById(R.id.textViewCourse);
        txtViewCredits = view.findViewById(R.id.textViewCredits);
        txtViewMarks = view.findViewById(R.id.textViewMarks);

        edtTextSearchIdDelete = view.findViewById(R.id.editSearchIdDelete);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new DatabaseHelper(getActivity());
                stringSearchId = edtTextSearchIdDelete.getText().toString();
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
    });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new DatabaseHelper(getActivity());
                stringSearchId = edtTextSearchIdDelete.getText().toString();
                int numRowAffected = dbh.deleteRecord(Integer.parseInt(stringSearchId));

                if (numRowAffected > 0) {
                    Toast.makeText(getContext(), "Record Deleted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Cannot Delete the Record!", Toast.LENGTH_SHORT).show();
                }
                }
        });

        return view;
    }
}
