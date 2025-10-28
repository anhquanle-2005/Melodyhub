package com.example.eventhub.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventhub.Model.SuKienSapToi;
import com.example.eventhub.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SuKienSapToiAdapter extends RecyclerView.Adapter<SuKienSapToiAdapter.SuKienSapToiViewHolder> {
    private List<SuKienSapToi> lsk;

    public SuKienSapToiAdapter(List<SuKienSapToi> lsk) {
        this.lsk = lsk;
    }

    @NonNull
    @Override
    public SuKienSapToiAdapter.SuKienSapToiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sukien,parent,false);
        return new SuKienSapToiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SuKienSapToiAdapter.SuKienSapToiViewHolder holder, int position) {
        SuKienSapToi sk = lsk.get(position);
        if(sk==null)
            return;
        holder.txt_thoigian.setText(sk.getThoiGian());
        holder.txt_noidung.setText(sk.getTenSK());
        holder.txt_coso.setText(sk.getCoSo());
        Picasso.get().load(sk.getPoster()).into(holder.img_poster);
    }

    @Override
    public int getItemCount() {
        if(lsk!=null)
            return lsk.size();
        return 0;
    }

    public class SuKienSapToiViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_thoigian, txt_noidung, txt_coso;
        private ImageView img_poster;
        private Button btn_thamgia;
        public SuKienSapToiViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_thoigian = itemView.findViewById(R.id.txt_saptoi_thoigian);
            txt_noidung = itemView.findViewById(R.id.txt_saptoi_noidung);
            txt_coso = itemView.findViewById(R.id.txt_saptoi_coso);
            img_poster = itemView.findViewById(R.id.img_saptoi_poster);
            btn_thamgia = itemView.findViewById(R.id.btn_saptoi_thamgia);
        }
    }
}
