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
import com.squareup.picasso.Picasso;

import java.util.List;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder> {
    private List<Podcast> Lpodcast;

    public PodcastAdapter(List<Podcast> lpodcast) {
        Lpodcast = lpodcast;
    }

    @NonNull
    @Override
    public PodcastAdapter.PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_podcast,parent,false);
        return new PodcastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastAdapter.PodcastViewHolder holder, int position) {
        Podcast pc = Lpodcast.get(position);
        if(pc==null)
            return;
        holder.txt_tacGia.setText(pc.getTacGia());
        holder.txt_noiDung.setText(pc.getTieuDe());
        Picasso.get().load(pc.getUrl()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.img_anh);
        try {
            String colorCode = pc.getColor();
            GradientDrawable border = new GradientDrawable();
            border.setCornerRadius(30);
            border.setColor(Color.parseColor(colorCode));

            holder.item_podcast.setBackground(border);
        } catch (Exception e) {
            GradientDrawable border = new GradientDrawable();
            border.setCornerRadius(30);
            border.setColor(Color.parseColor("#732B17")); // fallback nền
            holder.item_podcast.setBackground(border);
        }


    }

    @Override
    public int getItemCount() {
        if(Lpodcast != null)
            return Lpodcast.size();
        return 0;
    }

    public class PodcastViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_anh,img_play;
        private TextView txt_noiDung, txt_tacGia;
        LinearLayout item_podcast;
        public PodcastViewHolder(@NonNull View itemView) {
            super(itemView);
            img_anh = itemView.findViewById(R.id.img_podcast_anh);
            img_play = itemView.findViewById(R.id.img_podcast_play);
            txt_noiDung = itemView.findViewById(R.id.txt_podcast_noidung);
            txt_tacGia = itemView.findViewById(R.id.txt_podcast_tacgia);
            item_podcast = itemView.findViewById(R.id.item_podcast);
        }
    }
}
