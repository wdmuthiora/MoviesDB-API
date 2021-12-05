package com.moringaschool.moviesdbapi.Adapters;

import android.content.Context;

import com.moringaschool.moviesdbapi.Models.Movie;

import java.util.List;

public class PopularMoviesAdapter {
    private Context mContext;
    private List<Movie> mPopular;

    public PopularMoviesAdapter(Context mContext, List<Movie> mPopular) {
        this.mContext = mContext;
        this.mPopular = mPopular;
    }
}
