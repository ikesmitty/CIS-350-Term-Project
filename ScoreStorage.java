package com.example.isaacsmith.tba;

import android.app.Application;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.PushService;

/**
 * Created by Chad on 12/9/2015.
 */
public class ScoreStorage extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "np02JLpP1fEaUKXW1NWHoV4Z0q1RV98OrDdvK6pu", "tQ8xvZkY4iQ8d0uSAAuqGx8QJ9jtzF31a186LTY3");
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }

}


