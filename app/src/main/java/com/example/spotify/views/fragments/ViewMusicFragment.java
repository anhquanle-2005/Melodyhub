package com.example.spotify.views.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.example.spotify.Service.MusicService;
import com.example.spotify.Service.MusicServiceHelper;
import com.squareup.picasso.Picasso;


public class ViewMusicFragment extends Fragment implements View.OnClickListener{
    public ImageView img_stop, img_them,img_anh;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MusicServiceHelper.getCurrentSong().observe(getViewLifecycleOwner(), music -> {
            if(music !=null)
            {
                txt_baiHat.setText(music.getTenBaiHat());
                txt_tacGia.setText(music.getTenNgheSi());
                Picasso.get().load(music.getAnh()).into(img_anh);
            }
        });
    }

    private void addView(View v) {
        img_stop = v.findViewById(R.id.vm_stop);
        img_them = v.findViewById(R.id.vm_them);
        img_anh=v.findViewById(R.id.img_view_music_anh);
        txt_baiHat = v.findViewById(R.id.vm_baiHat);
        txt_tacGia = v.findViewById(R.id.vm_tentacgia);
        layout_view_music = v.findViewById(R.id.layout_view_music);
        txt_baiHat.setSelected(true);
        txt_tacGia.setSelected(true);
        Bundle bl = getArguments();

        if (bl!=null)
        {
            String ten = bl.getString("TenBaiHat");
            String anh = bl.getString("Anh");
            String tacgia = bl.getString("TacGia");
            String url = bl.getString("url");
            txt_baiHat.setText(ten);
            txt_tacGia.setText(tacgia);
            Picasso.get().load(anh).placeholder(R.drawable.loading).error(R.drawable.warning).into(img_anh);

        }
    }
    private boolean isPlaying() {
        return MusicServiceHelper.isPlaying(); // hàm static hỗ trợ kiểm tra từ service
    }
    @Override
    public void onClick(View v) {
            PlayMusicFragment playlist = (PlayMusicFragment) getParentFragmentManager().findFragmentByTag("PlayMusic");
            if (playlist != null) {
                ImageButton img = playlist.btn_pause;
                if(v.getId()==R.id.vm_stop)
                {
                    if(isPlaying())
                    {
                        Intent intent = new Intent(requireContext(), MusicService.class);
                        intent.setAction("PAUSE");
                        requireContext().startService(intent);
                        img_stop.setImageResource(R.drawable.play_buttton1);
                        img.setImageResource(R.drawable.play_button);
                    }
                    else{
                        Intent intent = new Intent(requireContext(), MusicService.class);
                        intent.setAction("RESUME");
                        requireContext().startService(intent);
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