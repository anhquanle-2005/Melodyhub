package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.spotify.R;

import com.example.spotify.adapter.MusicAdapter;
import com.example.spotify.adapter.playlistAdapter;
import com.example.spotify.adapter.radioAdapter;
import com.example.spotify.models.Music;
import com.example.spotify.models.playlist;
import com.example.spotify.models.radio;
import com.example.spotify.viewModels.MusicViewModel;
import com.example.spotify.viewModels.playlistViewModel;
import com.example.spotify.viewModels.radioViewModel;
import com.example.spotify.views.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView rcvmusic;
    private List<Music> mListmusic;
    private MusicAdapter msAdapter;
    private RecyclerView rcvradio;
    private List<radio> mListradio;
    private radioAdapter radioAdapter;
    private RecyclerView rcvplaylist;
    private List<playlist> lplay;
    private playlistAdapter playlistAdapter;
    ImageButton imgbtnHome,imgbtnSearch,imgbtnLib,imgbtnPre,imgbtnCrea;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_home, container, false);
        addView(v);
        FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
        fr.add(R.id.container_body,new header_homeFragment());
        fr.commit();
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

        imgbtnPre.setOnClickListener(v -> {
            if(getActivity()instanceof  MainActivity){
                ((MainActivity) getActivity()).openFragment(new PremiumFragment(),0);
            }
        });
        // Các nút khác sẽ hiển thị thông báo
        imgbtnLib.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Thư viện đang phát triển", Toast.LENGTH_SHORT).show());

        imgbtnCrea.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Tạo mới đang phát triển", Toast.LENGTH_SHORT).show());
    }
    private void addView(View v) {

        rcvmusic=v.findViewById(R.id.rcvms);
        mListmusic = new ArrayList<>();
        MusicViewModel mvd = new MusicViewModel();
        mListmusic = mvd.setView();
        msAdapter = new MusicAdapter(mListmusic);
        LinearLayoutManager lm = new LinearLayoutManager(v.getContext());
        rcvmusic.setLayoutManager(lm);
        rcvmusic.setAdapter(msAdapter);
        //view radio
        rcvradio=v.findViewById(R.id.rcv_radio);
        mListradio = new ArrayList<>();
        radioViewModel rvd = new radioViewModel();
        mListradio = rvd.setView();
        radioAdapter = new radioAdapter(mListradio);
        LinearLayoutManager lm1 = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvradio.setLayoutManager(lm1);
        rcvradio.setAdapter(radioAdapter);
        // view playlist
        rcvplaylist=v.findViewById(R.id.rcv_dexuat);
        lplay= new ArrayList<>();
        playlistViewModel plvd = new playlistViewModel();
        lplay = plvd.setView();
        playlistAdapter = new playlistAdapter(lplay);
        LinearLayoutManager lm2 = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvplaylist.setLayoutManager(lm2);
        rcvplaylist.setAdapter(playlistAdapter);
//        layoutAdapter adapter = new layoutAdapter();
//
//        LinearLayoutManager lm = new LinearLayoutManager(v.getContext(),
//                LinearLayoutManager.VERTICAL,
//                false);
//        rcvmusic.setLayoutManager(lm);
//        rcvmusic.setAdapter(adapter);

//        setView(0,v,rcvmusic);
//        setView(1,v,rcvradio);
//        setView(3,v,rcvplaylist);

    }


//    public void setView(int gtri, View v,RecyclerView rcv) {
//        LinearLayoutManager lm = new LinearLayoutManager(v.getContext());
//        if (gtri == 0) {
//            rcv = v.findViewById(R.id.rcvms);
//            musicViewModel viewModel = new musicViewModel();
//
//            List<music> ls = viewModel.setView();   // gọi data
//            musicAdapter msAdapter = new musicAdapter(ls);
//
//            rcv.setLayoutManager(lm);
//            rcv.setAdapter(msAdapter);
//
//        } else if (gtri == 1) {
//            rcv = v.findViewById(R.id.rcv_radio);
//            radioViewModel viewModel = new radioViewModel();
//
//            List<radio> ls = viewModel.setView();
//            radioAdapter radioAdapter = new radioAdapter(ls);
//
//            rcv.setLayoutManager(lm);
//            rcv.setAdapter(radioAdapter);
//
//        } else {
//            rcv = v.findViewById(R.id.rcv_dexuat);
//            playlistViewModel viewModel = new playlistViewModel();
//
//            List<playlist> ls = viewModel.setView();
//            playlistAdapter playlistAdapter = new playlistAdapter(ls);
//
//            rcv.setLayoutManager(lm);
//            rcv.setAdapter(playlistAdapter);
//        }
//    }

}