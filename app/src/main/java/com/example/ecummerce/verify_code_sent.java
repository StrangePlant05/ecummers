package com.example.ecummerce;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.ecummerce.databinding.ActivityVerifyCodeSentBinding;

public class verify_code_sent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityVerifyCodeSentBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_verify_code_sent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bind.button.setOnClickListener(v -> {
            if(bind.code.getText().toString().equals(getIntent().getStringExtra("code"))){
                Intent intent = new Intent(verify_code_sent.this, AccountSetUp.class);
                intent.putExtra("number", getIntent().getStringExtra("number"));
                startActivity(intent);
                finish();
            }
        });
    }
}