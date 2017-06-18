package com.personal.meditrack;

import android.app.Application;
import timber.log.Timber;

/**
 * Created by nabeelkottol on 17/06/17.
 */

public class MyApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}