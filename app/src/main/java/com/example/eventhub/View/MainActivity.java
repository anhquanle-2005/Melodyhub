package com.example.eventhub.View;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eventhub.R;
import com.example.eventhub.View.Fragment.FooterFragment;
import com.example.eventhub.View.Fragment.HeaderFragment;
import com.example.eventhub.View.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    public Fragment frsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.white));
        window.setNavigationBarColor(ContextCompat.getColor(this, android.R.color.white));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        }); frsave = new HomeFragment();
        addFragment(frsave,false,0);
            addFooter(new FooterFragment());
            Header(new HeaderFragment());
    }

    private void addFragment(Fragment fr, Boolean addToBackStack, int kt)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(kt==0)
        {
            transaction.setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
            );
        }
        else
        {
            transaction.setCustomAnimations(
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
            );
        }
        transaction.replace(R.id.container_body,fr);
        if(fr.getClass().equals(frsave.getClass())){
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            addToBackStack = false;
        }
        if(addToBackStack)
            transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }
    private void addFooter(Fragment fr)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_footer,fr);
        transaction.commit();
    }
    private void Header(Fragment fr)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_header,fr);
        transaction.commit();
    }

}