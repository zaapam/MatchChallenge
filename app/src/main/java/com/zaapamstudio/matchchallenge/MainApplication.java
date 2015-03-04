package com.zaapamstudio.matchchallenge;

import android.app.Application;

import com.zaapamstudio.matchchallenge.utils.Contextor;

/**
 * Created by suthamaskamollasal on 3/2/15 AD.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }
}
