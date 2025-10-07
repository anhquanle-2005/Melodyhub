package com.example.spotify.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.models.Podcast;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PodcastTatcaAdapter extends RecyclerView.Adapter<PodcastTatcaAdapter.PodcastTatcaViewHolder> {
    private List<Podcast> lPodcast;

    public PodcastTatcaAdapter(List<Podcast> lPodcast) {
        this.lPodcast = lPodcast;
    }

    @NonNull
    @Override
    public PodcastTatcaAdapter.PodcastTatcaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_podcast_tatca,parent,false);
        return new PodcastTatcaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastTatcaAdapter.PodcastTatcaViewHolder holder, int position) {
        Podcast pc = lPodcast.get(position);
        if(pc==null)
            return;
        holder.txt_tacgia.setText(pc.getTacGia());
        holder.txt_tacgia2.setText(pc.getTacGia());
        holder.txt_noiDung.setText(pc.getTieuDe());
        Picasso.get().load(pc.getUrl()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.img_anh);
        Picasso.get().load(pc.getUrl()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.img_anh2);
        try {
            String color = pc.getColor();
            GradientDrawable dg =new GradientDrawable();
            dg.setCornerRadius(30);
            dg.setColor(Color.parseColor(color));
            holder.lnl_podcast.setBackground(dg);
        }catch (Exception e){
            GradientDrawable border = new GradientDrawable();
            border.setCornerRadius(30);
            border.setColor(Color.parseColor("#732B17")); // fallback nền
            holder.lnl_podcast.setBackground(border);
        }
    }

    @Override
    public int getItemCount() {
        if(lPodcast!=null)
            return lPodcast.size();
        return 0;
    }
    public class PodcastTatcaViewHolder extends RecyclerView.ViewHolder {
        private ShapeableImageView img_anh, img_anh2;
        private ImageView img_play;
        private TextView txt_tacgia,txt_tacgia2,txt_noiDung;
        private LinearLayout lnl_podcast;
        public PodcastTatcaViewHolder(@NonNull View itemView) {
            super(itemView);
            img_anh = itemView.findViewById(R.id.img_podcast_tatca_anh);
            img_anh2 = itemView.findViewById(R.id.img_podcast_tatca_anh2);
            txt_tacgia = itemView.findViewById(R.id.txt_podcast_tatca_tacgia);
            txt_tacgia2 = itemView.findViewById(R.id.txt_podcast_tatca_tacgia2);
            txt_noiDung = itemView.findViewById(R.id.txt_podcast_tatca_noidung);
            img_play = itemView.findViewById(R.id.img_podcast_tatca_play);
            lnl_podcast = itemView.findViewById(R.id.lnl_podcast);
        }
    }
}
