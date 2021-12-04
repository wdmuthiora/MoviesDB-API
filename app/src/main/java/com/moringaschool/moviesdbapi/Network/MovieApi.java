package com.moringaschool.moviesdbapi.Network;

import com.moringaschool.moviesdbapi.Models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    //Endpoint, using Retrofit, and append api as a query parameter
    @GET("movie/popular")
    Call<Movie> getPopularMovies(
            @Query("api_key") String myApiKey
    );

    //Another Endpoint, and append api as a query parameter
    @GET("movie/top_rated")
    Call <Movie> getTopRatedMovies(
            @Query("api_key") String myApiKey
    );
}
