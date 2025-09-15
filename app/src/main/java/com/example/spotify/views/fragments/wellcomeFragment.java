package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.spotify.views.activity.MainActivity;
import com.example.spotify.R;

public class wellcomeFragment extends Fragment implements View.OnClickListener {
    Button btn_dn, btn_dk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_wellcome, container, false);
        addView(v);
        btn_dn.setOnClickListener(this);
        return v;
    }

    private void addView(View v) {
        btn_dn = v.findViewById(R.id.btn_dn);
        btn_dk = v.findViewById(R.id.btn_dk);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_dn)
            ((MainActivity) requireActivity()).openFragment(new dangnhapFragment(),0);
    }

    public static class SearchFragment {
    }
}