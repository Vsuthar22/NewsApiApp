package com.example.news.models;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.Details;
import com.example.news.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public Context context;
    List<Articles> articles;


    public Adapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View items = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsview, parent, false);
        return new ViewHolder(items);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Articles a = articles.get(position);
        holder.title.setText(a.getTitle());
        // holder.desc.setText(a.getDescription());
        holder.tvsource.setText(a.getSource().getName());
        holder.date.setText(a.getPublishedAt());


        String imageurl = a.getUrlToImage();
        Picasso.get().load(imageurl).into(holder.img);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("title", a.getTitle());
                intent.putExtra("source", a.getSource().getName());
                intent.putExtra("desc", a.getDescription());
                intent.putExtra("url", a.getUrl());
                intent.putExtra("imageUrl", a.getUrlToImage());
                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, tvsource, date, desc;
        ImageView img;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvtitle);
            tvsource = itemView.findViewById(R.id.tvsource);
            //desc = itemView.findViewById(R.id.tvdesc);
            date = itemView.findViewById(R.id.tvdate);
            img = itemView.findViewById(R.id.imgview);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
