package com.example.spotify.viewModels;

import com.example.spotify.models.Podcast;

import java.util.ArrayList;
import java.util.List;

public class PodcastViewModel {
    private List<Podcast> Lpodcast = new ArrayList<>();

    public PodcastViewModel() {
    }
    public List addView(){
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#732B17"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#2C4850"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#394929"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#444444"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#294C29"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#791D15"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#732B17"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#2C4850"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#394929"));
        return Lpodcast;
    }
    public List setPodcast(){
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#732B17"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#2C4850"));
        Lpodcast.add(new Podcast("Cơn mưa dịu mát","Nghe truyện ngủ ngon","https://i.scdn.co/image/ab67656300005f1f25838b1c8528bfffc1550122","#394929"));
        return Lpodcast;
    }
}
