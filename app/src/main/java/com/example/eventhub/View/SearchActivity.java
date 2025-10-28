package com.example.eventhub.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eventhub.R;
import com.example.eventhub.View.Fragment.FilterBottomSheetFragment;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.search), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // === THÊM CODE MỚI TỪ ĐÂY ===

        // 1. Tìm nút "Lọc" trong activity_search.xml
        Button filterButton = findViewById(R.id.button);

        // 2. Gán sự kiện click
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Tạo và hiển thị BottomSheet
                FilterBottomSheetFragment filterSheet = new FilterBottomSheetFragment();
                filterSheet.show(getSupportFragmentManager(), "FilterBottomSheet");
            }
        });

        // === HẾT CODE MỚI ===
    }
}