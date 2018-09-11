package com.example.android.recycleview;


import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Rcadapter extends RecyclerView.Adapter<Rcadapter.Rcholder> {
    int[] images;
    String[] npR;
    Context context;

    Rcadapter(Context c,int [] b,String [] a){
        this.context=c;
        this.images=b;
        this.npR=a;
    }


    @NonNull
    @Override
    public Rcholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(context).inflate(R.layout.foodcard,viewGroup, false);
        return new Rcholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Rcholder h, int i) {
    h.fim.setImageResource(images[i]);
    String [] np=npR[i].split(":");
    h.fname.setText(np[0]);
    h.fprice.setText(np[1]+"/-");
    }


    @Override
    public int getItemCount() {

        return images.length;
    }

    class Rcholder extends RecyclerView.ViewHolder{
            View card;
            ImageView fim;
            TextView fname,fprice;

        public Rcholder(@NonNull View itemView){
            super(itemView);
            card = itemView.findViewById(R.id.cardf);
            fim=itemView.findViewById(R.id.food1);
            fname=itemView.findViewById(R.id.fname);
            fprice=itemView.findViewById(R.id.fprice);
        }
    }
}
