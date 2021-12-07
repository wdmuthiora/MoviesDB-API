package com.moringaschool.moviesdbapi.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.moviesdbapi.Adapters.PopularMoviesAdapter;
import com.moringaschool.moviesdbapi.Constants;
import com.moringaschool.moviesdbapi.Models.Movie;
import com.moringaschool.moviesdbapi.Models.PopularMovie;
import com.moringaschool.moviesdbapi.Models.Result;
import com.moringaschool.moviesdbapi.Network.MovieApi;
import com.moringaschool.moviesdbapi.Network.MovieClient;
import com.moringaschool.moviesdbapi.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  MainActivity extends AppCompatActivity {

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.moviesRecyclerView) RecyclerView moviesRecyclerView;
    @BindView(R.id.tvErrorMessage) TextView tvErrorMessage;

    private PopularMoviesAdapter mAdapter;
    private List<Result> mPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //to avoid memory leaks, on the main thread, we need an asynchronous call to handle network calls. Thus we call this method here, and define it outside our onCreate() method to be sure.
        getPopularMovies();
    }

    public void getPopularMovies() {
         //create a client object (Retrofit instance), and use it to query the API
        MovieApi myClient= MovieClient.getClient();

        Call<PopularMovie> call=myClient.getPopularMovies(Constants.MOVIE_DB_API);
        //Makes an asynchronous call.
        call.enqueue(new Callback<PopularMovie>() {

            @Override
            public void onResponse(Call<PopularMovie> call, Response<PopularMovie> response) {
                hideProgressBar();
                if(response.isSuccessful()) {
                    mPopular = response.body().getResults();
                    mAdapter = new PopularMoviesAdapter(MainActivity.this, mPopular);
                    moviesRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    moviesRecyclerView.setLayoutManager(layoutManager);
                    moviesRecyclerView.setHasFixedSize(true);
                    showPopularMovies();
                }
                else{
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<PopularMovie> call, Throwable t) {
                showErrorMessage();
            }

        });
    }

    private void showErrorMessage() {
        tvErrorMessage.setText("Something went wrong. Please check you internet connection, and try again.");
    }

    private void showPopularMovies() {
        moviesRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
    
}