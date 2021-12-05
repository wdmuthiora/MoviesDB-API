package com.moringaschool.moviesdbapi.Adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.moviesdbapi.Models.Movie;
import com.moringaschool.moviesdbapi.R;

import java.util.List;

import butterknife.BindView;

public class PopularMoviesAdapter extends RecyclerView.ViewHolder {
    private Context mContext;
    private List<Movie> mPopular;

    public PopularMoviesAdapter(Context mContext, List<Movie> mPopular) {
        this.mContext = mContext;
        this.mPopular = mPopular;
    }

    public class PopularMoviesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ivMovieImage) ImageView ivMovieImage;

        @BindView(R.id.tvReleaseDate) TextView mReleaseDate;

        @BindView(R.id.tvMovieTitle) TextView tvMovieTitle;

        @BindView(R.id.tvMovieDescription) TextView tvMovieDescription;

        @BindView(R.id.tvMoviePopularity) TextView tvMoviePopularity;


    }
}
