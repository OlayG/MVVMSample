package com.example.mvvmsample.retrofit;

import com.example.mvvmsample.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("posts")
    Observable<List<Post>> loadPosts();

}
