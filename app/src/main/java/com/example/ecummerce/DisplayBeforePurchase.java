package com.example.ecummerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DisplayBeforePurchase extends AppCompatActivity {

    User currentUser;
    Product currentProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_before_purchase);

        // TODO: set  values for current user and current product mayhaps from id from getIntent().getExtra()


    }
}