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
public class UserDetailsFragment extends Fragment {

  Button saveButton;
  Button cancelButton;
  EditText userNameET;
  EditText ageET;
  OnFragmentInteractionListener mListener;

  public static UserDetailsFragment newInstance() {
    UserDetailsFragment fragment = new UserDetailsFragment();
    return fragment;
  }

  public UserDetailsFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    onAttachToParentFragment(getParentFragment());
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_user_details, container, false);
    saveButton = (Button) view.findViewById(R.id.save_button);
    cancelButton = (Button) view.findViewById(R.id.cancel_button);
    userNameET = (EditText) view.findViewById(R.id.user_name_et);
    ageET = (EditText) view.findViewById(R.id.age_et);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        saveData(userNameET.getText().toString(), ageET.getText().toString());
        mListener.onUserDetailsFinish();
      }
    });

    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mListener.onUserDetailsFinish();
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

  private void saveData(String userName, String age) {

  }

  public interface OnFragmentInteractionListener {
    void onUserDetailsFinish();
  }
}
