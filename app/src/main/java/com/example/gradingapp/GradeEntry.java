package com.example.gradingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Button;


public class GradeEntry extends Fragment {

    private String stringCredit, stringFirstName, stringLastName, stringMarks, StringTheCourse;

    private EditText firstName, lastName, marks;
    private RadioButton buttonCreditOne, buttonCreditTwo, buttonCreditThree, buttonCreditFour;
    private Button buttonSubmit;

    private ListView lstViewCourses;
    private ArrayAdapter<String> adptCourses;
    private String[] courses = {"PROG 8480", "PROG 8470", "PROG 8460", "PROG 8450"};

    public GradeEntry() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade_entry, container, false);

        lstViewCourses = view.findViewById(R.id.listCourses);
        adptCourses = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, courses);
        lstViewCourses.setAdapter(adptCourses);

        lstViewCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                StringTheCourse = lstViewCourses.getItemAtPosition(position).toString();
            }
        });

        firstName = view.findViewById(R.id.editFirstName);
        firstName.requestFocus();
        lastName = view.findViewById(R.id.editLastName);
        marks = view.findViewById(R.id.editMarks);

        buttonCreditOne = view.findViewById(R.id.radioButtonCreditOne);
        buttonCreditTwo = view.findViewById(R.id.radioButtonCreditTwo);
        buttonCreditThree = view.findViewById(R.id.radioButtonCreditThree);
        buttonCreditFour = view.findViewById(R.id.radioButtonCreditFour);

        buttonSubmit = view.findViewById(R.id.btnSubmit);

        stringFirstName = firstName.getText().toString();
        stringLastName = lastName.getText().toString();
        stringMarks = marks.getText().toString();

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
