package com.example.ivntel.recyclerviewapp.retrofit;

import com.example.ivntel.recyclerviewapp.BuildConfig;

import retrofit.RestAdapter;

/**
 * Created by ivntel on 2016-04-24.
 */
public final class RestClient {

    public static final String ITUNES_URL = "https://itunes.apple.com";
    public static final boolean ENABLE_LOGGING = true;

    private static SearchApi searchApi;

    private RestClient() {
        // Hidden constructor
    }

    static {
        // Setup our rest adapter and all APIs
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(BuildConfig.DEBUG && ENABLE_LOGGING ? RestAdapter.LogLevel.BASIC : RestAdapter.LogLevel.NONE)
                .setEndpoint(ITUNES_URL)
                .build();
        searchApi = restAdapter.create(SearchApi.class);
    }

    public static SearchApi getSearchApi() {
        return searchApi;
    }
}



