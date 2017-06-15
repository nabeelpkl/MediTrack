package com.personal.meditrack.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.personal.meditrack.R;
import com.personal.meditrack.adapter.TodaysMedListAdapter;
import com.personal.meditrack.model.Medicine;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TodayMedsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TodayMedsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodayMedsFragment extends Fragment {
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;
  RecyclerView medRecyclerView;

  private OnFragmentInteractionListener mListener;
  private TodaysMedListAdapter medListAdapter;

  public TodayMedsFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @return A new instance of fragment TodayMedsFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static TodayMedsFragment newInstance(/*String param1, String param2*/) {
    TodayMedsFragment fragment = new TodayMedsFragment();
    //Bundle args = new Bundle();
    //args.putString(ARG_PARAM1, param1);
    //args.putString(ARG_PARAM2, param2);
    //fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_today_meds, container, false);
    medRecyclerView = (RecyclerView) view.findViewById(R.id.todays_med_list);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    medListAdapter = new TodaysMedListAdapter(this.getActivity(), getMedList());

    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
    medRecyclerView.setLayoutManager(mLayoutManager);
    medRecyclerView.setItemAnimator(new DefaultItemAnimator());
    medRecyclerView.setAdapter(medListAdapter);
  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

  /* @Override public void onAttach(Context context) {
     super.onAttach(context);
     if (context instanceof OnFragmentInteractionListener) {
       mListener = (OnFragmentInteractionListener) context;
     } else {
       throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
     }
   }
 */
  @Override public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }

  private List<Medicine> getMedList() {
    List<Medicine> medicineList = new ArrayList<Medicine>();
    medicineList.add(new Medicine("Paracetamol", 1, 3, true, new ArrayList<Date>(), 15));
    medicineList.add(new Medicine("Gluco redfort", 1, 2, true, new ArrayList<Date>(), 15));
    medicineList.add(new Medicine("Entacin", 1, 3, true, new ArrayList<Date>(), 15));
    medicineList.add(new Medicine("Glucose", 1, 4, true, new ArrayList<Date>(), 15));
    return medicineList;
  }
}
