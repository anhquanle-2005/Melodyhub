package com.example.eventhub.View.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eventhub.Adapter.SuKienSapToiAdapter;
import com.example.eventhub.ViewModel.SuKienViewModel;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eventhub.Adapter.DanhMucAdapter;
import com.example.eventhub.Adapter.SuKienAdapter;
import com.example.eventhub.Model.DanhMuc;
import com.example.eventhub.R;
import com.example.eventhub.ViewModel.SuKienViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private List<DanhMuc> lDanhMuc;
    private SuKienAdapter suKienAdapter;
    private RecyclerView rcv_danhmuc,rcv_sapdienra,rcv_saptoi,rcv_danhchobn;
    private DanhMucAdapter danhMucAdapter;
    private SuKienSapToiAdapter suKienSapToiAdapter;
    private SuKienSapToiAdapter suKienDanhchobnAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_home, container, false);
        adddanhMuc(v);
        addSKsapDienRa(v);
        addSKSapToi(v);
        addSKDanhchobn(v);
        return v;
    }

    private void addSKDanhchobn(View v) {
        rcv_danhchobn = v.findViewById(R.id.rcv_home_danhchoban);
        rcv_danhchobn.setLayoutManager(new LinearLayoutManager(v.getContext()));
        SuKienViewModel sk = new ViewModelProvider(requireActivity()).get(SuKienViewModel.class);
        sk.getlSuKiendanhchobn().observe(getViewLifecycleOwner(),lsk->{
            suKienDanhchobnAdapter= new SuKienSapToiAdapter(lsk);
            rcv_danhchobn.setAdapter(suKienDanhchobnAdapter);
        });
        sk.load_SK_danhchobn();
    }

    private void addSKSapToi(View v) {
        rcv_saptoi = v.findViewById(R.id.rcv_home_sukien);
        rcv_saptoi.setLayoutManager(new GridLayoutManager(v.getContext(),2,RecyclerView.HORIZONTAL,false));
        SuKienViewModel skvm = new ViewModelProvider(requireActivity()).get(SuKienViewModel.class);
        skvm.getlSuKienSapToi().observe(getViewLifecycleOwner(),ls->{
            if(ls!=null)
            {
                suKienSapToiAdapter = new SuKienSapToiAdapter(ls);
                rcv_saptoi.setAdapter(suKienSapToiAdapter);
            }
        });
        skvm.load_SK_SapToi();
    }

    private void addSKsapDienRa(View v) {
        rcv_sapdienra = v.findViewById(R.id.rcv_home_sapdienra);
        rcv_sapdienra.setLayoutManager(new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false));
        SuKienViewModel skvm = new ViewModelProvider(requireActivity()).get(SuKienViewModel.class);
        skvm.getlSuKien().observe(getViewLifecycleOwner(), lsk ->{
            if(lsk!=null)
            {
                suKienAdapter= new SuKienAdapter(lsk);
                rcv_sapdienra.setAdapter(suKienAdapter);
            }
        });
        skvm.loadSuKien();
    }

    private void adddanhMuc(View v) {
        rcv_danhmuc = v.findViewById(R.id.rcv_danhmuc);
        lDanhMuc = new ArrayList<>();
        lDanhMuc.add( new DanhMuc("Music",R.drawable.music));
        lDanhMuc.add( new DanhMuc("WorkShop",R.drawable.vector));
        lDanhMuc.add( new DanhMuc("Chủ nhật xanh",R.drawable.cnx));
        lDanhMuc.add( new DanhMuc("Music",R.drawable.music));
        danhMucAdapter = new DanhMucAdapter(lDanhMuc);
        LinearLayoutManager lm = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rcv_danhmuc.setLayoutManager(lm);
        rcv_danhmuc.setAdapter(danhMucAdapter);
    }


}