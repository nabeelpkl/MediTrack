package com.personal.meditrack.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import com.personal.meditrack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserMainFragment extends Fragment {

  private RelativeLayout userDetailsLayout;
  private LinearLayout addMedicineLayout;
  private LinearLayout sosSettingsLayout;
  private OnFragmentInteractionListener mListener;

  public static UserMainFragment newInstance() {
    UserMainFragment fragment = new UserMainFragment();
    return fragment;
  }

  public UserMainFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    onAttachToParentFragment(getParentFragment());
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_user_main, container, false);
    ButterKnife.bind(view, getActivity());
    userDetailsLayout = (RelativeLayout) view.findViewById(R.id.user_details_rl);
    addMedicineLayout = (LinearLayout) view.findViewById(R.id.add_medicine_ll);
    sosSettingsLayout = (LinearLayout) view.findViewById(R.id.sos_settings_ll);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    userDetailsLayout.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mListener.onUserDetailsInteraction();
      }
    });

    addMedicineLayout.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mListener.onAddMedicineInteraction();
      }
    });

    sosSettingsLayout.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mListener.onSosSettingInteraction();
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

  public interface OnFragmentInteractionListener {
    void onUserDetailsInteraction();

    void onAddMedicineInteraction();

    void onSosSettingInteraction();
  }
}
