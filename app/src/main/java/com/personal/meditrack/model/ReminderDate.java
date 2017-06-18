package com.personal.meditrack.model;

import io.realm.RealmObject;
import java.util.Date;

/**
 * Created by nabeelkottol on 18/06/17.
 */

public class ReminderDate extends RealmObject {
  private int id;
  private Date date;

  public ReminderDate() {
  }

  public ReminderDate(int id, Date date) {
    this.id = id;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
