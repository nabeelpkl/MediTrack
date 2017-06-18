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
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MedicinesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicinesFragment extends Fragment {
  private RecyclerView medRecyclerView;
  private MedicineListAdapter medListAdapter;
  private RealmResults<Medicine> mList;
  private Realm realm;

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
    realm = Realm.getDefaultInstance();
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

  private RealmResults<Medicine> getMedList() {
    return realm.where(Medicine.class).
        findAll().sort(Medicine.ID);
  }
}
