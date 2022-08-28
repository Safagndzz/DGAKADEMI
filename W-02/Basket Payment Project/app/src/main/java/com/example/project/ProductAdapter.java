package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    List<Product> items;
    IProductEventListener eventListener;

    public ProductAdapter(Context context,List<Product> items, IProductEventListener eventListener) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;
        this.eventListener = eventListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product p = items.get(position);
        holder.nameTv.setText(p.getName());

        p.setTotalPrice(p.getCount() * p.getPrice());
        holder.totalPriceTv.setText("" + p.getTotalPrice());

        holder.countEt.setText("" + p.getCount());

        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.setCount(p.getCount()-1);
                holder.countEt.setText("" + p.getCount());
                p.setTotalPrice(p.getCount() * p.getPrice());
                holder.totalPriceTv.setText("" + p.getTotalPrice());
                eventListener.onProductValueChange();
            }
        });
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.setCount(p.getCount()+1);
                holder.countEt.setText("" + p.getCount());
                p.setTotalPrice(p.getCount() * p.getPrice());
                holder.totalPriceTv.setText("" + p.getTotalPrice());
                eventListener.onProductValueChange();
            }
        });
        holder.btnAddBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductManager.getInstance().getBasket().add(p);
                eventListener.onProductAdded();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView nameTv;
        TextView totalPriceTv;
        EditText countEt;
        Button btnMinus;
        Button btnPlus;
        Button btnAddBasket;

        public MyViewHolder(View itemView) {
            super(itemView);

            nameTv = (TextView) itemView.findViewById(R.id.product_name_tv);
            totalPriceTv = (TextView) itemView.findViewById(R.id.total_price_tv);
            countEt = (EditText) itemView.findViewById(R.id.count_et);
            btnMinus = (Button) itemView.findViewById(R.id.btn_minus);
            btnPlus = (Button) itemView.findViewById(R.id.btn_plus);
            btnAddBasket = (Button) itemView.findViewById(R.id.btn_add_basket);

        }
    }
}
