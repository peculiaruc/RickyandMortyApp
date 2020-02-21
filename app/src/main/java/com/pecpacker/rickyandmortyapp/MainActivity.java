package com.pecpacker.rickyandmortyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import android.app.ProgressDialog;

import com.pecpacker.rickyandmortyapp.CharacterPojo.Model;
import com.pecpacker.rickyandmortyapp.CharacterPojo.Result;
import com.pecpacker.rickyandmortyapp.RetrofitApi.CharacterAPI;
import com.pecpacker.rickyandmortyapp.RetrofitApi.CharacterService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RecyclerViewAdapter";
    ProgressDialog progressDoalog;
    private RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:  started.");

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/

        CharacterAPI service = CharacterService.getRetrofitInstance().create(CharacterAPI.class);
        Call<Model> call = service.getAllNames();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                progressDoalog.dismiss();
                initRecyclerView(response.body());
                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initRecyclerView(Model mName) {
        Log.d(TAG, "initRecyclerView: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mName, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
