package com.personal.meditrack.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.util.List;

/**
 * Created by nabeelkottol on 15/06/17.
 */

public class Medicine extends RealmObject {
  public static final String ID = "id";

  @PrimaryKey private long id;
  private String name;
  private int doseQuantity;
  private int dosesPerDay;
  private Boolean daily;
  private RealmList<ReminderDate> reminderTime;
  private int quantityPurchased;

  public Medicine() {
  }

  public Medicine(int id, String name, int doseQuantity, int dosesPerDay, Boolean daily,
      List<ReminderDate> reminderTime, int quantityPurchased) {
    this.id = id;
    this.name = name;
    this.doseQuantity = doseQuantity;
    this.dosesPerDay = dosesPerDay;
    this.daily = daily;
    this.quantityPurchased = quantityPurchased;
    reminderTime = new RealmList<ReminderDate>();
    reminderTime.addAll(reminderTime);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDoseQuantity() {
    return doseQuantity;
  }

  public void setDoseQuantity(int doseQuantity) {
    this.doseQuantity = doseQuantity;
  }

  public int getDosesPerDay() {
    return dosesPerDay;
  }

  public void setDosesPerDay(int dosesPerDay) {
    this.dosesPerDay = dosesPerDay;
  }

  public Boolean getDaily() {
    return daily;
  }

  public void setDaily(Boolean daily) {
    this.daily = daily;
  }

  public List<ReminderDate> getReminderTime() {
    return reminderTime;
  }

  public void setReminderTime(List<ReminderDate> reminderTime) {
    this.reminderTime.addAll(reminderTime);
  }

  public int getQuantityPurchased() {
    return quantityPurchased;
  }

  public void setQuantityPurchased(int quantityPurchased) {
    this.quantityPurchased = quantityPurchased;
  }
}
