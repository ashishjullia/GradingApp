package com.example.gradingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;

public class GradeEntry extends Fragment {

    String stringCredit, stringCourse, stringFirstName, stringLastName, stringMarks;

    EditText firstName, lastName, marks;
    RadioGroup groupCredits;
    RadioButton buttonCreditOne, buttonCreditTwo, buttonCreditThree, buttonCreditFour, buttonCourseOne, buttonCourseTwo, buttonCourseThree, buttonCourseFour;
    Button buttonSubmit;

    public GradeEntry() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade_entry, container, false);

        firstName = view.findViewById(R.id.editFirstName);
        lastName = view.findViewById(R.id.editLastName);
        marks = view.findViewById(R.id.editMarks);

        buttonCreditOne = view.findViewById(R.id.radioButtonCreditOne);
        buttonCreditTwo = view.findViewById(R.id.radioButtonCreditTwo);
        buttonCreditThree = view.findViewById(R.id.radioButtonCreditThree);
        buttonCreditFour = view.findViewById(R.id.radioButtonCreditFour);

        buttonCourseOne = view.findViewById(R.id.radioButtonCourseOne);
        buttonCourseTwo = view.findViewById(R.id.radioButtonCourseTwo);
        buttonCourseThree = view.findViewById(R.id.radioButtonCourseThree);
        buttonCourseFour = view.findViewById(R.id.radioButtonCourseFour);

        buttonSubmit = view.findViewById(R.id.btnSubmit);

        stringFirstName = firstName.getText().toString();
        stringLastName = lastName.getText().toString();
        stringMarks = marks.getText().toString();

        if (buttonCourseOne.isChecked()) {
            stringCourse = buttonCourseOne.getText().toString();
        } else if (buttonCourseTwo.isChecked()) {
            stringCourse = buttonCourseTwo.getText().toString();
        } else if (buttonCourseThree.isChecked()) {
            stringCourse = buttonCourseThree.getText().toString();
        } else if (buttonCourseFour.isChecked()) {
            stringCourse = buttonCourseFour.getText().toString();
        }

        if (buttonCreditOne.isChecked()) {
            stringCredit = buttonCreditOne.getText().toString();
        } else if (buttonCreditTwo.isChecked()) {
            stringCredit = buttonCreditTwo.getText().toString();
        } else if (buttonCreditThree.isChecked()) {
            stringCredit = buttonCreditThree.getText().toString();
        } else if (buttonCreditFour.isChecked()) {
            stringCredit = buttonCreditFour.getText().toString();
        }

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            } });

        // Inflate the layout for this fragment
        return view;
    }
}
