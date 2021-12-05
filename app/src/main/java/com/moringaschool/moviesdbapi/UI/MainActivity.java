package com.moringaschool.moviesdbapi.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.moringaschool.moviesdbapi.Adapters.PopularMoviesAdapter;
import com.moringaschool.moviesdbapi.Models.Movie;
import com.moringaschool.moviesdbapi.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class  MainActivity extends AppCompatActivity {

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.moviesRecyclerView) ProgressBar moviesRecyclerView;
    @BindView(R.id.tvErrorMessage) ProgressBar tvErrorMessage;

    private PopularMoviesAdapter mAdapter;
    private List<Movie> mPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}