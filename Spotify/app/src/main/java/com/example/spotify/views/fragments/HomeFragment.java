package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.spotify.R;
import com.example.spotify.adapter.musicAdapter;
import com.example.spotify.models.music;
import com.example.spotify.views.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView rcvmusic;
    private ImageButton imgbtnHome,imgbtnSearch,imgbtnLib,imgbtnPre,imgbtnCrea;
    private List<music> mListmusic;
    private musicAdapter msAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_home, container, false);
        addView(v);
        initViews(v);
        setupClickListeners();

        return v;
    }
    private void initViews(View v) {
        rcvmusic = v.findViewById(R.id.rcvmsr);
        imgbtnHome=v.findViewById(R.id.imgbtn_Home);
        imgbtnSearch=v.findViewById(R.id.imgbtn_Search);
        imgbtnLib=v.findViewById(R.id.imgbtn_Lib);
        imgbtnPre=v.findViewById(R.id.imgbtn_Pre);
        imgbtnCrea=v.findViewById(R.id.imgbtn_Crea);
    }

    // Hàm thiết lập các sự kiện click
    private void setupClickListeners() {
        // Nút Home không cần sự kiện vì đang ở màn hình Home
        imgbtnHome.setOnClickListener(v -> {
            // Có thể thêm hành động refresh ở đây nếu muốn
            Toast.makeText(getContext(), "Bạn đang ở Trang chủ", Toast.LENGTH_SHORT).show();
        });

        // Nút Search chuyển sang SearchFragment
        imgbtnSearch.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openFragment(new SearchFragment(), 0);
            }
        });

        // Các nút khác sẽ hiển thị thông báo
        imgbtnLib.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Thư viện đang phát triển", Toast.LENGTH_SHORT).show());
        imgbtnPre.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Premium đang phát triển", Toast.LENGTH_SHORT).show());
        imgbtnCrea.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Tạo mới đang phát triển", Toast.LENGTH_SHORT).show());
    }
    private void addView(View v) {
        rcvmusic=v.findViewById(R.id.rcvmsr);
        mListmusic = new ArrayList<>();
        music ms1 = new music("Vết thương", "Fishy","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520");
        music ms3 = new music("BigTeam all stars", "BigDaddy, 7Dnight, DANGRANGTO, HURRYKNG, Pháp Kiều, $A Livan","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg");
        music ms2 = new music("EZ","Sabbirose, 7Dnight, VCC Left Hand" ,"https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");
        music ms4 = new music("Vết thương", "Fishy","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520");
        music ms5 = new music("BigTeam all stars", "BigDaddy, 7Dnight, DANGRANGTO, HURRYKNG, Pháp Kiều, $A Livan","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg");
        music ms6 = new music("EZ","Sabbirose, 7Dnight, VCC Left Hand" ,"https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");
        music ms7 = new music("Vết thương", "Fishy","https://i.scdn.co/image/ab67616d00001e02cb2a3066584a339e09508520");
        music ms8 = new music("BigTeam all stars", "BigDaddy, 7Dnight, DANGRANGTO, HURRYKNG, Pháp Kiều, $A Livan","https://i1.sndcdn.com/artworks-fqL73ggcxCeQtgsf-wQqmRQ-t1080x1080.jpg");
        music ms9 = new music("EZ","Sabbirose, 7Dnight, VCC Left Hand" ,"https://i.scdn.co/image/ab67616d00001e0203aeb634b34fed42641718a2");
        mListmusic.add(ms1);
        mListmusic.add(ms3);
        mListmusic.add(ms2);
        mListmusic.add(ms4);
        mListmusic.add(ms5);
        mListmusic.add(ms6);
        mListmusic.add(ms7);
        mListmusic.add(ms8);
        mListmusic.add(ms9);
        msAdapter = new musicAdapter(mListmusic);
        LinearLayoutManager lm = new LinearLayoutManager(v.getContext());
        rcvmusic.setLayoutManager(lm);
        rcvmusic.setAdapter(msAdapter);
    }
}