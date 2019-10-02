package com.example.mvvmsample.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmsample.model.Post;
import com.example.mvvmsample.retrofit.RetrofitInstance;
import com.example.mvvmsample.retrofit.RetrofitService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Repository {
    // Declare RetrofitService
    private RetrofitService service;

    // Empty Constructor with init of the service
    private Repository() {
        this.service = RetrofitInstance.createService(RetrofitService.class);
    }
                            // CHANGE CLASS NAME
    // Repo Instance holder -- its Repository not Retrofit
    private static class RepositoryInstanceHolder {
        private static final Repository INSTANCE = new Repository();
    }

    // Ctrl + Alt + L
    // Reformat your code
    public static Repository getInstance() {
        return RepositoryInstanceHolder.INSTANCE;
    }

    public LiveData<List<Post>> getPosts() {
        MutableLiveData<List<Post>> livePosts = new MutableLiveData<>();

        service.loadPosts().subscribe(new Observer<List<Post>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Post> posts) {
                livePosts.postValue(posts);
            }

            @Override
            public void onError(Throwable e) {
            livePosts.postValue(null);
            }

            @Override
            public void onComplete() {

            }
        });

        return livePosts;
    }
}