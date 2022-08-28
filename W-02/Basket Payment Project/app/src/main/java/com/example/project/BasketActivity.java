package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity implements IProductEventListener {

    RecyclerView basketRecyler;
    TextView sumTotalTv;
    Button paymentbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        basketRecyler = findViewById(R.id.basket_recvlerView);
        paymentbtn = findViewById(R.id.payment_button);
        sumTotalTv = findViewById(R.id.sum_total_tv);
        final ProductAdapter adapter = new ProductAdapter(this, ProductManager.getInstance().getBasket(), this);
        basketRecyler.setAdapter(adapter);
        calculateSumTotal();
        paymentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasketActivity.this, PaymentSuccessActivity.class);
                ProductManager.getInstance().getBasket().clear();
                startActivity(intent);
            }
        });

    }
    private void calculateSumTotal(){
        double sumTotal = 0.0;
        for (Product item: ProductManager.getInstance().getBasket()) {
            sumTotal += item.getTotalPrice();
        }
        //sumTotal = (double) Math.round(sumTotal * 100.0) / 100.0;
        DecimalFormat f = new DecimalFormat("##.00");
        sumTotalTv.setText(String.valueOf(f.format(sumTotal)));
    }
    @Override
    public void onProductValueChange() {
        calculateSumTotal();
    }

    @Override
    public void onProductAdded() {
        calculateSumTotal();
    }
}