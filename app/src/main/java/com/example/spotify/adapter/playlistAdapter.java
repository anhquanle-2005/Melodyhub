package com.example.spotify.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.models.playlist;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class playlistAdapter extends RecyclerView.Adapter<playlistAdapter.playlistViewHolder> {
    private List<playlist> Lplay;

    public playlistAdapter(List<playlist> lplay) {
        Lplay = lplay;
    }

    @NonNull
    @Override
    public playlistAdapter.playlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist,parent,false);
        return new playlistViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull playlistAdapter.playlistViewHolder holder, int position) {
        playlist pl = Lplay.get(position);
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
        public playlistViewHolder(@NonNull View itemView) {
            super(itemView);
            img_anh = itemView.findViewById(R.id.anhPT);
            txt_BH = itemView.findViewById(R.id.txt_BH);
            txt_nghesi1 = itemView.findViewById(R.id.txt_ngheSi1);
        }
    }
}