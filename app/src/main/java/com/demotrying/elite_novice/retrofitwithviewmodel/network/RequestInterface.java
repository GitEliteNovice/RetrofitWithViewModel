package com.demotrying.elite_novice.retrofitwithviewmodel.network;


import com.demotrying.elite_novice.retrofitwithviewmodel.model.Fixtures;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("v1/fixtures")
    Call<List<Fixtures>> fixtures();

}
