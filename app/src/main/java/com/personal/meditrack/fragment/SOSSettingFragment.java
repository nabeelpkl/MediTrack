package com.personal.meditrack.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.personal.meditrack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SOSSettingFragment extends Fragment {
  Button saveButton;
  Button cancelButton;
  EditText sosNameET;
  EditText phoneNumberET;
  OnFragmentInteractionListener mListener;

  public static SOSSettingFragment newInstance() {
    SOSSettingFragment fragment = new SOSSettingFragment();
    return fragment;
  }

  public SOSSettingFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    onAttachToParentFragment(getParentFragment());
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_sossetting, container, false);
    saveButton = (Button) view.findViewById(R.id.save_button);
    cancelButton = (Button) view.findViewById(R.id.cancel_button);
    sosNameET = (EditText) view.findViewById(R.id.sos_name_et);
    phoneNumberET = (EditText) view.findViewById(R.id.phone_number_et);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        saveData("","");
        mListener.onSOSSettingsFinish();
      }
    });
    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mListener.onSOSSettingsFinish();

      }
    });
  }

  public void onAttachToParentFragment(Fragment fragment) {
    try {
      mListener = (OnFragmentInteractionListener) fragment;
    } catch (ClassCastException e) {
      throw new ClassCastException(
          fragment.toString() + " must implement OnFragmentInteractionListener");
    }
  }

  private void saveData(String name, String phone) {

  }

  public interface OnFragmentInteractionListener {
    void onSOSSettingsFinish();
  }
}
