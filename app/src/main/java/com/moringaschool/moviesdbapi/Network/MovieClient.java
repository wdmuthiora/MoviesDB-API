package com.moringaschool.moviesdbapi.Network;

import android.graphics.Movie;

import com.moringaschool.moviesdbapi.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient {

    private static Retrofit retrofit=null;
//Using client to build Retrofit instance, that will in turn be used to query the api
    public static MovieApi getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(Constants.MOVIE_DB_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(MovieApi.class );
    }
}
