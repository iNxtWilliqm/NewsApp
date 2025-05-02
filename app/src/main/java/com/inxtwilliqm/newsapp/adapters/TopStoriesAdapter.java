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

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoryViewHolder> {
    private final List<News> topStories;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(News news);
    }

    public TopStoriesAdapter(List<News> topStories, OnItemClickListener listener) {
        this.topStories = topStories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TopStoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_story, parent, false);
        return new TopStoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopStoryViewHolder holder, int position) {
        News news = topStories.get(position);
        holder.title.setText(news.getTitle());
        holder.image.setImageResource(news.getImage());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(news));
    }

    @Override
    public int getItemCount() {
        return topStories.size();
    }

    static class TopStoryViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public TopStoryViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.top_story_title);
            image = itemView.findViewById(R.id.top_story_image);
        }
    }
}