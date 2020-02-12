package com.pecpacker.rickyandmortyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView reMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reMain = findViewById(R.id.rvMain);

        reMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        RetrofitInterface retrofitInterface = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<NameModel>> listCall = retrofitInterface.getAllNames();
        listCall.enqueue(new Callback<List<NameModel>>() {
            @Override
            public void onResponse(Call<List<NameModel>> call, Response<List<NameModel>> response) {
                parseData(response.body());

            }

            @Override
            public void onFailure(Call<List<NameModel>> call, Throwable t) {

            }
        });


    }

    private void parseData(List<NameModel> body) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(body);
        reMain.setAdapter(recyclerViewAdapter);

    }
}
