package com.personal.meditrack.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.personal.meditrack.R;
import com.personal.meditrack.model.Medicine;
import java.util.List;

/**
 * Created by abhijith on 18/04/17.
 */

public class MedicineListAdapter
    extends RecyclerView.Adapter<MedicineListAdapter.MedicinesViewHolder> {

  private Context mContext;
  private List<Medicine> mList;

  public MedicineListAdapter(Context mContext, List<Medicine> list) {
    this.mContext = mContext;
    this.mList = list;
  }

  @Override public MedicinesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
    MedicinesViewHolder viewHolder;
    View viewStGeneral = mInflater.inflate(R.layout.recycler_item_medicines, parent, false);
    viewHolder = new MedicinesViewHolder(viewStGeneral);
    return viewHolder;
  }

  @Override public void onBindViewHolder(MedicinesViewHolder holder, int position) {
    Medicine medicine = mList.get(position);

    setValues(holder, medicine);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
       /* Intent intent = new Intent(mContext, NotificationDetailsActivity.class);
        intent.putExtra(NotificationDetailsActivity.NOTIFICATION_TAG, medicine);
        mContext.startActivity(intent);*/
      }
    });
  }

  private void setValues(MedicinesViewHolder viewHolder, Medicine medicine) {
    try {
      viewHolder.medicineName.setText(medicine.getName());
    } catch (Exception e) {
      //Timber.e(e,"Values missing");
    }
  }

  @Override public int getItemCount() {
    return mList.size();
  }

  public void add(List<Medicine> mList) {
    this.mList.addAll(mList);
    //Timber.d("mList updated. new mList size is %d", mList.size());
  }

  public void clear() {
    mList.clear();
  }

  public class MedicinesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.medicine_name) TextView medicineName;

    public MedicinesViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

 /* private String changeDateFormat(String date) {
    return dateHelper.changeDateFormat(date, DateHelper.SERVER_LAST_DATE_FORMAT,
        DateHelper.APP_DATE_FORMAT);
  }*/
}