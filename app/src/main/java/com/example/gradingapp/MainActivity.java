package com.example.gradingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Drawer  and toggle
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setNavigationDrawer();

        FragmentManager mgr  = getSupportFragmentManager();
        FragmentTransaction  trans = mgr.beginTransaction();
        trans.replace(R.id.frame, new GradeEntry());
        trans.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setNavigationDrawer() {
        NavigationView navView = findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment frag = null;

                int itemId = menuItem.getItemId();

                if (itemId == R.id.nav_grade_entry) {
                    frag = new GradeEntry();
                } else if (itemId == R.id.nav_view_grades) {
                    //frag = new ViewGrades();
                } else if (itemId == R.id.nav_search) {
                    //frag = new Search();
                } else if (itemId == R.id.nav_update) {
                    //frag = new Update();
                } else if (itemId == R.id.nav_delete) {
                    //frag = new Delete();
                }

                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag);
                    transaction.commit();
                    mDrawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }
}
