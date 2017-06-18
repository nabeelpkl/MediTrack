package com.personal.meditrack.model;

import java.util.Date;
import java.util.List;

/**
 * Created by nabeelkottol on 15/06/17.
 */

public class Medicine {
  private String name;
  private int doseQuantity;
  private int dosesPerDay;
  private Boolean daily;
  private List<Date> reminderTime;
  private int quantityPurchased;

  public Medicine() {
  }

  public Medicine(String name, int doseQuantity, int dosesPerDay, Boolean daily, List<Date> reminderTime,
      int quantityPurchased) {
    this.name = name;
    this.doseQuantity = doseQuantity;
    this.dosesPerDay = dosesPerDay;
    this.daily = daily;
    this.reminderTime = reminderTime;
    this.quantityPurchased = quantityPurchased;
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

  public List<Date> getReminderTime() {
    return reminderTime;
  }

  public void setReminderTime(List<Date> reminderTime) {
    this.reminderTime = reminderTime;
  }

  public int getQuantityPurchased() {
    return quantityPurchased;
  }

  public void setQuantityPurchased(int quantityPurchased) {
    this.quantityPurchased = quantityPurchased;
  }
}
