package com.example.spotify.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.spotify.models.Song;
import java.util.List;
import com.example.spotify.R;
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> songList;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.titleTextView.setText(song.getTitle());
        holder.artistTextView.setText(song.getArtist());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    // Phương thức để cập nhật dữ liệu khi có kết quả tìm kiếm mới
    public void updateSongs(List<Song> newSongs) {
        songList.clear();
        songList.addAll(newSongs);
        notifyDataSetChanged();
    }
    public void filterList(List<Song> filteredList) {
        songList = filteredList;
        notifyDataSetChanged(); // Báo cho RecyclerView biết dữ liệu đã thay đổi để vẽ lại
    }
    static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView artistTextView;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.song_title);
            artistTextView = itemView.findViewById(R.id.song_artist);
        }
    }
}
