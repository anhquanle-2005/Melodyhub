package com.example.eventhub.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventhub.Model.SuKien;
import com.example.eventhub.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SuKienAdapter extends RecyclerView.Adapter<SuKienAdapter.SuKienViewHolder> {
    private List<SuKien> lSuKien;

    public SuKienAdapter(List<SuKien> lSuKien) {
        this.lSuKien = lSuKien;
    }

    @NonNull
    @Override
    public SuKienAdapter.SuKienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sapdienra,parent,false);
        return new SuKienViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SuKienAdapter.SuKienViewHolder holder, int position) {
        SuKien sk = lSuKien.get(position);
        if(sk==null)
            return;
        holder.txt_noidung.setText(sk.getTenSK());
        holder.txt_thoigian.setText(sk.getThoiGian());
        Picasso.get().load(sk.getPoster()).into(holder.img_poster);
        Picasso.get().load(sk.getAVT1()).into(holder.img_avt1);
        Picasso.get().load(sk.getAVT2()).into(holder.img_avt2);
        Picasso.get().load(sk.getAVT3()).into(holder.img_avt3);
        Picasso.get().load(sk.getAVT4()).into(holder.img_avt4);
    }

    @Override
    public int getItemCount() {
        if(lSuKien !=null)
            return lSuKien.size();
        return 0;
    }

    public class SuKienViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_poster;
        private TextView txt_noidung, txt_thoigian;
        private Button btn_thamgia;
        private ShapeableImageView img_avt1, img_avt2, img_avt3, img_avt4;
        public SuKienViewHolder(@NonNull View itemView) {
            super(itemView);
            img_poster = itemView.findViewById(R.id.img_sapdienra_poster);
            txt_noidung = itemView.findViewById(R.id.txt_sapdienra_noidung);
            txt_thoigian = itemView.findViewById(R.id.txt_sapdienra_thoigian);
            img_avt1 = itemView.findViewById(R.id.img_home_avt1);
            img_avt2 = itemView.findViewById(R.id.img_home_avt2);
            img_avt3 = itemView.findViewById(R.id.img_home_avt3);
            img_avt4 = itemView.findViewById(R.id.img_home_avt4);
        }
    }
}
