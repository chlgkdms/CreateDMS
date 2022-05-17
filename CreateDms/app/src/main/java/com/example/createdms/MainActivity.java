package com.example.createdms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentSchoolLunch fragmentSchoolLunch = new FragmentSchoolLunch();
    private FragmentApplication fragmentApplication = new FragmentApplication();
    private FragmentNotice fragmentNotice = new FragmentNotice();
    private FragmentMyPage fragmentMyPage = new FragmentMyPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int id = item.getItemId();

                switch (id) {
                    case R.id.menu_sl:
                        transaction.replace(R.id.menu_frame_layout, fragmentSchoolLunch).commitAllowingStateLoss();
                        break;
                    case R.id.menu_application:
                        transaction.replace(R.id.menu_frame_layout, fragmentApplication).commitAllowingStateLoss();
                        break;
                    case R.id.menu_notice:
                        transaction.replace(R.id.menu_frame_layout, fragmentNotice).commitAllowingStateLoss();
                        break;
                    case R.id.menu_myPage:
                        transaction.replace(R.id.menu_frame_layout, fragmentMyPage).commitAllowingStateLoss();
                        break;
                }

                return true;
            }
        });
    }
}