package com.example.spotify.views.activity;

import android.annotation.SuppressLint;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.spotify.R;
import com.example.spotify.views.fragments.HomeFragment;
import com.example.spotify.views.fragments.wellcomeFragment;


public class MainActivity extends AppCompatActivity {

    public Fragment frsave;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.black));
        window.setNavigationBarColor(ContextCompat.getColor(this, android.R.color.black));
        setContentView(R.layout.activity_main);
        SharedPreferences spf = getSharedPreferences("DN",MODE_PRIVATE);
        boolean kt = spf.getBoolean("DangDN",false);
        if(kt)
        {
            frsave = new HomeFragment();
            replaceFragment(frsave,false,0);
        }

        else
        {
            frsave = new wellcomeFragment();
            replaceFragment(frsave,false ,0);
        }



    }

    private void replaceFragment(Fragment fr, boolean addToBackStack ,int kt ) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(kt ==0) {

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
        transaction.commit();
    }
    public void openFragment(Fragment fr, int kt){
        replaceFragment(fr,true, kt);
    }

}