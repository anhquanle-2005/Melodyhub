package com.example.spotify.viewModels;

import com.example.spotify.models.Nghesi;

import java.util.ArrayList;
import java.util.List;

public class NghesiViewModel {
    private List<Nghesi> lns = new ArrayList<>();

    public List<Nghesi> getLns() {
        return lns;
    }

    public NghesiViewModel() {

    }

    public void setLns(List<Nghesi> lns) {
        this.lns = lns;
    }
    public List addView(){
        Nghesi ns1 = new Nghesi("Tlinh","https://i.scdn.co/image/ab67616100005174230e62752ca87da1d85d0445");
        Nghesi ns2 = new Nghesi("Sơn Tùng MTP","https://i.scdn.co/image/ab676161000051745a79a6ca8c60e4ec1440be53");
        Nghesi ns3 = new Nghesi("HIEUTHUHAI","https://i.scdn.co/image/ab6761610000517421942907035a43a2d118c55c");
        lns.add(ns1);
        lns.add(ns2);
        lns.add(ns3);
        return lns;
    }
}
