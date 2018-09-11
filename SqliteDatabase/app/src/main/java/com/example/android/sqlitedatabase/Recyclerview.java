package com.example.android.sqlitedatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Recyclerview extends RecyclerView.Adapter<Recyclerview.RecyclerViewHolder> {
    private StringBuffer[] data;
    Context c;
    public Recyclerview(Context c,StringBuffer[] data){
        this.data=data;
        this.c=c;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        StringBuffer title = data[i];
        recyclerViewHolder.dataR.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView dataR;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            dataR = itemView.findViewById(R.id.showDatabase);
        }
    }

}
