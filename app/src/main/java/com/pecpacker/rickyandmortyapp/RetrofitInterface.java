package com.pecpacker.rickyandmortyapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/name")
    Call<List<NameModel>> getAllNames();
}
