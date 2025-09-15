package com.example.spotify.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.models.music;
import com.squareup.picasso.Picasso;

import java.util.List;

public class musicAdapter extends RecyclerView.Adapter<musicAdapter.musicViewHolder>{
    private List<music> mmusicList;

    public musicAdapter(List<music> mmusicList) {
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
        music ms = mmusicList.get(position);
        if(ms==null)
        {
            return;
        }
        holder.txt_tenBaiHat.setText(ms.getTenbaiHat());
        holder.txt_tacgia.setText(ms.getTacGia());
        Picasso.get().load(ms.getUrl()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        if(mmusicList != null)
        {
            return mmusicList.size();
        }
        return 0;
    }

    class musicViewHolder extends RecyclerView.ViewHolder{
        private ImageView poster;
        private TextView txt_tenBaiHat,txt_tacgia;
        public musicViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            txt_tenBaiHat = itemView.findViewById(R.id.txt_tenBaiHat);
            txt_tacgia = itemView.findViewById(R.id.txt_tacgia);
        }
    }
}
