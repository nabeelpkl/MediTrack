package com.personal.meditrack.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.personal.meditrack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @return A new instance of fragment UserFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static UserFragment newInstance() {
    UserFragment fragment = new UserFragment();
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_user, container, false);
  }
}
