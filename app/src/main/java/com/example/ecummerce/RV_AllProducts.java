package com.example.ecummerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecummerce.databinding.RvProductsBinding;

import java.util.List;

public class RV_AllProducts extends RecyclerView.Adapter<RV_AllProducts.ViewHolder> {
    Context c;
    List<Product> products;

    public RV_AllProducts(Context c, List<Product> products) {
        this.c = c;
        this.products = products;
    }

    @NonNull
    @Override
    public RV_AllProducts.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RvProductsBinding.inflate(LayoutInflater.from(c)));
    }

    @Override
    public void onBindViewHolder(@NonNull RV_AllProducts.ViewHolder holder, int position) {
        Product p = products.get(position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RvProductsBinding bind;

        public ViewHolder(@NonNull RvProductsBinding bind) {
            super(bind.getRoot());

            this.bind = bind;
        }
    }
}
