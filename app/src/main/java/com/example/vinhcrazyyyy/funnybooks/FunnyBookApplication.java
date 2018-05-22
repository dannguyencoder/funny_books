package com.example.vinhcrazyyyy.funnybooks;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;

public class FunnyBookApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
