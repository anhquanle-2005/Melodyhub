package com.example.spotify.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.models.Music;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.musicViewHolder>{
    private List<Music> mmusicList;
    private OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(Music ms);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public MusicAdapter(List<Music> mmusicList) {
        this.mmusicList = mmusicList;
    }

    @NonNull
    @Override
    public musicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music,parent,false);
        return new musicViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull musicViewHolder holder, int position) {
        Music ms = mmusicList.get(position);
        if(ms==null)
        {
            return;
        }
        holder.txt_tenBaiHat.setText(ms.getTenBaiHat());
        holder.txt_tacgia.setText(ms.getTenNgheSi());
        Picasso.get().load(ms.getAnh()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        if(mmusicList != null)
        {
            return mmusicList.size();
        }
        return 0;
    }
    public void setData(List<Music> newList) {
        this.mmusicList.clear();
        if (newList != null) {
            this.mmusicList.addAll(newList);
        }
        notifyDataSetChanged();
    }

    class musicViewHolder extends RecyclerView.ViewHolder{
        private ImageView poster;
        LinearLayout item_music;
        private TextView txt_tenBaiHat,txt_tacgia;
        public musicViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            item_music = itemView.findViewById(R.id.item_music);
            txt_tenBaiHat = itemView.findViewById(R.id.txt_tenBaiHat);
            txt_tacgia = itemView.findViewById(R.id.txt_tacgia);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getBindingAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(mmusicList.get(position));
                        }
                    }
                }
            });
        }

    }
}