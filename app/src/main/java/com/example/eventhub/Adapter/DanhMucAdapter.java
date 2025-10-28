package com.example.eventhub.Adapter;

import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventhub.Model.DanhMuc;
import com.example.eventhub.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.DanhMucViewHolder> {
    private List<DanhMuc> ldm;

    public DanhMucAdapter(List<DanhMuc> ldm) {
        this.ldm = ldm;
    }

    @NonNull
    @Override
    public DanhMucAdapter.DanhMucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhmuc,parent,false);
        return new DanhMucViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhMucAdapter.DanhMucViewHolder holder, int position) {
        DanhMuc danhMuc = ldm.get(position);
        if(danhMuc==null)
            return;
        holder.btn_danhmuc.setText(danhMuc.getText());
        Picasso.get().load(danhMuc.getAnh()).into(holder.img_danhmuc);
    }

    @Override
    public int getItemCount() {
        if(ldm!=null)
            return ldm.size();
        return 0;
    }

    public class DanhMucViewHolder extends RecyclerView.ViewHolder {
        private Button btn_danhmuc;
        private ImageView img_danhmuc;
        public DanhMucViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_danhmuc = itemView.findViewById(R.id.btn_home_music);
            img_danhmuc = itemView.findViewById(R.id.img_home_music);
        }
    }
}
