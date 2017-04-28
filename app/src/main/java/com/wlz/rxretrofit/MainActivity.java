package com.wlz.rxretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonArray;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiService.Implementation.get().getPosts()
            .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new JsonSubscriber());
    }

    @Subscribe
    public void onDataLoaded(JsonArray array){
        Log.e("Result",array.get(0).getAsJsonObject().get("title").getAsString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        RxBus.get().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        RxBus.get().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

    /***
 * Otto Bus Instance
 *
 */
//    @Subscribe public void onDataLoaded(JsonArray array){
//        Log.e("Result",array.get(0).getAsJsonObject().get("title").getAsString());
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        BusProvider.getInstance().register(this);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        BusProvider.getInstance().unregister(this);
//    }
}
