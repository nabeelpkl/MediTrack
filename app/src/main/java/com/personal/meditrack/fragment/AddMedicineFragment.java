package com.personal.meditrack.fragment;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import com.personal.meditrack.R;
import com.personal.meditrack.model.Medicine;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddMedicineFragment extends Fragment {
  EditText medicineNameET, doseQuantityET, noOfMedicinesET;
  TextView reminderLabelOne, reminderLabelTwo, reminderLabelThree;
  Spinner dosesPerDaySpinner;
  Button saveButton, cancelButton;
  private RadioGroup doseFreqRadGroup;
  OnFragmentInteractionListener mListener;
  Calendar calendar = Calendar.getInstance();

  private int dosesPerDayCount = 1, reminderId = 0;
  private boolean isDaily = true;
  private Date[] reminderDates = new Date[3];
  private Calendar calendarOne = Calendar.getInstance(), calendarTwo = Calendar.getInstance(),
      calendarThree = Calendar.getInstance();

  public static AddMedicineFragment newInstance() {
    AddMedicineFragment fragment = new AddMedicineFragment();
    return fragment;
  }

  public AddMedicineFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    onAttachToParentFragment(getParentFragment());
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_add_medicine, container, false);
    medicineNameET = (EditText) view.findViewById(R.id.medicine_name_et);
    doseQuantityET = (EditText) view.findViewById(R.id.dose_quantity_et);
    noOfMedicinesET = (EditText) view.findViewById(R.id.noof_medicines_et);
    saveButton = (Button) view.findViewById(R.id.save_button);
    cancelButton = (Button) view.findViewById(R.id.cancel_button);
    reminderLabelOne = (TextView) view.findViewById(R.id.reminder_tv1);
    reminderLabelTwo = (TextView) view.findViewById(R.id.reminder_tv2);
    reminderLabelThree = (TextView) view.findViewById(R.id.reminder_tv3);
    dosesPerDaySpinner = (Spinner) view.findViewById(R.id.doses_perday_spinner);
    doseFreqRadGroup = (RadioGroup) view.findViewById(R.id.dose_frequency_radio_group);

    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    doseFreqRadGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
          case R.id.daily_rad_button:
            isDaily = true;
            break;
          case R.id.weekly_rad_button:
            isDaily = false;
            break;
          default:
            isDaily = true;
            break;
        }
      }
    });
    ArrayAdapter<String> spinnerArrayAdapter =
        new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,
            getResources().getStringArray(
                R.array.shoes)); //selected item will look like a spinner set from XML
    spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    dosesPerDaySpinner.setAdapter(spinnerArrayAdapter);

    dosesPerDaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        dosesPerDayCount = position + 1;
        switch (position) {
          case 0:
            reminderLabelTwo.setVisibility(View.GONE);
            reminderLabelThree.setVisibility(View.GONE);
            break;
          case 1:
            reminderLabelTwo.setVisibility(View.VISIBLE);
            reminderLabelThree.setVisibility(View.GONE);
            break;
          case 2:
            reminderLabelTwo.setVisibility(View.VISIBLE);
            reminderLabelThree.setVisibility(View.VISIBLE);
            break;
          default:
            reminderLabelTwo.setVisibility(View.GONE);
            reminderLabelThree.setVisibility(View.GONE);
            break;
        }
      }

      @Override public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    reminderLabelOne.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        reminderId = 1;
        getTimeFromPicker();
      }
    });

    reminderLabelTwo.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        reminderId = 2;
        getTimeFromPicker();
      }
    });
    reminderLabelThree.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        reminderId = 3;
        getTimeFromPicker();
      }
    });

    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        storeData();
        mListener.onAddMedicinesFinish();
      }
    });

    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        mListener.onAddMedicinesFinish();
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

  private void getTimeFromPicker() {
    Calendar mcurrentTime = Calendar.getInstance();
    final int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
    int minute = mcurrentTime.get(Calendar.MINUTE);
    TimePickerDialog mTimePicker;
    mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
      @Override public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

        switch (reminderId) {
          case 1:
            calendarOne.set(Calendar.HOUR_OF_DAY, selectedHour);
            calendarOne.set(Calendar.MINUTE, selectedMinute);
            reminderDates[0] = calendarOne.getTime();
            reminderLabelOne.setText(
                calendarOne.get(Calendar.HOUR_OF_DAY) + ":" + calendarOne.get(Calendar.MINUTE));
            break;
          case 2:
            calendarTwo.set(Calendar.HOUR_OF_DAY, selectedHour);
            calendarTwo.set(Calendar.MINUTE, selectedMinute);
            reminderLabelTwo.setText(
                calendarTwo.get(Calendar.HOUR_OF_DAY) + ":" + calendarTwo.get(Calendar.MINUTE));
            reminderDates[1] = calendarOne.getTime();

            break;
          case 3:
            calendarThree.set(Calendar.HOUR_OF_DAY, selectedHour);
            calendarThree.set(Calendar.MINUTE, selectedMinute);
            reminderLabelThree.setText(
                calendarThree.get(Calendar.HOUR_OF_DAY) + ":" + calendarThree.get(Calendar.MINUTE));
            reminderDates[2] = calendarOne.getTime();
            break;
          default:
            calendarOne.set(Calendar.HOUR_OF_DAY, selectedHour);
            calendarOne.set(Calendar.MINUTE, selectedMinute);
            reminderLabelOne.setText(
                calendarOne.get(Calendar.HOUR_OF_DAY) + ":" + calendarOne.get(Calendar.MINUTE));
            reminderDates[0] = calendarOne.getTime();
            break;
        }
      }
    }, hour, minute, true);//Yes 24 hour time
    mTimePicker.setTitle("Select Time");
    mTimePicker.show();
  }

  private void storeData() {
    String medicineName = medicineNameET.getText().toString();
    int doseQuantity = Integer.valueOf(doseQuantityET.getText().toString());
    int quantityPurchased = Integer.valueOf(noOfMedicinesET.getText().toString());
    Medicine newMedicine = new Medicine(medicineName, doseQuantity, dosesPerDayCount, isDaily,
        Arrays.asList(reminderDates), quantityPurchased);
  }

  public interface OnFragmentInteractionListener {
    void onAddMedicinesFinish();
  }
}
