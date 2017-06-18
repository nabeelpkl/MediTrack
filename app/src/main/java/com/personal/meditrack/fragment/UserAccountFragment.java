package com.personal.meditrack.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.personal.meditrack.R;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserAccountFragment extends Fragment
    implements UserMainFragment.OnFragmentInteractionListener,
    UserDetailsFragment.OnFragmentInteractionListener,
    AddMedicineFragment.OnFragmentInteractionListener,
    SOSSettingFragment.OnFragmentInteractionListener {

  private Fragment fragment;
  private FragmentManager fragmentManager;

  public static UserAccountFragment newInstance() {
    UserAccountFragment fragment = new UserAccountFragment();
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_user_account, container, false);
    fragmentManager = getChildFragmentManager();

    addFragment();
    return view;
  }

  void addFragment() {
    fragment = UserMainFragment.newInstance();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.add(R.id.user_main_container, fragment).commit();
  }

  void replaceFragment() {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.user_main_container, fragment);
    transaction.addToBackStack(null).commit();
  }

  void loadMainFragment() {
    fragment = UserMainFragment.newInstance();
    replaceFragment();
  }

  @Override public void onUserDetailsInteraction() {
    Timber.d("Clicked User Details");
    fragment = UserDetailsFragment.newInstance();
    replaceFragment();
  }

  @Override public void onAddMedicineInteraction() {
    Timber.d("Clicked Add Medicine");
    fragment = AddMedicineFragment.newInstance();
    replaceFragment();
  }

  @Override public void onSosSettingInteraction() {
    Timber.d("Clicked SOS Setting");
    fragment = SOSSettingFragment.newInstance();
    replaceFragment();
  }

  @Override public void onUserDetailsFinish() {
    loadMainFragment();
  }

  @Override public void onAddMedicinesFinish() {
    loadMainFragment();
  }

  @Override public void onSOSSettingsFinish() {
    loadMainFragment();
  }
}
