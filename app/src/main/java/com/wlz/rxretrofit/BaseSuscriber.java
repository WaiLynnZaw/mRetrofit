package com.wlz.rxretrofit;

import android.util.Log;

import com.google.gson.JsonElement;

import rx.Subscriber;

/**
 * Created by WaiLynnZaw on 4/28/17.
 */

public class BaseSuscriber extends Subscriber<JsonElement> {
    private static final String LOG_TAG = BaseSuscriber.class.getName();
    @Override
    public void onCompleted() {
        Log.e(LOG_TAG,"onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        Log.e(LOG_TAG,"Error "+e.getLocalizedMessage());
        Log.e(LOG_TAG, e.getMessage());
    }

    @Override
    public void onNext(JsonElement jsonElement) {

    }

}
