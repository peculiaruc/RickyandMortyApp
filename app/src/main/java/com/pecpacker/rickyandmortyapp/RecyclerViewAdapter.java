package com.pecpacker.rickyandmortyapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerHolder> {

    List<NameModel> models;

    public RecyclerViewAdapter(List<NameModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
