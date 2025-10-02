package com.example.spotify.views.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.spotify.views.MainActivity;
import com.example.spotify.R;


public class DangNhapFragment extends Fragment implements View.OnClickListener{
    Button btn_dn1;
    ImageButton btn_quaylai;
    EditText txt_sdt, txt_passwork;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dangnhap, container, false);
        addView(v);
        btn_quaylai.setOnClickListener(this);
        btn_dn1.setOnClickListener(this);
        return v;

    }

    private void addView(View v) {
        btn_dn1 = v.findViewById(R.id.btn_dn1);
        btn_quaylai = v.findViewById(R.id.btn_quaylai);
        txt_sdt = v.findViewById(R.id.txt_sdt);
        txt_passwork = v.findViewById(R.id.txt_passwork);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_quaylai)
            ((MainActivity) requireActivity()).openFragment(new WellcomeFragment(),1);
        if(v.getId()==R.id.btn_dn1 && txt_sdt.getText().toString().equals("0123456789") && txt_passwork.getText().toString().equals("123456"))
        {
            ((MainActivity)requireActivity()).frsave= new HomeFragment();
            ((MainActivity)requireActivity()).openFragment( ((MainActivity)requireActivity()).frsave,0);

            SharedPreferences spf = requireContext().getSharedPreferences("DN", Context.MODE_PRIVATE);
            SharedPreferences.Editor edt = spf.edit();
            edt.putBoolean("DangDN",true);
            edt.apply();
        }

    }


}