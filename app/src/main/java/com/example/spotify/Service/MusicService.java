package com.example.spotify.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.spotify.models.Music;
import com.example.spotify.viewModels.MusicViewModel;
import com.example.spotify.views.fragments.PlayMusicFragment;
import com.example.spotify.views.fragments.ViewMusicFragment;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;
    private int currentPosition = 0;
    private ArrayList<Music> playlist;
    private String currentUrl = "";

    private int currentIndex ;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(mp -> {
           stopSelf();
        });
        MusicServiceHelper.setPlayer(mediaPlayer);
    }

    private void NextSong() {
        currentIndex++;
        if (currentIndex < playlist.size()) {
           MusicServiceHelper.setCurrentSong(playlist.get(currentIndex));

            playNewSong(playlist.get(currentIndex).getDuongDan());
        } else {
            stopSelf(); // hết playlist thì dừng service
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getAction();

            if ("PLAY".equals(action)) {
                String url = intent.getStringExtra("url");
                if (url != null && !url.equals(currentUrl)) {
                    playNewSong(url);
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    MusicServiceHelper.setPlaying(true);
                }

            } else if ("PAUSE".equals(action)) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    currentPosition = mediaPlayer.getCurrentPosition();
                    MusicServiceHelper.setPlaying(false);
                }

            } else if ("RESUME".equals(action)) {
                mediaPlayer.seekTo(currentPosition);
                mediaPlayer.start();
                MusicServiceHelper.setPlaying(true);

            } else if ("STOP".equals(action)) {
                stopSelf();
                MusicServiceHelper.setPlaying(false);
            }else if ("PLAYLIST".equals(action)) {
                playlist = (ArrayList<Music>) intent.getSerializableExtra("playlist");
                currentIndex = intent.getIntExtra("vitri",0);
            }

        }

        return START_STICKY; // Giữ service chạy nền
    }

    private void playNewSong(String url) {
        try {
            currentUrl = url;
            mediaPlayer.reset();
            mediaPlayer.setDataSource(url); // URL từ API
            mediaPlayer.setOnPreparedListener(mp -> {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            });
            MusicServiceHelper.setPlaying(true);
            mediaPlayer.prepareAsync(); // tải nhạc không chặn luồng chính
        } catch (Exception e) {
            Log.e("MusicService", "Lỗi phát nhạc: " + e.getMessage(), e);
        }
    }


//    @Override
//    public void onDestroy() {
//        if (mediaPlayer != null) {
//            if (mediaPlayer.isPlaying()) {
//                mediaPlayer.stop();
//            }
//            mediaPlayer.release();
//            mediaPlayer = null;
//        }
//        super.onDestroy();
//    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
