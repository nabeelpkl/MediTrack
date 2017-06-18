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

public class TodaysMedListAdapter
    extends RecyclerView.Adapter<TodaysMedListAdapter.TodaysMedViewHolder> {

  private Context mContext;
  private List<Medicine> mList;

  public TodaysMedListAdapter(Context mContext, List<Medicine> list) {
    this.mContext = mContext;
    this.mList = list;
  }

  @Override public TodaysMedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
    TodaysMedViewHolder viewHolder;
    View viewStGeneral = mInflater.inflate(R.layout.recycler_item_today_med, parent, false);
    viewHolder = new TodaysMedViewHolder(viewStGeneral);
    return viewHolder;
  }

  @Override public void onBindViewHolder(TodaysMedViewHolder holder, int position) {
    Medicine medicine = mList.get(position);

    setValues((TodaysMedViewHolder) holder, medicine);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
       /* Intent intent = new Intent(mContext, NotificationDetailsActivity.class);
        intent.putExtra(NotificationDetailsActivity.NOTIFICATION_TAG, medicine);
        mContext.startActivity(intent);*/
      }
    });
  }

  private void setValues(TodaysMedViewHolder viewHolder, Medicine medicine) {
    try {
      viewHolder.medicineName.setText(medicine.getName());
      viewHolder.doseAmount.setText(String.valueOf(medicine.getDoseQuantity()));
      viewHolder.dailyCount.setText(String.valueOf(medicine.getDosesPerDay()));
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

  public class TodaysMedViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.medicine_name) TextView medicineName;
    @BindView(R.id.dose_amount) TextView doseAmount;
    @BindView(R.id.daily_count) TextView dailyCount;

    public TodaysMedViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

 /* private String changeDateFormat(String date) {
    return dateHelper.changeDateFormat(date, DateHelper.SERVER_LAST_DATE_FORMAT,
        DateHelper.APP_DATE_FORMAT);
  }*/
}