package com.example.mvvmsample.retrofit;

import com.example.mvvmsample.util.Constants;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private RetrofitInstance() {
    }

    private static class RetrofitInstanceHolder {
        private static final Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    public static <S> S createService(Class<S> serviceClass) {
        return RetrofitInstanceHolder.INSTANCE.create(serviceClass);
    }
}
