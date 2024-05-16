package com.example.ecummerce;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.ecummerce.databinding.ActivityMainLogInBinding;

public class Main_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityMainLogInBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_main_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bind.learnMore.setOnClickListener(v -> {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dg_learn_more);
            dialog.getWindow().setGravity(Gravity.CENTER);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setCancelable(true);
            dialog.show();

            dialog.findViewById(R.id.button2).setOnClickListener(v1 -> {
                dialog.dismiss();
            });
        });

        bind.button.setOnClickListener(v -> {
            //TODO: Log in
            Intent intent = new Intent(Main_LogIn.this, Dashboard.class);
            startActivity(intent);
            finish();
        });

        bind.toLogInCode.setOnClickListener(v -> {
            Intent intent = new Intent(Main_LogIn.this, LogIn.class);
            startActivity(intent);
            finish();
        });
    }

    public void onBackPressed() {
        //TODO: Dialog on back pressed
        if (false) super.onBackPressed();
    }
}