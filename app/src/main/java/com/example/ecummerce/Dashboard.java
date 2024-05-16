package com.example.ecummerce;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ecummerce.databinding.ActivityDashboardBinding;
import com.google.android.material.navigation.NavigationBarView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityDashboardBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });
        MyFragments(new Home());
        binding.bottomNavigationView.setOnItemSelectedListener(menuItem -> {
            if(menuItem.getItemId() == R.id.home1){
                MyFragments(new Home());

            }
            else if (menuItem.getItemId() == R.id.notifs) {
                MyFragments(new Notifications());

            }
            else if (menuItem.getItemId() == R.id.cart) {
                MyFragments(new Cart());

            }
            else if (menuItem.getItemId() == R.id.account) {
                MyFragments(new Account());

            }
            return true;
        });
    }
    private void MyFragments(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_Layout, fragment).addToBackStack(null).commit();
    }
}