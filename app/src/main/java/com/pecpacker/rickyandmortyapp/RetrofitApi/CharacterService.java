package com.pecpacker.rickyandmortyapp.RetrofitApi;

import com.pecpacker.rickyandmortyapp.RetrofitApi.CharacterAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CharacterService {

    public static final String BASE_URL = "https://rickandmortyapi.com";
    public static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }


    public CharacterAPI create(Class<CharacterAPI> retrofitInterfaceClass) {
        return null;
    }
}


