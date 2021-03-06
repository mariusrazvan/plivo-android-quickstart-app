package com.plivo.plivosimplequickstart;

import android.app.Application;

import com.plivo.endpoint.BuildConfig;

public class App extends Application {

    private PlivoBackEnd backend;

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.options.put("context",getApplicationContext());
        Utils.options.put("sharedContext",getApplicationContext());
        backend = PlivoBackEnd.newInstance();
        backend.init(BuildConfig.DEBUG);
    }

    public PlivoBackEnd backend() {
        return backend;
    }
}
