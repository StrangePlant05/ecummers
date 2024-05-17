package com.example.ecummerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.ecummerce.databinding.ActivityCheckoutBinding;
import com.example.ecummerce.databinding.DgVariationsBinding;

public class CheckoutActivity extends AppCompatActivity {

    User currentUser;
    Product currentProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCheckoutBinding b = DataBindingUtil.setContentView(this, R.layout.activity_checkout);

        b.name.setText(currentProduct.getProductName());
        b.price.setText("$" + currentProduct. getPrice());
        b.desc.setText(currentProduct.getProductDescription());
        b.image.setImageURI(currentProduct.getImage());
        b.submit.setOnClickListener(v -> {
            Dialog dialog = new Dialog(this);
            DgVariationsBinding bind = DgVariationsBinding.inflate(LayoutInflater.from(this));

        });
    }
}