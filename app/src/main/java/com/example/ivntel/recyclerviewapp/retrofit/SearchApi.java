package com.example.ivntel.recyclerviewapp.retrofit;

import com.example.ivntel.recyclerviewapp.model.SongsResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by ivntel on 2016-04-24.
 */
public interface SearchApi {
    @GET("/search/")
    void getItunesSearchResults(@Query("term") String term, Callback<SongsResponse> searchCallback);

}