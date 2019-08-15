package com.example.mvvmsample.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmsample.retrofit.RetrofitInstance;
import com.example.mvvmsample.retrofit.RetrofitService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Repository {
    private RetrofitService service;

    private Repository() {
        this.service = RetrofitInstance.createService(RetrofitService.class);
    }

    private static class RepositoryInstanceHolder {
        private static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return RepositoryInstanceHolder.INSTANCE;
    }

    public LiveData<List<String>> getShibeImageUrls(int count) {
        MutableLiveData<List<String>> urls = new MutableLiveData<>();

        service.loadShibies(count).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) { }

            @Override
            public void onNext(List<String> strings) {
                // This method call means things were successful so we POST the value
                urls.postValue(strings);
                // urls.postValue(strings) - > POST is when you are on a background thread
                // urls.setValue(strings) - > SET is for when you are on main thread
            }

            @Override
            public void onError(Throwable e) {
                // We post null so we know something went wrong
                // ofCourse in a real life setting we would do more
                urls.postValue(null);
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() { }
        });

        return urls;
    }

}