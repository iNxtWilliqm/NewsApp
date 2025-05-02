package com.inxtwilliqm.newsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inxtwilliqm.newsapp.R;
import com.inxtwilliqm.newsapp.models.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private final List<News> newsList;
    private final OnItemClickListener listener;
    private final boolean isHorizontal;

    public interface OnItemClickListener {
        void onItemClick(News news);
    }

    public NewsAdapter(List<News> newsList, boolean isHorizontal, OnItemClickListener listener) {
        this.newsList = newsList;
        this.isHorizontal = isHorizontal;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutRes = isHorizontal ? R.layout.item_related_stories : R.layout.item_news;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
        return new NewsViewHolder(view, isHorizontal);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());
        holder.image.setImageResource(news.getImage());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(news));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView image;

        public NewsViewHolder(View itemView, boolean isHorizontal) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            description = itemView.findViewById(R.id.news_description);
            image = itemView.findViewById(R.id.news_image);
        }
    }
}