package com.pecpacker.rickyandmortyapp.RetrofitApi;

import com.pecpacker.rickyandmortyapp.CharacterPojo.Model;
import com.pecpacker.rickyandmortyapp.CharacterPojo.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterAPI {

    @GET("/api/character/")
    Call<Model> getAllNames();
}
