package com.moringaschool.moviesdbapi.Network;

import com.moringaschool.moviesdbapi.Models.Movie;
import com.moringaschool.moviesdbapi.Models.PopularMovie;
import com.moringaschool.moviesdbapi.Models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    //Endpoint, using Retrofit, and append api as a query parameter
    //Retrofit turns your HTTP API into a Java interface.
    @GET("movie/popular")
    Call<PopularMovie> getPopularMovies(
            @Query("api_key") String myApiKey
    );

    //Another Endpoint, and append api as a query parameter
    @GET("movie/top_rated")
    Call <PopularMovie> getTopRatedMovies(
            @Query("api_key") String myApiKey
    );
}
