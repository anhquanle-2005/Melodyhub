package com.example.spotify.views.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.spotify.R;
import com.example.spotify.views.MainActivity;
import com.google.android.material.imageview.ShapeableImageView;

public class menuFragment extends Fragment implements View.OnClickListener {
    private ShapeableImageView img_profile;
    private ImageView img_close;
    private TextView txt_profile1, txt_profile2;
    private LinearLayout lo_themtk, lo_banmoi,lo_ganday,lo_dangxuat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_menu, container, false);
        addView(v);
        img_close.setOnClickListener(this);
        lo_dangxuat.setOnClickListener(this);
        return v;
    }

    private void addView(View v) {
        img_profile = v.findViewById(R.id.img_profile);
        img_close = v.findViewById(R.id.img_close);
        txt_profile1 = v.findViewById(R.id.txt_profile1);
        txt_profile2 = v.findViewById(R.id.txt_profile2);
        lo_themtk = v.findViewById(R.id.them_tk);
        lo_banmoi = v.findViewById(R.id.ban_phat_hanh);
        lo_ganday = v.findViewById(R.id.gan_day);
        lo_dangxuat = v.findViewById(R.id.dang_xuat);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.img_close)
        {
            requireActivity().getSupportFragmentManager().popBackStack();


        }
        if(v.getId()==R.id.dang_xuat)
        {
            ((MainActivity)requireActivity()).frsave = new wellcomeFragment();
            ((MainActivity)requireActivity()).openFragment(((MainActivity)requireActivity()).frsave,0);
            SharedPreferences sp = requireContext().getSharedPreferences("DN",MODE_PRIVATE);
            SharedPreferences.Editor edt = sp.edit();
            edt.putBoolean("DangDN",false);
            edt.apply();
        }

    }
}