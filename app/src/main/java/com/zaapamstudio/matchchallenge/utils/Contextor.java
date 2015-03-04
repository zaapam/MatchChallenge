package com.zaapamstudio.matchchallenge.utils;

import android.content.Context;

/**
 * Created by suthamaskamollasal on 3/3/15 AD.
 */
public class Contextor {
    private static Contextor ourInstance = new Contextor();

    public static Contextor getInstance() {
        return ourInstance;
    }

    private Contextor() {
    }

    private Context context;

    public void init(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
