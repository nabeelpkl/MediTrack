package com.personal.meditrack.fragment;

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
import com.personal.meditrack.adapter.MedicineListAdapter;
import com.personal.meditrack.model.Medicine;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MedicinesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicinesFragment extends Fragment {
  private RecyclerView medRecyclerView;
  private MedicineListAdapter medListAdapter;

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

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_medicines, container, false);
    medRecyclerView = (RecyclerView) view.findViewById(R.id.medicines_list);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    medListAdapter = new MedicineListAdapter(this.getActivity(), getMedList());

    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
    medRecyclerView.setLayoutManager(mLayoutManager);
    medRecyclerView.setItemAnimator(new DefaultItemAnimator());
    medRecyclerView.setAdapter(medListAdapter);
  }

  private List<Medicine> getMedList() {
    List<Medicine> medicineList = new ArrayList<Medicine>();
   /* medicineList.add(new Medicine("Paracetamol", 1, 3, true, new ArrayList<Date>(), 15));
    medicineList.add(new Medicine("Gluco redfort", 1, 2, true, new ArrayList<Date>(), 15));
    medicineList.add(new Medicine("Entacin", 1, 3, true, new ArrayList<Date>(), 15));
    medicineList.add(new Medicine("Glucose", 1, 4, true, new ArrayList<Date>(), 15));*/
    return medicineList;
  }
}
