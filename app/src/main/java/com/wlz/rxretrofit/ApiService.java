package com.wlz.rxretrofit;

import com.google.gson.JsonElement;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by WaiLynnZaw on 2/10/16.
 */
public interface ApiService {
    @GET("posts")
    Observable<JsonElement> getPosts();
    @GET("comments")
    Observable<JsonElement> getComments();

    class Implementation{
        static ApiService get(){
            return getBuilder()
                    .build()
                    .create(ApiService.class);
        }
        static Retrofit.Builder getBuilder() {
            return new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constant.END_POINT);
        }
    }
}
