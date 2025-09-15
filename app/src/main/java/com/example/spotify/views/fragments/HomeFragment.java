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

import com.example.spotify.R;

import com.example.spotify.adapter.musicAdapter;
import com.example.spotify.adapter.playlistAdapter;
import com.example.spotify.adapter.radioAdapter;
import com.example.spotify.models.music;
import com.example.spotify.models.playlist;
import com.example.spotify.models.radio;
import com.example.spotify.viewModels.musicViewModel;
import com.example.spotify.viewModels.playlistViewModel;
import com.example.spotify.viewModels.radioViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView rcvmusic;
    private List<music> mListmusic;
    private musicAdapter msAdapter;
    private RecyclerView rcvradio;
    private List<radio> mListradio;
    private radioAdapter radioAdapter;
    private RecyclerView rcvplaylist;
    private List<playlist> lplay;
    private playlistAdapter playlistAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_home, container, false);
        addView(v);
       FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
       fr.add(R.id.container_body,new header_homeFragment());
       fr.commit();
        return v;
    }

    private void addView(View v) {




        rcvmusic=v.findViewById(R.id.rcvms);
        mListmusic = new ArrayList<>();
        musicViewModel mvd = new musicViewModel();
        mListmusic = mvd.setView();
         msAdapter = new musicAdapter(mListmusic);
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