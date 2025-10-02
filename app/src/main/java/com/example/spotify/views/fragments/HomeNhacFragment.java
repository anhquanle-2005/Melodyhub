package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.R;
import com.example.spotify.adapter.NghesiAdapter;
import com.example.spotify.adapter.PlaylistAdapter;
import com.example.spotify.adapter.RadioAdapter;
import com.example.spotify.models.Nghesi;
import com.example.spotify.models.Playlist;
import com.example.spotify.models.Radio;
import com.example.spotify.viewModels.NghesiViewModel;
import com.example.spotify.viewModels.PlaylistViewModel;
import com.example.spotify.viewModels.RadioViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeNhacFragment extends Fragment {
    private RecyclerView rdo,rcv_nhesi, rcv_album;
    private List<Radio> Lrdo;
    private RadioAdapter rdoAdapter;
    private List<Nghesi> lNgheSi;
    private NghesiAdapter nghesiAdapter;
    private PlaylistAdapter albumAdapter;
    private List<Playlist> lAlbum;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v =inflater.inflate(R.layout.fragment_home_nhac, container, false);
      addViewRadio(v);
      addViewNghesi(v);
      addViewAlbum(v);
      return v;
    }

    private void addViewAlbum(View v) {
        rcv_album = v.findViewById(R.id.rcv_nhac_album);
        lAlbum = new ArrayList<>();
        PlaylistViewModel albumVM = new PlaylistViewModel();
        lAlbum = albumVM.setView();
        albumAdapter = new PlaylistAdapter(lAlbum);
        LinearLayoutManager lm = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcv_album.setLayoutManager(lm);
        rcv_album.setAdapter(albumAdapter);
    }

    private void addViewNghesi(View v) {
        rcv_nhesi = v.findViewById(R.id.rcv_nhac_nghesi);
        lNgheSi = new ArrayList<>();
        NghesiViewModel nghs = new NghesiViewModel();
        lNgheSi = nghs.addView();
        nghesiAdapter = new NghesiAdapter(lNgheSi);
        LinearLayoutManager ln = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcv_nhesi.setLayoutManager(ln);
        rcv_nhesi.setAdapter(nghesiAdapter);
    }

    private void addViewRadio(View v) {
        rdo = v.findViewById(R.id.rcv_radio2);
        Lrdo = new ArrayList<>();
        RadioViewModel rdoVM =new RadioViewModel();
        Lrdo=rdoVM.setView();
        rdoAdapter = new RadioAdapter(Lrdo);
        LinearLayoutManager ln = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rdo.setLayoutManager(ln);
        rdo.setAdapter(rdoAdapter);
    }
}