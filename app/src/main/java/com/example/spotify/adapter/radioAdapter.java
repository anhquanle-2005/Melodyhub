package com.example.spotify.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.models.radio;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class radioAdapter extends RecyclerView.Adapter<radioAdapter.radioViewHolder> {
    private List<radio> Lrdo;

    public radioAdapter(List<radio> lrdo) {
        Lrdo = lrdo;
    }

    @NonNull
    @Override
    public radioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio, parent, false);
        return new radioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull radioViewHolder holder, int position) {
        radio rd = Lrdo.get(position);
        if (rd == null)
            return;
        holder.txt_name.setText(rd.getTxt_name());
        holder.txt_nghesi.setText(rd.getTxt_ngheSi());
        Picasso.get().load(rd.getUrl1()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.img1);
        Picasso.get().load(rd.getUrl2()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.img2);
        Picasso.get().load(rd.getUrl3()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.img3);
    }

    @Override
    public int getItemCount() {
        if (Lrdo != null)
            return Lrdo.size();
        return 0;
    }

    public class radioViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView img1, img2, img3;
        TextView txt_name, txt_nghesi;

        public radioViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.CD1);
            img2 = itemView.findViewById(R.id.CD2);
            img3 = itemView.findViewById(R.id.CD3);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_nghesi = itemView.findViewById(R.id.txt_ngheSi);
        }
    }
}






