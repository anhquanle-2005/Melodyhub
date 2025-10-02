package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.media3.exoplayer.ExoPlayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.spotify.R;


public class ViewMusicFragment extends Fragment implements View.OnClickListener{
    public ImageView img_stop, img_them;
    private LinearLayout layout_view_music;
    private TextView txt_baiHat, txt_tacGia;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_music, container, false);
        addView(v);
        img_stop.setOnClickListener(this);
        layout_view_music.setOnClickListener(this);
        return v;
    }

    private void addView(View v) {
        img_stop = v.findViewById(R.id.vm_stop);
        img_them = v.findViewById(R.id.vm_them);
        txt_baiHat = v.findViewById(R.id.vm_baiHat);
        txt_tacGia = v.findViewById(R.id.vm_tentacgia);
        layout_view_music = v.findViewById(R.id.layout_view_music);
        txt_baiHat.setSelected(true);
        txt_tacGia.setSelected(true);
    }

    @Override
    public void onClick(View v) {
            PlayMusicFragment playlist = (PlayMusicFragment) getParentFragmentManager().findFragmentByTag("PlayMusic");
            if (playlist != null) {
                ImageButton img = playlist.btn_pause;
                ExoPlayer play = playlist.player;
                if(v.getId()==R.id.vm_stop)
                {
                    if(play.isPlaying())
                    {
                        play.pause();
                        img_stop.setImageResource(R.drawable.play_buttton1);
                        img.setImageResource(R.drawable.play_button);
                    }
                    else{
                        play.play();
                        img_stop.setImageResource(R.drawable.stop);
                        img.setImageResource(R.drawable.pause);
                    }
                }
                if(v.getId()==R.id.layout_view_music)
                {
                    FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                    fr.show(playlist);
                    fr.hide(this);
                    fr.commit();
                }
            }
    }
}