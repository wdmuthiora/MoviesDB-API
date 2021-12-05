package com.moringaschool.moviesdbapi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.moringaschool.moviesdbapi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class  MainActivity extends AppCompatActivity {
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.moviesRecyclerView) ProgressBar moviesRecyclerView;
    @BindView(R.id.tvErrorMessage) ProgressBar tvErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}