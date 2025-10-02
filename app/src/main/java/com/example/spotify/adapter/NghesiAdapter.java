package com.example.spotify.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.models.Nghesi;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NghesiAdapter extends RecyclerView.Adapter<NghesiAdapter.nghesiViewHolder> {
    private List<Nghesi> lnghesi;

    public NghesiAdapter(List<Nghesi> lnghesi) {
        this.lnghesi = lnghesi;
    }

    @NonNull
    @Override
    public nghesiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nghesi,parent,false);
        return new nghesiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull nghesiViewHolder holder, int position) {
        Nghesi ns = lnghesi.get(position);
        if(ns==null)
            return;
        holder.txt_name_nghesi.setText(ns.getTen());
        Picasso.get().load(ns.getAvt()).placeholder(R.drawable.loading).error(R.drawable.warning).into(holder.img_avt_nghesi);
    }

    @Override
    public int getItemCount() {
        if(lnghesi != null)
            return lnghesi.size();
        return 0;
    }
    public class nghesiViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_name_nghesi;
        private ShapeableImageView img_avt_nghesi;
        public nghesiViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name_nghesi = itemView.findViewById(R.id.txt_name_nghesi);
            img_avt_nghesi = itemView.findViewById(R.id.img_avt_nghesi);
        }
    }
}
