package com.personal.meditrack.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.util.Date;
import java.util.List;

/**
 * Created by nabeelkottol on 15/06/17.
 */

public class Medicine extends RealmObject {
  public static final String ID = "id";
  public static final String IS_DAILY = "daily";

  @PrimaryKey private long id;
  private String name;
  private int doseQuantity;
  private int dosesPerDay;
  private Boolean daily;
  private RealmList<ReminderDate> reminderTime;
  private int quantityPurchased;
  private int remainingMeds;
  private Date lastDoseDate;

  public Medicine() {
  }

  public Medicine(int id, String name, int doseQuantity, int dosesPerDay, Boolean daily,
      List<ReminderDate> reminderTime, int quantityPurchased, int remainingMeds) {
    this.id = id;
    this.name = name;
    this.doseQuantity = doseQuantity;
    this.dosesPerDay = dosesPerDay;
    this.daily = daily;
    this.quantityPurchased = quantityPurchased;
    this.remainingMeds = remainingMeds;
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

  public int getQuantityPurchased() {
    return quantityPurchased;
  }

  public void setQuantityPurchased(int quantityPurchased) {
    this.quantityPurchased = quantityPurchased;
  }

  public static String getID() {
    return ID;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setReminderTime(RealmList<ReminderDate> reminderTime) {
    this.reminderTime = reminderTime;
  }

  public int getRemainingMeds() {
    return remainingMeds;
  }

  public void setRemainingMeds(int remainingMeds) {
    this.remainingMeds = remainingMeds;
  }

  public Date getLastDoseDate() {
    return lastDoseDate;
  }

  public void setLastDoseDate(Date lastDoseDate) {
    this.lastDoseDate = lastDoseDate;
  }
}
