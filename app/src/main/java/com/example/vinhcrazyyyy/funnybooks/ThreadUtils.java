package com.example.vinhcrazyyyy.funnybooks;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtils {

    public static void executeOnWorkThread(Runnable runnable) {
        new Thread(runnable).run();
    }

    public static void executeOnMainThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
