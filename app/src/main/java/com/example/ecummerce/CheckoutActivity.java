package com.example.ecummerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ecummerce.databinding.ActivityCheckoutBinding;
import com.example.ecummerce.databinding.DgVariationsBinding;
import com.google.firebase.components.Qualified;

public class CheckoutActivity extends AppCompatActivity {

    User currentUser;
    Product currentProduct;
    int quantity = 0;
    String variation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCheckoutBinding b = DataBindingUtil.setContentView(this, R.layout.activity_checkout);

        // TODO: set  values for current user and current product mayhaps from id from getIntent().getExtra()

        b.name.setText(currentProduct.getProductName());
        b.price.setText("$" + currentProduct. getPrice());
        b.desc.setText(currentProduct.getProductDescription());
        b.image.setImageURI(currentProduct.getImage());
        b.submit.setOnClickListener(v -> {
            variation = currentProduct.getVariations().get(0);
            quantity = 1;
            Dialog dialog = new Dialog(this);
            DgVariationsBinding bind = DgVariationsBinding.inflate(LayoutInflater.from(this));
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setGravity(Gravity.BOTTOM);
            dialog.setCancelable(true);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            bind.imageView8.setImageURI(currentProduct.getImage());
            bind.textView7.setText(currentProduct.getProductName());
            bind.textView8.setText("$"+currentProduct.getPrice());
            bind.tvQuantity.setText(quantity + "x");
//            bind.recyclerView3. TODO: rv in dialog

            bind.btnMinus.setOnClickListener(v1 -> {
                quantity--;
                if (quantity < 1) quantity = 1;
                 bind.tvQuantity.setText(quantity + "x");
            });

            bind.btnMinus.setOnClickListener(v1 -> {
                quantity++;
                if (quantity > currentProduct.getStock()) quantity = currentProduct.getStock();
                bind.tvQuantity.setText(quantity + "x");
            });

            bind.submit.setOnClickListener(v1 -> {
                Intent intent = new Intent(CheckoutActivity.this, DisplayBeforePurchase.class);
                intent.putExtra("userId", currentUser.getId());
                intent.putExtra("productId", currentProduct.getId());
                startActivity(intent);
                finish();
            });
        });
    }
}