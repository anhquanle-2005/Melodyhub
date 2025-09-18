package com.example.spotify.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.views.activity.MainActivity;

public class PremiumFragment extends Fragment {
    private RecyclerView rcvpre ;
    private LayoutInflater inflater;
    private ImageButton imgbtnHome,imgbtnSearch,imgbtnLib,imgbtnPre,imgbtnCrea;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Gắn layout XML vào Fragmenth
        return inflater.inflate(R.layout.fragment_premium, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }
    private void initViews(View v){
        imgbtnHome=v.findViewById(R.id.imgbtn_Home);
        imgbtnSearch=v.findViewById(R.id.imgbtn_Search);
        imgbtnLib=v.findViewById(R.id.imgbtn_Lib);
        imgbtnPre=v.findViewById(R.id.imgbtn_Pre);
        imgbtnCrea=v.findViewById(R.id.imgbtn_Crea);
    }
    public void setupClickListener(){
        imgbtnHome.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openFragment(new HomeFragment(), 0);
            }
        });
        imgbtnSearch.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openFragment(new SearchFragment(), 0);
            }
        });
        imgbtnPre.setOnClickListener(v ->{
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openFragment(new PremiumFragment(), 0);
            }
        });
        }
    }


