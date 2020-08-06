package com.app.salamat.connection;

import com.app.salamat.model.Product;
import com.app.salamat.connection.Connection.VolleyConnection.*;

import java.util.ArrayList;

public class Connection {
    private ProductConnection productConnection;

    public interface VolleyConnection {

        interface ProductConnection{
            void getProducts(ArrayList<Product> products);
        }

    }

    public void ProductConnection(VolleyConnection.ProductConnection connection){
        this.productConnection = connection;
        //connect to server
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Product p = new Product();
            boolean published = i % 2 == 0;
            p.setName("گوشت : "+ i);
            p.setId(i);
            p.setCategory("دسته ی : "+ i);
            p.setDescription("توصیف گوشت : "+ i);
            p.setCount( ((i*3)+5) );
            p.setPublished(published);
            products.add(p);
        }
        connection.getProducts(products);

    }
    
}

