package com.wlz.rxretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiService.Implementation.get().getPosts()
            .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonElement>() {
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
                        JsonArray jsonArray = jsonElement.getAsJsonArray();
                        Log.e("Result",jsonArray.get(0).getAsJsonObject().get("title").getAsString());
                    }
                });
    }
}
