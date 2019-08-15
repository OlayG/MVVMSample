package com.example.mvvmsample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvmsample.R;
import com.example.mvvmsample.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare View
    private TextView tvDisplay;
    // Declare ViewModel
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        // Init ViewModel
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        // Load shibes
        viewModel.getShibeUrls(10).observe(this, urls -> {
            if (urls != null) {
                String display = urls.toString();
                tvDisplay.setText(display);
            } else {
                Toast.makeText(this, "FAILED TO DOWNLOAD", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void initViews() {
        tvDisplay = findViewById(R.id.tv_display);
    }
}