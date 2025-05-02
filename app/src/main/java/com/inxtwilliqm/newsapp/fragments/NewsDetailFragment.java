package com.inxtwilliqm.newsapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inxtwilliqm.newsapp.R;
import com.inxtwilliqm.newsapp.adapters.NewsAdapter;
import com.inxtwilliqm.newsapp.models.News;
import com.inxtwilliqm.newsapp.utils.NewsData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends Fragment {
    private TextView newsTitle;
    private TextView newsDescription;
    private ImageView newsImage;
    private RecyclerView relatedNewsRecyclerView;

    public static NewsDetailFragment newInstance(String title, String description, String category, int image) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("description", description);
        args.putString("category", category);
        args.putInt("image", image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsTitle = view.findViewById(R.id.news_detail_title);
        newsDescription = view.findViewById(R.id.news_detail_description);
        newsImage = view.findViewById(R.id.news_detail_image);
        relatedNewsRecyclerView = view.findViewById(R.id.related_news_recycler_view);

        if (getArguments() != null) {
            String title = getArguments().getString("title");
            String description = getArguments().getString("description");
            String category = getArguments().getString("category");
            int image = getArguments().getInt("image");

            newsTitle.setText(title);
            newsDescription.setText(description);
            newsImage.setImageResource(image);

            setupRelatedNews(title, category);
        }
    }

    private void setupRelatedNews(String currentTitle, String currentCategory) {
        List<News> allNews = NewsData.getAllNews();
        List<News> relatedNews = new ArrayList<>();

        for (News news : allNews) {
            if (news.getCategory().equals(currentCategory) && !news.getTitle().equals(currentTitle)) {
                relatedNews.add(news);
            }
        }

        NewsAdapter adapter = new NewsAdapter(relatedNews, true, newsItem -> {
            // Update the detail view when a related news is clicked
            newsTitle.setText(newsItem.getTitle());
            newsDescription.setText(newsItem.getDescription());
            newsImage.setImageResource(newsItem.getImage());
            setupRelatedNews(newsItem.getTitle(), newsItem.getCategory());
        });

        relatedNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        relatedNewsRecyclerView.setAdapter(adapter);
    }
}
