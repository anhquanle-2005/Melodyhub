package com.example.spotify.views.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.spotify.models.Song;
import com.example.spotify.adapter.SongAdapter;
import com.example.spotify.R;
import com.example.spotify.views.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

   private SearchView searchView;
   private RecyclerView rcvms;
   private SongAdapter songAdapter;
   private ImageButton imgbtnHome,imgbtnSearch,imgbtnLib,imgbtnPre,imgbtnCrea;

   private List<Song> allSongs; // Danh sách chứa tất cả bài hát
   private LayoutInflater inflater;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      // Gắn layout XML vào Fragmenth
      return inflater.inflate(R.layout.fragment_search, container, false);
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);

      // Ánh xạ các view từ layout XML bằng ID
      searchView = view.findViewById(R.id.search_view);
      rcvms = view.findViewById(R.id.rcvmsr);

      // Chuẩn bị dữ liệu và RecyclerView
      loadDummySongs();
      setupRecyclerView();
      setupSearchView();
      initViews(view);
      setupClickListeners();
   }
   private void initViews(View v) {
      imgbtnHome=v.findViewById(R.id.imgbtn_Home);
      imgbtnSearch=v.findViewById(R.id.imgbtn_Search);
      imgbtnLib=v.findViewById(R.id.imgbtn_Lib);
      imgbtnPre=v.findViewById(R.id.imgbtn_Pre);
      imgbtnCrea=v.findViewById(R.id.imgbtn_Crea);
   }

   // Hàm thiết lập các sự kiện click
   private void setupClickListeners() {
      // Nút Home sẽ quay về HomeFragment
      imgbtnHome.setOnClickListener(v -> {
         if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).openFragment(new HomeFragment(), 0);
         }
      });

      // Nút Search chỉ hiển thị thông báo vì đang ở màn hình tìm kiếm
      imgbtnSearch.setOnClickListener(v -> {
         Toast.makeText(getContext(), "Bạn đang ở màn hình Tìm kiếm", Toast.LENGTH_SHORT).show();
      });

      // Các nút khác sẽ hiển thị thông báo
      imgbtnLib.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Thư viện đang phát triển", Toast.LENGTH_SHORT).show());
      imgbtnPre.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Premium đang phát triển", Toast.LENGTH_SHORT).show());
      imgbtnCrea.setOnClickListener(v -> Toast.makeText(getContext(), "Chức năng Tạo mới đang phát triển", Toast.LENGTH_SHORT).show());
   }
   private void setupRecyclerView() {
      // Thiết lập RecyclerView để hiển thị danh sách theo chiều dọc
      rcvms.setLayoutManager(new LinearLayoutManager(getContext()));
      // Khởi tạo Adapter với danh sách bài hát ban đầu
      songAdapter = new SongAdapter(allSongs);
      rcvms.setAdapter(songAdapter);
   }

   private void setupSearchView() {
      searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
         // Phương thức này được gọi khi người dùng nhấn nút tìm kiếm
         @Override
         public boolean onQueryTextSubmit(String query) {
            filter(query);
            return false;
         }

         // Phương thức này được gọi mỗi khi văn bản trong ô tìm kiếm thay đổi
         @Override
         public boolean onQueryTextChange(String newText) {
            filter(newText);
            return true;
         }
      });
   }

   // Hàm lọc danh sách bài hát
   private void filter(String text) {
      ArrayList<Song> filteredList = new ArrayList<>();
      // Lặp qua tất cả bài hát
      for (Song item : allSongs) {
         // Nếu tên bài hát hoặc tên nghệ sĩ chứa từ khóa tìm kiếm (không phân biệt hoa thường)
         if (item.getTitle().toLowerCase().contains(text.toLowerCase()) ||
                 item.getArtist().toLowerCase().contains(text.toLowerCase())) {
            filteredList.add(item); // Thêm vào danh sách kết quả
         }
      }
      // Cập nhật danh sách hiển thị trên Adapter
      songAdapter.filterList(filteredList);
   }

   // Hàm tạo dữ liệu giả lập
   private void loadDummySongs() {
      allSongs = new ArrayList<>();
      // Lấy tên package của ứng dụng để tạo URI cho drawable
      String packageName = getContext().getPackageName();

      // Tạo URI dưới dạng String cho từng ảnh trong thư mục drawable
      // Định dạng: "android.resource://[package_name]/[resource_id]"
      String nangAmUri = "android.resource://" + packageName + "/" + R.drawable.nangam;
      String emUri = "android.resource://" + packageName + "/" + R.drawable.em;

      // Giờ đây, chúng ta truyền một String hợp lệ vào constructor của Song
      allSongs.add(new Song("1", "Nắng Ấm Xa Dần", "Sơn Tùng M-TP", nangAmUri));
      allSongs.add(new Song("2", "Em Của Ngày Hôm Qua", "Sơn Tùng M-TP", emUri));
      allSongs.add(new Song("3", "Chúng Ta Của Hiện Tại", "Sơn Tùng M-TP", nangAmUri)); // Dùng lại ảnh để làm ví dụ
      allSongs.add(new Song("4", "See You Again", "Wiz Khalifa", nangAmUri));
      allSongs.add(new Song("5", "Shape of You", "Ed Sheeran", nangAmUri));
      allSongs.add(new Song("6", "Blinding Lights", "The Weeknd", nangAmUri));
      allSongs.add(new Song("7", "Đi Về Nhà", "Đen Vâu ft. JustaTee", nangAmUri));
      allSongs.add(new Song("8", "Mang Tiền Về Cho Mẹ", "Đen Vâu ft. Nguyên Thảo", nangAmUri));
      allSongs.add(new Song("9", "Waiting For You", "MONO", nangAmUri));
   }
}


