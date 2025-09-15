package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.spotify.R;


public class header_homeFragment extends Fragment implements View.OnClickListener{
    private ImageButton img_avt;
    private Button btn_tatca, btn_nhac, btn_bodcast;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_header_home, container, false);
        addView(v);
        img_avt.setOnClickListener(this);
        return v;
    }

    private void addView(View v) {
        img_avt = v.findViewById(R.id.img_avt);
        btn_tatca = v.findViewById(R.id.btn_tatca);
        btn_bodcast = v.findViewById(R.id.btn_bodcast);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.img_avt){
            FragmentTransaction ftr = requireActivity().getSupportFragmentManager().beginTransaction();
            ftr.add(R.id.container_body,new menuFragment());
            ftr.addToBackStack(null);
            ftr.commit();

        }
    }
}