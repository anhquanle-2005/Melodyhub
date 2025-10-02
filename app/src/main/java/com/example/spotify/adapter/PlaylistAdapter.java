package com.example.spotify.adapter;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.models.Playlist;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.playlistViewHolder> {
    private List<Playlist> Lplay;

    public PlaylistAdapter(List<Playlist> lplay) {
        Lplay = lplay;
    }

    @NonNull
    @Override
    public PlaylistAdapter.playlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist,parent,false);
        return new playlistViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.playlistViewHolder holder, int position) {
        Playlist pl = Lplay.get(position);
        int marginInDp = 10;
        int marginInPx = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                marginInDp,
                holder.item_playlist.getContext().getResources().getDisplayMetrics()
        );
        if(position==0)
        {
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.item_playlist.getLayoutParams();
            params.leftMargin = marginInPx;
            holder.item_playlist.setLayoutParams(params);
        }
        if(position==Lplay.size()-1)
        {
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.item_playlist.getLayoutParams();
            params.rightMargin = marginInPx;
            holder.item_playlist.setLayoutParams(params);
        }
        if(pl==null)
            return;
        holder.txt_BH.setText(pl.getTxt_bh());
        holder.txt_nghesi1.setText(pl.getTxt_nghesi());
        Picasso.get().load(pl.getUrl()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.img_anh);
    }

    @Override
    public int getItemCount() {
        if(Lplay !=null)
            return Lplay.size();
        return 0;
    }

    public class playlistViewHolder extends RecyclerView.ViewHolder {
        ImageView img_anh;
        TextView txt_BH, txt_nghesi1;
        LinearLayout item_playlist;
        public playlistViewHolder(@NonNull View itemView) {
            super(itemView);
            img_anh = itemView.findViewById(R.id.anhPT);
            item_playlist = itemView.findViewById(R.id.item_playlist);
            txt_BH = itemView.findViewById(R.id.txt_BH);
            txt_nghesi1 = itemView.findViewById(R.id.txt_ngheSi1);
        }
    }
}
