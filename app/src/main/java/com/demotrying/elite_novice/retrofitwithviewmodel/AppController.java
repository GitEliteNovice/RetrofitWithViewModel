package com.demotrying.elite_novice.retrofitwithviewmodel;

import android.app.Application;

import com.demotrying.elite_novice.retrofitwithviewmodel.adapter.DataAdapter;
import com.demotrying.elite_novice.retrofitwithviewmodel.network.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppController extends Application {
    private static AppController mInstance;
    String BASE_URL="http://api.football-data.org/";
    RequestInterface requestInterface;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;

        Gson gson = new GsonBuilder().registerTypeAdapter(List.class, new DataAdapter(getApplicationContext())).create();

        requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(RequestInterface.class);


    }
    public RequestInterface getInterface(){
        return requestInterface;
    }
    public static synchronized AppController getInstance() {
        return mInstance;
    }

}
