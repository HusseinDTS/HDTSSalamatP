package com.app.salamat.activity;
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.salamat.R;
import com.app.salamat.adapter.ProductAdapter;
import com.app.salamat.connection.Connection;
import com.app.salamat.model.Product;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity {
    private Connection connection = new Connection();
    private ProductAdapter adapter;
    private RecyclerView recyclerView;
    private Activity dis;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();


    }

    private void initComponent() {
        this.dis = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(dis,1));
        initRecyclerView();

    }

    private void initRecyclerView() {
        connection.ProductConnection(new Connection.VolleyConnection.ProductConnection() {
            @Override
            public void getProducts(ArrayList<Product> products) {
                adapter = new ProductAdapter(dis,products);
                recyclerView.setAdapter(adapter);
            }
        });
    }


}