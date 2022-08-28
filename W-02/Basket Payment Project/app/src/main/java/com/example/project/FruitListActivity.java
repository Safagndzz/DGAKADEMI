package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

public class FruitListActivity extends AppCompatActivity implements IProductEventListener {


    FirebaseDatabase database;

    ArrayList<Product> productList;
    RecyclerView productLw;
    Button basketBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruitlist);
        database = FirebaseDatabase.getInstance();
        productLw = findViewById(R.id.fruit_list);
        basketBtn = findViewById((R.id.basket_button));
        productList = new ArrayList<>();

        basketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FruitListActivity.this, BasketActivity.class);
                startActivity(intent);
            }
        });
//        Product product = new Product(1, "çikolata", 5.5d,1,0);
//        productList.add(product);
//        product = new Product(1, "dondurma", 2.4d,1,0);
//        productList.add(product);
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(productList));
        final ProductAdapter adapter = new ProductAdapter(this, productList, this);
        productLw.setAdapter(adapter);
        DatabaseReference reference = database.getReference().child("Product");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren() ){
                    Product product = snapshot.getValue(Product.class);
                    productList.add(product);
                    System.out.println(product.getName());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onProductValueChange() {

    }

    @Override
    public void onProductAdded() {

    }
}