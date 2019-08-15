package com.example.mvvmsample.retrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("shibes")
    Observable<List<String>> loadShibies(@Query("count") int count);
}
