package com.example.spotify.views.fragments;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.API.ApiClient;
import com.example.spotify.API.ApiService;
import com.example.spotify.adapter.MusicAdapter;
import com.example.spotify.models.Music;
import com.example.spotify.models.Song;
import com.example.spotify.adapter.SongAdapter;
import com.example.spotify.R;
import com.example.spotify.views.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

   private SearchView searchView;
   private RecyclerView rcvmsr;
   private MusicAdapter musicAdapter;
   private ApiService apiService;
   private Handler handler= new Handler(Looper.getMainLooper());
   private Runnable searchRunnable;
   private ImageButton imgbtnHome,imgbtnSearch,imgbtnLib,imgbtnPre,imgbtnCrea;

//   private List<Song> allSongs;

   private ExoPlayer player1, player2, player3;
   private PlayerView playerView1, playerView2, playerView3;
   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_search, container, false);
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      apiService = ApiClient.getClient().create(ApiService.class);
      searchView = view.findViewById(R.id.search_view);
      rcvmsr = view.findViewById(R.id.rcvmsr);
      playerView1 = view.findViewById(R.id.player_view_1);
      playerView2 = view.findViewById(R.id.player_view_2);
      playerView3 = view.findViewById(R.id.player_view_3);
      setupRecyclerView();
      setupSearchView();
      initViews(view);
      setupClickListeners();
      initializePlayer();
      performSearch("");
   }



   private void initViews(View v) {
      imgbtnHome=v.findViewById(R.id.imgbtn_Home);
      imgbtnSearch=v.findViewById(R.id.imgbtn_Search);
      imgbtnLib=v.findViewById(R.id.imgbtn_Lib);
      imgbtnPre=v.findViewById(R.id.imgbtn_Pre);
      imgbtnCrea=v.findViewById(R.id.imgbtn_Crea);
   }

   private void setupClickListeners() {
      // Nút Home sẽ quay về HomeFragment
      imgbtnHome.setOnClickListener(v -> {
         if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).openFragment(new HomeFragment(), 0);
         }
      });

      // Nút Search chỉ hiển thị thông báo vì đang ở màn hình tìm kiếm
      imgbtnSearch.setOnClickListener(v -> {
         Toast.makeText(getContext(), "Bạn đang ở màn hình Tìm kiếm", Toast.LENGTH_SHORT).show();
      });
      imgbtnPre.setOnClickListener(v -> {
         if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).openFragment(new PremiumFragment(), 0);
         }
      });


      // Các nút khác sẽ hiển thị thông báo
      imgbtnLib.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Thư viện đang phát triển", Toast.LENGTH_SHORT).show());
      imgbtnCrea.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Tạo mới đang phát triển", Toast.LENGTH_SHORT).show());
      playerView1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (player1 != null) {
               if (player1.isPlaying()) {
                  player1.pause();
               } else {
                  player1.play();
               }
            }
         }
      });
      playerView2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v){
            if(player2!=null){
               if(player2.isPlaying()){
                  player2.pause();
               }
               else{
                  player2.play();
               }
            }
         }
      });
   }
   private void setupRecyclerView() {
      rcvmsr.setLayoutManager(new LinearLayoutManager(getContext()));
      musicAdapter = new MusicAdapter(new ArrayList<>());
      rcvmsr.setAdapter(musicAdapter);
   }
   private void setupSearchView() {
      searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
         @Override
         public boolean onQueryTextSubmit(String query) {
//            filter(query);
            handler.removeCallbacks(searchRunnable);
            return true;
         }
         @Override
         public boolean onQueryTextChange(String newText) {
//            filter(newText);
            handler.removeCallbacks(searchRunnable);
            searchRunnable =() -> performSearch(newText);
            handler.postDelayed(searchRunnable, 500);
            return true;
         }
      });
   }

   private void performSearch(String query) {
      apiService.searchMusic(query).enqueue(new Callback<List<Music>>(){
         @Override
         public void onResponse(Call<List<Music>> call, Response<List<Music>> response) {
            if(response.isSuccessful()&&response.body()!=null){
               musicAdapter.setData(response.body());
            }
            else{
               musicAdapter.setData(new ArrayList<>());
               Toast.makeText(getContext(), "Không tìm thấy kết quả", Toast.LENGTH_SHORT).show();
            }

         }

         @Override
         public void onFailure(Call<List<Music>> call, Throwable t) {
         Toast.makeText(getContext(), "Lỗi kết nối", Toast.LENGTH_SHORT).show();

         }
      });

   }

   private void initializePlayer(){
//      player1 = new ExoPlayer.Builder(requireContext()).build();
//      playerView1.setPlayer(player1);
//      MediaItem mediaItem1 = MediaItem.fromUri("");
//      player1.setMediaItem(mediaItem1);
//      player1.prepare();
//
//      player2 = new ExoPlayer.Builder(requireContext()).build();
//      playerView2.setPlayer(player2);
//      MediaItem mediaItem2=MediaItem.fromUri("");
//      player2.setMediaItem(mediaItem2);
//      player2.prepare();
//
//      player3 = new ExoPlayer.Builder(requireContext()).build();
//      playerView3.setPlayer(player3);
//      MediaItem mediaItem3=MediaItem.fromUri("");
//      player3.setMediaItem(mediaItem3);
//      player3.prepare();

      player1 = new ExoPlayer.Builder(requireContext()).build();
      playerView1.setPlayer(player1);
      String path1 = "android.resource://" + requireContext().getPackageName() + "/" + R.raw.nhac1;
      MediaItem mediaItem1 = MediaItem.fromUri(path1);
      player1.setMediaItem(mediaItem1);
      player1.setRepeatMode(Player.REPEAT_MODE_ONE);

      player1.prepare();
//      player1.play();

      player2 = new ExoPlayer.Builder(requireContext()).build();
      playerView2.setPlayer(player2);
      String path2 = "android.resource://" + requireContext().getPackageName() + "/" + R.raw.nhac2;
      MediaItem mediaItem2 = MediaItem.fromUri(path2);
      player2.setMediaItem(mediaItem2);
      player2.setRepeatMode(Player.REPEAT_MODE_ONE);
      player2.prepare();
//
//      player3 = new ExoPlayer.Builder(requireContext()).build();
//      playerView3.setPlayer(player3);
//      String path3 = "android.resource://" + requireContext().getPackageName() + "/" + R.raw.nhac3;
//      MediaItem mediaItem3 = MediaItem.fromUri(path3);
//      player3.setMediaItem(mediaItem3);
//      player3.prepare();



   }
}


