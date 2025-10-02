package com.example.spotify.views.fragments;
import static com.google.common.reflect.Reflection.getPackageName;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.spotify.R;


public class PlayMusicFragment extends Fragment implements View.OnClickListener{
    public ImageButton btn_previous, btn_pause, btn_next,btn_back;
    private SeekBar sb;
    private Handler handler = new Handler();
    private TextView txt_baihat, txt_tacgia;
    public ExoPlayer player;

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
        txt_baihat.setSelected(true);
        txt_tacgia.setSelected(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Playmusic();
        player.addListener(new Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int state) {
                if (state == Player.STATE_READY) {
                    long duration = player.getDuration();
                    if (duration > 0) {
                        sb.setMax((int) duration);
                    }
                }
            }
        });
        handler.postDelayed(updateSeekBar, 1000);
    }
    private void Playmusic() {
      Uri uri = Uri.parse("android.resource://" + requireContext().getPackageName() + "/"+R.raw.bigteam);
        phatnhac(uri);
    }

    @Override
    public void onClick(View v) {
        ViewMusicFragment music = (ViewMusicFragment) getParentFragmentManager().findFragmentByTag("music");
        if (music != null) {
            ImageView img = music.img_stop;
            if(v.getId()==R.id.btn_pause)
            {
                if(player.isPlaying())
                {
                    player.pause();
                    btn_pause.setImageResource(R.drawable.play_button);
                    img.setImageResource(R.drawable.play_buttton1);
                }
                else {
                    player.play();
                    btn_pause.setImageResource(R.drawable.pause);
                    img.setImageResource(R.drawable.stop);
                }
            }
            if(v.getId()==R.id.btn_back)
            {

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
            if (isAdded()) {

                if (player != null && player.isPlaying()) {
                    sb.setProgress((int) player.getCurrentPosition());
                }
                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(updateSeekBar); // hủy runnable khi fragment bị đóng
    }
    public void phatnhac(Uri url){
        player = new ExoPlayer.Builder(requireContext()).build();
        MediaItem meit = MediaItem.fromUri(url);
        player.setMediaItem(meit);
        player.prepare();
        player.play();
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