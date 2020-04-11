package com.example.gradingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mgr  = getSupportFragmentManager();
        FragmentTransaction  trans = mgr.beginTransaction();
        trans.replace(R.id.frame, new GradeEntry());
        trans.commit();

    }
}
