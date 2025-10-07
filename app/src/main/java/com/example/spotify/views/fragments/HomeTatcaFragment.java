package com.example.spotify.views.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spotify.API.ApiCallback;
import com.example.spotify.API.ApiClient;
import com.example.spotify.API.ApiResponse;
import com.example.spotify.API.IAPI;
import com.example.spotify.R;
import com.example.spotify.Service.MusicService;
import com.example.spotify.adapter.MusicAdapter;
import com.example.spotify.adapter.NghesiAdapter;
import com.example.spotify.adapter.PlaylistAdapter;
import com.example.spotify.adapter.PodcastAdapter;
import com.example.spotify.adapter.PodcastTatcaAdapter;
import com.example.spotify.adapter.RadioAdapter;
import com.example.spotify.models.Music;
import com.example.spotify.models.Nghesi;
import com.example.spotify.models.Playlist;
import com.example.spotify.models.Podcast;
import com.example.spotify.models.Radio;
import com.example.spotify.viewModels.MusicViewModel;
import com.example.spotify.viewModels.NghesiViewModel;
import com.example.spotify.viewModels.PlaylistViewModel;
import com.example.spotify.viewModels.PodcastViewModel;
import com.example.spotify.viewModels.RadioViewModel;
import com.example.spotify.views.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;


public class HomeTatcaFragment extends Fragment {
    private RecyclerView rcvmusic,rcvradio,rcvplaylist, rcvnghesi,rcv_podcast;
    private List<Music> mListmusic;
    private MusicAdapter msAdapter;
    private List<Radio> mListradio;
    private RadioAdapter radioAdapter;
    private List<Playlist> lplay;
    private List<Nghesi> lnghesi;
    private NghesiAdapter nsAdapter;
    private PlaylistAdapter playlistAdapter;
    private PodcastTatcaAdapter podcastAdapter;
    private List<Podcast> lPodcast;
    int i =0;

    private String ktra="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_tatca, container, false);
        addView(v);
        addViewPodcast(v);
        return v;
    }

    private void addViewPodcast(View v) {
        rcv_podcast = v.findViewById(R.id.rcv_tatca_padcast);
        lPodcast = new ArrayList<>();
        PodcastViewModel podcastVM = new PodcastViewModel();
        lPodcast = podcastVM.setPodcast();
        podcastAdapter = new PodcastTatcaAdapter(lPodcast);
        LinearLayoutManager lm = new LinearLayoutManager(v.getContext());
        rcv_podcast.setLayoutManager(lm);
        rcv_podcast.setAdapter(podcastAdapter);
    }


    private void addView(View v) {

        rcvmusic = v.findViewById(R.id.rcvms);
        rcvmusic.setLayoutManager(new LinearLayoutManager(v.getContext()));

        MusicViewModel viewModel = new ViewModelProvider(requireActivity()).get(MusicViewModel.class);

        viewModel.getMusicList().observe(getViewLifecycleOwner(), musicList -> {
            if (musicList != null) {
                msAdapter = new MusicAdapter(musicList);
                rcvmusic.setAdapter(msAdapter);

                msAdapter.setOnItemClickListener(ms -> {
                    for (Music music : musicList) {
                        if (ms.getTenBaiHat().equals(music.getTenBaiHat())) {

                            Bundle bl = new Bundle();
                            bl.putString("TenBaiHat", music.getTenBaiHat());
                            bl.putString("Anh", music.getAnh());
                            bl.putString("TacGia", music.getTenNgheSi());
                            bl.putString("url", music.getDuongDan());

                            ViewMusicFragment vm = new ViewMusicFragment();
                            PlayMusicFragment pl = new PlayMusicFragment();
                            vm.setArguments(bl);
                            pl.setArguments(bl);

                            boolean sameSong = ktra != null && ktra.equals(music.getTenBaiHat());
                            ((MainActivity) requireActivity()).showFragment(pl, "PlayMusic", sameSong);
                            ((MainActivity) requireActivity()).addFragmentMusic(vm, "music", sameSong);

                            ktra = music.getTenBaiHat();
                            ArrayList<Music> playlist = new ArrayList<>(musicList);
                            Intent intent = new Intent(requireContext(), MusicService.class);
                            intent.setAction("PLAYLIST");
                            intent.putExtra("playlist",playlist);
                            intent.putExtra("vitri",i);
                            requireContext().startService(intent);
                            break;
                        }
                        i++;
                    }
                });
            }
        });


        viewModel.getErrorMessage().observe(getViewLifecycleOwner(), error -> {
            if (error != null) {
                Toast.makeText(v.getContext(), "Lỗi tải nhạc: " + error, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.loadMusic();


        //view radio
        rcvradio=v.findViewById(R.id.rcv_radio);
        mListradio = new ArrayList<>();
        RadioViewModel rvd = new RadioViewModel();
        mListradio = rvd.setView();
        radioAdapter = new RadioAdapter(mListradio);
        LinearLayoutManager lm1 = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvradio.setLayoutManager(lm1);
        rcvradio.setAdapter(radioAdapter);
        // view playlist
        rcvplaylist=v.findViewById(R.id.rcv_dexuat);
        lplay= new ArrayList<>();
        PlaylistViewModel plvd = new PlaylistViewModel();
        lplay = plvd.setView();
        playlistAdapter = new PlaylistAdapter(lplay);
        LinearLayoutManager lm2 = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcvplaylist.setLayoutManager(lm2);
        rcvplaylist.setAdapter(playlistAdapter);
        // View nghe si
        rcvnghesi = v.findViewById(R.id.rcv_nghesi);
        lnghesi = new ArrayList<>();
        NghesiViewModel nsVM = new NghesiViewModel();
        lnghesi = nsVM.addView();
        nsAdapter = new NghesiAdapter(lnghesi);
        LinearLayoutManager lm3 = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL, false);
        rcvnghesi.setLayoutManager(lm3);
        rcvnghesi.setAdapter(nsAdapter);
    }

}