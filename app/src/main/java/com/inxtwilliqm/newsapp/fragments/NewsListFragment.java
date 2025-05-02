package com.inxtwilliqm.newsapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inxtwilliqm.newsapp.R;
import com.inxtwilliqm.newsapp.adapters.NewsAdapter;
import com.inxtwilliqm.newsapp.adapters.TopStoriesAdapter;
import com.inxtwilliqm.newsapp.models.News;
import com.inxtwilliqm.newsapp.utils.NewsData;

import java.util.ArrayList;
import java.util.List;

public class NewsListFragment extends Fragment {
    private RecyclerView topStoriesRecyclerView;
    private RecyclerView newsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        // Set up RecyclerView for top stories
        topStoriesRecyclerView = view.findViewById(R.id.top_stories_recycler_view);
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        topStoriesRecyclerView.setAdapter(new TopStoriesAdapter(NewsData.getRandomNews(), this::openNewsDetailFragment));

        // Set up RecyclerView for news
        newsRecyclerView = view.findViewById(R.id.news_recycler_view);
        newsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        newsRecyclerView.setAdapter(new NewsAdapter(NewsData.getRandomNews(), false, this::openNewsDetailFragment));

        return view;
    }

    private void openNewsDetailFragment(News news) {
        NewsDetailFragment fragment = NewsDetailFragment.newInstance(
                news.getTitle(),
                news.getDescription(),
                news.getCategory(),
                news.getImage()
        );
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}