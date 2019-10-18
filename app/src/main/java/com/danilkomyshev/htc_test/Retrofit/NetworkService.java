package com.danilkomyshev.htc_test.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static Retrofit ourInstance;

    public static Retrofit getInstance(){
        if(ourInstance == null){
            ourInstance = new Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/v2/56fa31e0110000f920a72134/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return ourInstance;
    }
    private NetworkService(){

    }
}
