package com.moringaschool.moviesdbapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.moviesdbapi.Models.Movie;
import com.moringaschool.moviesdbapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//CUSTOM ADAPTER
public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder> {
    private Context mContext;
    private List<Movie> mPopular;

    public PopularMoviesAdapter(Context mContext, List<Movie> mPopular) {
        this.mContext = mContext;
        this.mPopular = mPopular;
    }

    @NonNull
    @Override
    public PopularMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_movie_item,parent,false);
        PopularMoviesViewHolder viewHolder=new PopularMoviesViewHolder(v); //Pass the inflated view to custom viewHolder on create
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMoviesViewHolder holder, int position) {
        holder.bindPopularMovies(mPopular.get(position ));
    }

    @Override
    public int getItemCount() {
        return mPopular.size();
    }


    //  VIEWHOLDER
    public class PopularMoviesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ivMovieImage) ImageView ivMovieImage;
        @BindView(R.id.tvReleaseDate) TextView mReleaseDate;
        @BindView(R.id.tvMovieTitle) TextView tvMovieTitle;
        @BindView(R.id.tvMovieDescription) TextView tvMovieDescription;
        @BindView(R.id.tvMoviePopularity) TextView tvMoviePopularity;

        private Context mContext;

        //constructor
        public PopularMoviesViewHolder(View itemView){
            //itemView is inherited from RecyclerView.ViewHolder class
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        //BIND PROPERTIES TO EACH MOVIE OBJECT
        public void bindPopularMovies( Movie movie){
            Picasso.get().load(movie.getPosterPath()).into(ivMovieImage);
            mReleaseDate.setText(movie.getReleaseDate());
            tvMovieTitle.setText(movie.getTitle());
            tvMovieDescription.setText(movie.getOverview());
            tvMoviePopularity.setText(movie.getPopularity() + "/5");
        }
    }

}
