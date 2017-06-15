package com.personal.meditrack;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.personal.meditrack.fragment.MedicinesFragment;
import com.personal.meditrack.fragment.TodayMedsFragment;
import com.personal.meditrack.fragment.UserFragment;

public class HomeActivity extends AppCompatActivity {

  private TextView mTextMessage;
  private Fragment fragment;
  private FragmentManager fragmentManager;

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
      new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
          switch (item.getItemId()) {
            case R.id.navigation_home:
              fragment = TodayMedsFragment.newInstance();
              break;
            case R.id.navigation_medicine:
              fragment = MedicinesFragment.newInstance();
              break;
            case R.id.navigation_user:
              fragment = UserFragment.newInstance();
              break;
            default:
              fragment = TodayMedsFragment.newInstance();
              break;
          }
          setBottomNavigationFragment();
          return true;
        }
      };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    fragmentManager = getSupportFragmentManager();
    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    fragment = TodayMedsFragment.newInstance();
    setBottomNavigationFragment();
  }

  void setBottomNavigationFragment() {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.main_container, fragment).commit();
  }
}
