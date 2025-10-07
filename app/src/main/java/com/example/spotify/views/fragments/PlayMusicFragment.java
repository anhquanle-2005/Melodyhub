package com.example.spotify.views.fragments;
import static com.example.spotify.Service.MusicServiceHelper.isPlaying;
import static com.google.common.reflect.Reflection.getPackageName;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;


import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.spotify.R;
import com.example.spotify.Service.MusicService;
import com.example.spotify.Service.MusicServiceHelper;
import com.example.spotify.viewModels.MusicViewModel;
import com.squareup.picasso.Picasso;


public class PlayMusicFragment extends Fragment implements View.OnClickListener{
    public ImageButton btn_previous, btn_pause, btn_next,btn_back;
    private SeekBar sb;
    private Handler handler = new Handler();
    private TextView txt_baihat, txt_tacgia;

    private ImageView img_anh;
    private OnBackPressedCallback backCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_play_music, container, false);
        addView(v);
        btn_pause.setOnClickListener(this);
        btn_back.setOnClickListener(this);

        return v;
    }


    private void addView(View v) {
        btn_previous = v.findViewById(R.id.btn_previous);
        btn_pause = v.findViewById(R.id.btn_pause);
        btn_next = v.findViewById(R.id.btn_next);
        sb = v.findViewById(R.id.sb);
        txt_baihat = v.findViewById(R.id.txt_baihat);
        txt_tacgia = v.findViewById(R.id.txt_tentacgia);
        btn_back = v.findViewById(R.id.btn_back);
        img_anh = v.findViewById(R.id.img_play_music_anh);
        txt_baihat.setSelected(true);
        txt_tacgia.setSelected(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        backCallback = new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                if (isVisible()) {
//                    Fragment music = getParentFragmentManager().findFragmentByTag("music");
//                    if (music != null) {
//                        getParentFragmentManager().beginTransaction()
//                                .hide(PlayMusicFragment.this)
//                                .show(music)
//                                .commit();
//                    }
//                } else {
//                    // Nếu fragment không visible → cho back mặc định hoạt động
//                    setEnabled(false);
//                }
//            }
//
//        };
//        // Bind với lifecycle fragment
//        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), backCallback);

        Bundle bl = getArguments();

        if (bl!=null)
        {
            String ten = bl.getString("TenBaiHat");
            String anh = bl.getString("Anh");
            String tacgia = bl.getString("TacGia");
            String url = bl.getString("url");
            txt_baihat.setText(ten);
            txt_tacgia.setText(tacgia);
            Picasso.get().load(anh).placeholder(R.drawable.loading).error(R.drawable.warning).into(img_anh);
            phatnhac(url);
        }

        handler.postDelayed(updateSeekBar, 1000);
        MusicServiceHelper.getCurrentSong().observe(getViewLifecycleOwner(), music -> {
            if (music != null) {
                txt_baihat.setText(music.getTenBaiHat());
                txt_tacgia.setText(music.getTenNgheSi());
                Picasso.get().load(music.getAnh()).into(img_anh);
            }
        });



    }

    @Override
    public void onClick(View v) {
        MediaPlayer player = MusicServiceHelper.getPlayer();
        if (player == null) return;
        ViewMusicFragment music = (ViewMusicFragment) getParentFragmentManager().findFragmentByTag("music");
        if (music != null) {
            ImageView img = music.img_stop;

            if (v.getId() == R.id.btn_pause) {
                if (isPlaying()) {
                    Intent intent = new Intent(requireContext(), MusicService.class);
                    intent.setAction("PAUSE");
                    requireContext().startService(intent);
                    btn_pause.setImageResource(R.drawable.play_button);
                    img.setImageResource(R.drawable.play_buttton1);
                } else {
                    // Gửi lệnh resume
                    Intent intent = new Intent(requireContext(), MusicService.class);
                    intent.setAction("RESUME");
                    requireContext().startService(intent);

                    btn_pause.setImageResource(R.drawable.pause);
                    img.setImageResource(R.drawable.stop);
                }
            }

            if (v.getId() == R.id.btn_back) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.hide(this);
                fr.show(music);
                fr.commit();
            }
        }
    }


    private Runnable updateSeekBar = new Runnable() {
        @Override
        public void run() {
            if (!isAdded()) return;

            MediaPlayer player = MusicServiceHelper.getPlayer(); // <-- Lấy player đang dùng từ Helper
            if (player != null && player.isPlaying()) {
                sb.setMax(player.getDuration());
                sb.setProgress(player.getCurrentPosition());
            }

            handler.postDelayed(this, 1000);
        }
    };




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(updateSeekBar); // hủy runnable khi fragment bị đóng
    }
    private boolean isPlaying() {
        return MusicServiceHelper.isPlaying(); // hàm static hỗ trợ kiểm tra từ service
    }

    public void phatnhac(String url){
        Intent serviceIntent = new Intent(requireContext(), MusicService.class);
        serviceIntent.setAction("PLAY");
        serviceIntent.putExtra("url", url); // link lấy từ API
        requireContext().startService(serviceIntent);
    }
//    @Override
//    public void onStop(){
//
//        super.onStop();
//        if (player != null) {
//            player.release();
//            player = null;
//        }
//    }
}