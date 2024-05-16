package com.example.ecummerce;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.ecummerce.databinding.ActivityLayoutBinding;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityLayoutBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bind.button.setOnClickListener(v -> {
            //TODO: LOG IN
            Intent intent = new Intent(LogIn.this, verify_code_sent.class);
            startActivity(intent);
        });
        bind.toPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LogIn.this, Main_LogIn.class);
            startActivity(intent);
            finish();
        });


    }

    @Override
    public void onBackPressed() {
        //TODO: Dialog on back pressed
        if (false) super.onBackPressed();
    }
}