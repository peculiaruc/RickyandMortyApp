package com.pecpacker.rickyandmortyapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pecpacker.rickyandmortyapp.CharacterPojo.Model;
import com.pecpacker.rickyandmortyapp.CharacterPojo.Result;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHoldetr> {

    private static final String TAG = "RecyclerViewAdapter";


    private Model mCharName;
    private Context mContext;

    public RecyclerViewAdapter(Model mCharName, Context mContext) {
        this.mCharName = mCharName;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHoldetr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_item_row, parent, false);
        RecyclerView.ViewHolder holder = new ViewHoldetr(view);
        return (ViewHoldetr) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldetr holder, final int position) {
        Log.d(TAG, "onBindViewHolder called");

        Glide.with(mContext)
                .asBitmap()
                .load(mCharName.getResults().get(position).getImage())
                .into(holder.image);

        holder.charName.setText(mCharName.getResults().get(position).getName());
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Log.d(TAG, "onClick: clicked on: " + mCharName.get(position));

            }
        });


    }

    @Override
    public int getItemCount() {

        return mCharName.getResults().size();
    }


    public class ViewHoldetr extends RecyclerView.ViewHolder {

        ImageView image;
        TextView charName;
        RelativeLayout parentlayout;

        public ViewHoldetr(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img_name);
            charName = itemView.findViewById(R.id.char_name);
            parentlayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}



