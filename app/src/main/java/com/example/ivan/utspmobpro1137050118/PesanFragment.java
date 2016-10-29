package com.example.ivan.utspmobpro1137050118;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ivan.utspmobpro1137050118.adapter.Product;
import com.example.ivan.utspmobpro1137050118.adapter.ProductListAdapter;
import com.example.ivan.utspmobpro1137050118.utils.SharedPreference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MUL 01 on 10/18/2016.
 */

public class PesanFragment extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    public static final String ARG_ITEM_ID = "product_list";

    ListView productListView;
    List<Product> products, favorite;
    ProductListAdapter productListAdapter;

    SharedPreference sharedPreference;

    public PesanFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_produk);
        setProducts();
        sharedPreference = new SharedPreference();
        productListAdapter = new ProductListAdapter(getApplicationContext(), products);

        productListView = (ListView) findViewById(R.id.list_product);
        productListView.setAdapter(productListAdapter);
        productListView.setOnItemClickListener(this);
        productListView.setOnItemLongClickListener(this);

        Button btSimpan = (Button) findViewById(R.id.simpan);
        assert btSimpan != null;
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iPemesanan = new Intent(getApplicationContext(), KeranjangPesanan.class);
                startActivity(iPemesanan);
                finish();

            }
        });

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Product product = (Product) parent.getItemAtPosition(position);
        String apa = Integer.toString(position);

            Intent iOri= new Intent(PesanFragment.this, Coffeein.class);
            iOri.putExtra("param",apa);
            startActivity(iOri);



        Toast.makeText(getApplicationContext(), product.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View view, int position, long arg3) {
        ImageView button = (ImageView) view.findViewById(R.id.imgbtn_favorite);

        String tag = button.getTag().toString();
        if (tag.equalsIgnoreCase("grey")) {
            sharedPreference.addFavorite(getApplicationContext(), products.get(position));
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.add_favr),
                    Toast.LENGTH_SHORT).show();

            button.setTag("green");
            button.setImageResource(R.drawable.add);
        } else {
            sharedPreference.removeFavorite(getApplicationContext(), products.get(position));
            button.setTag("grey");
            button.setImageResource(R.drawable.addnon);
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.remove_favr),
                    Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private void setProducts() {

        Product product1 = new Product(1, "Cafe' Latte","Coffe with variant of Latte", 30000);
        Product product2 = new Product(2, "Pure Vanilla",
                "Coffe with variant of vanilla", 25000);
        Product product3 = new Product(3, "Vanilla Latte",
                "Coffe with variant of vanilla and Latte", 35000);
        Product product4 = new Product(4, "Espresso",
                "Coffe with variant of Espresso", 40000);

        products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
    }


}
