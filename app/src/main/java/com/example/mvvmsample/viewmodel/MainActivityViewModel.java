package com.example.mvvmsample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmsample.model.Post;
import com.example.mvvmsample.repository.Repository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private Repository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance();
    }

    public LiveData<List<Post>> getPosts() {
        return repository.getPosts();
    }
}
