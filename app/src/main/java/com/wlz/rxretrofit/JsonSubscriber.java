package com.wlz.rxretrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.hwangjr.rxbus.RxBus;

/**
 * Created by WaiLynnZaw on 4/28/17.
 */

public class JsonSubscriber extends BaseSuscriber {
    @Override
    public void onNext(JsonElement jsonElement) {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
//        BusProvider.getInstance().post(jsonArray);
        RxBus.get().post(jsonArray);
    }
}
