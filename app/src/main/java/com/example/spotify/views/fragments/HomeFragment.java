package com.example.spotify.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify.R;


public class HomeFragment extends Fragment {

    public int selectedId =-1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_home, container, false);
        addfragnent(new HeaderHomeFragment(), new FooterFragment());
        addBody(new HomeTatcaFragment());
        selectedId = R.id.btn_tatca;
        return v;
    }
    private void addfragnent (Fragment fr, Fragment fr2){
        FragmentTransaction ftr = getChildFragmentManager().beginTransaction();
        ftr.replace(R.id.contaier_header,fr);
        ftr.replace(R.id.contaier_footer,fr2);
        ftr.commit();
    }
    public void addBody(Fragment fr){
        FragmentTransaction ftr = getChildFragmentManager().beginTransaction();
        ftr.replace(R.id.contaier_body_home,fr);
        ftr.commit();


    }




}


//        layoutAdapter adapter = new layoutAdapter();
//
//        LinearLayoutManager lm = new LinearLayoutManager(v.getContext(),
//                LinearLayoutManager.VERTICAL,
//                false);
//        rcvmusic.setLayoutManager(lm);
//        rcvmusic.setAdapter(adapter);

//        setView(0,v,rcvmusic);
//        setView(1,v,rcvradio);
//        setView(3,v,rcvplaylist);


//    public void setView(int gtri, View v,RecyclerView rcv) {
//        LinearLayoutManager lm = new LinearLayoutManager(v.getContext());
//        if (gtri == 0) {
//            rcv = v.findViewById(R.id.rcvms);
//            musicViewModel viewModel = new musicViewModel();
//
//            List<music> ls = viewModel.setView();   // gọi data
//            musicAdapter msAdapter = new musicAdapter(ls);
//
//            rcv.setLayoutManager(lm);
//            rcv.setAdapter(msAdapter);
//
//        } else if (gtri == 1) {
//            rcv = v.findViewById(R.id.rcv_radio);
//            radioViewModel viewModel = new radioViewModel();
//
//            List<radio> ls = viewModel.setView();
//            radioAdapter radioAdapter = new radioAdapter(ls);
//
//            rcv.setLayoutManager(lm);
//            rcv.setAdapter(radioAdapter);
//
//        } else {
//            rcv = v.findViewById(R.id.rcv_dexuat);
//            playlistViewModel viewModel = new playlistViewModel();
//
//            List<playlist> ls = viewModel.setView();
//            playlistAdapter playlistAdapter = new playlistAdapter(ls);
//
//            rcv.setLayoutManager(lm);
//            rcv.setAdapter(playlistAdapter);
//        }
//    }

