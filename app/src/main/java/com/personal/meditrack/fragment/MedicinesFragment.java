package com.personal.meditrack.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.personal.meditrack.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MedicinesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicinesFragment extends Fragment {


  public MedicinesFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @return A new instance of fragment MedicinesFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static MedicinesFragment newInstance() {
    MedicinesFragment fragment = new MedicinesFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_medicines, container, false);
  }
}
