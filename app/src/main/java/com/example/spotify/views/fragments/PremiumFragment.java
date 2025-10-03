package com.example.spotify.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.R;
import com.example.spotify.models.premiumReason;
import com.example.spotify.views.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class PremiumFragment extends Fragment {
    private RecyclerView rcvpre ;
    private LayoutInflater inflater;
    private LinearLayout llReasons;
    private ImageButton imgbtnHome,imgbtnSearch,imgbtnLib,imgbtnPre,imgbtnCrea;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Gắn layout XML vào Fragmenth
        return inflater.inflate(R.layout.fragment_premium, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupClickListener();

        populatePremiumReasons();

    }
    private void initViews(View v){
        llReasons=v.findViewById(R.id.ll_Reasons);
        imgbtnHome=v.findViewById(R.id.imgbtn_Home);
        imgbtnSearch=v.findViewById(R.id.imgbtn_Search);
        imgbtnLib=v.findViewById(R.id.imgbtn_Lib);
        imgbtnPre=v.findViewById(R.id.imgbtn_Pre);
        imgbtnCrea=v.findViewById(R.id.imgbtn_Crea);
    }
    private void populatePremiumReasons() {
        List<premiumReason> reasonList = new ArrayList<>();
        reasonList.add(new premiumReason(R.drawable.imgnotqc,"Nghe nhạc không quảng cáo"));
        reasonList.add(new premiumReason(R.drawable.imgdow,"Tải xuống để nghe không cần mạng"));
        reasonList.add(new premiumReason(R.drawable.imgthutu,"Phát nhạc theo thứ tự bất kỳ"));
        reasonList.add(new premiumReason(R.drawable.imgheadphone,"Chất lượng âm thanh cao"));
        reasonList.add(new premiumReason(R.drawable.imgpeople,"Nghe cùng bạn bè theo thời gian thực"));
        reasonList.add(new premiumReason(R.drawable.imgds,"Sắp xếp danh sách chờ nghe"));
        LayoutInflater inflater = LayoutInflater.from(getContext());
        llReasons.removeAllViews();
        for(premiumReason reason : reasonList ){
            View itemview = inflater.inflate(R.layout.item_prereason,llReasons,false);
            ImageView iconreason = itemview.findViewById(R.id.icon_reason);
            TextView textreason = itemview.findViewById(R.id.text_reason_title);
            iconreason.setImageResource(reason.getIconRestid());
            textreason.setText(reason.getTitle());
            llReasons.addView(itemview);

        }

    }
    public void setupClickListener(){
        imgbtnHome.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openFragment(new HomeFragment(), 0);
            }
        });
        imgbtnSearch.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openFragment(new SearchFragment(), 0);
            }
        });
        imgbtnPre.setOnClickListener(v ->{
            if (getActivity() instanceof MainActivity) {
                Toast.makeText(getContext(), "Bạn đang ở màn hình premium", Toast.LENGTH_SHORT).show();
            }
        });
    }
}