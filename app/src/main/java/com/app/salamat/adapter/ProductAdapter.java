package com.app.salamat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.salamat.R;
import com.app.salamat.model.Product;
import com.app.salamat.utils.Tools;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Product> products;
    private Context dis;

    public ProductAdapter(Context dis , ArrayList<Product> products){
        this.dis = dis;
        this.products = products;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder{
        public ImageView img_image;
        public TextView tv_name , tv_count , tv_status;
        public OriginalViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_count = itemView.findViewById(R.id.tv_count);
            tv_status = itemView.findViewById(R.id.tv_status);
            img_image = itemView.findViewById(R.id.img_image);
        }

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        RecyclerView.ViewHolder vh = new OriginalViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = products.get(position);
        OriginalViewHolder vItem = ((OriginalViewHolder) holder);

        vItem.tv_name.setText(product.getName());
        vItem.tv_count.setText(product.getCount()+"");
        vItem.tv_status.setText(Tools.getProductStatus(product.isPublished()));

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
