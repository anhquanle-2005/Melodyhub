package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.R;
import com.example.spotify.adapter.PodcastAdapter;
import com.example.spotify.models.Podcast;
import com.example.spotify.viewModels.PodcastViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomePodcastFragment extends Fragment {
    private RecyclerView rcv_podcast;
    private PodcastAdapter podcastAdapter;
    private List<Podcast> listPodcast;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_home_podcast, container, false);
        addView(v);
        return v;
    }

    private void addView(View v) {
        rcv_podcast = v.findViewById(R.id.rcv_podcast);
        listPodcast = new ArrayList<>();
        PodcastViewModel podcastViewModel = new PodcastViewModel();
        listPodcast = podcastViewModel.addView();
        podcastAdapter = new PodcastAdapter(listPodcast);
        LinearLayoutManager lm = new LinearLayoutManager(v.getContext());
        rcv_podcast.setLayoutManager(lm);
        rcv_podcast.setAdapter(podcastAdapter);
    }
}