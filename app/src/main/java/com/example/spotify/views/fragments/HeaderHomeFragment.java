package com.example.spotify.views.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.spotify.R;


public class HeaderHomeFragment extends Fragment implements View.OnClickListener{
    private ImageButton img_avt;
    private Button btn_tatca, btn_nhac, btn_podcast;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_header_home, container, false);
        addView(v);
        img_avt.setOnClickListener(this);
        btn_nhac.setOnClickListener(this);
        btn_tatca.setOnClickListener(this);
        btn_podcast.setOnClickListener(this);
        return v;
    }

    private void addView(View v) {
        img_avt = v.findViewById(R.id.img_avt);
        btn_nhac = v.findViewById(R.id.btn_nhac);
        btn_tatca = v.findViewById(R.id.btn_tatca);
        btn_podcast = v.findViewById(R.id.btn_bodcast);
    }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.img_avt) {
            FragmentTransaction ftr = requireActivity().getSupportFragmentManager().beginTransaction();
            ftr.add(R.id.container_body, new MenuFragment());
            ftr.addToBackStack(null);
            ftr.commit();

        }
        if (v.getId()==R.id.btn_nhac && ((HomeFragment)getParentFragment()).selectedId != R.id.btn_nhac) {
            ((HomeFragment)getParentFragment()).addBody(new HomeNhacFragment());
            btn_nhac.setBackgroundResource(R.drawable.custom_btndk);
            btn_tatca.setBackgroundResource(R.drawable.custom_btn);
            btn_podcast.setBackgroundResource(R.drawable.custom_btn);
            btn_podcast.setTextColor(Color.WHITE);
            btn_tatca.setTextColor(Color.WHITE);
            btn_nhac.setTextColor(Color.BLACK);
            ((HomeFragment)getParentFragment()).selectedId = R.id.btn_nhac;
        }
        if(v.getId()==R.id.btn_tatca && ((HomeFragment)getParentFragment()).selectedId!= R.id.btn_tatca)
        {
            ((HomeFragment)getParentFragment()).addBody(new HomeTatcaFragment());
            btn_tatca.setBackgroundResource(R.drawable.custom_btndk);
            btn_nhac.setBackgroundResource(R.drawable.custom_btn);
            btn_podcast.setBackgroundResource(R.drawable.custom_btn);
            btn_podcast.setTextColor(Color.WHITE);
            btn_nhac.setTextColor(Color.WHITE);
            btn_tatca.setTextColor(Color.BLACK);
            ((HomeFragment)getParentFragment()).selectedId= R.id.btn_tatca;
        }
        if(v.getId()==R.id.btn_bodcast&& ((HomeFragment)getParentFragment()).selectedId!= R.id.btn_bodcast)
        {
            ((HomeFragment)getParentFragment()).addBody(new HomePodcastFragment());
            btn_podcast.setBackgroundResource(R.drawable.custom_btndk);
            btn_tatca.setBackgroundResource(R.drawable.custom_btn);
            btn_nhac.setBackgroundResource(R.drawable.custom_btn);
            btn_nhac.setTextColor(Color.WHITE);
            btn_tatca.setTextColor(Color.WHITE);
            btn_podcast.setTextColor(Color.BLACK);
            ((HomeFragment)getParentFragment()).selectedId = R.id.btn_bodcast;
        }

    }
}