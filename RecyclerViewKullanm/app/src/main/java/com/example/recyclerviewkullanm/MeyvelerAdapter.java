package com.example.recyclerviewkullanm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MeyvelerAdapter extends RecyclerView.Adapter<MeyvelerAdapter.Meyvelerholder> {
    private ArrayList<Meyveler> meyvelerList;
    private Context context;
    private OnItemClickListener listener;

    public MeyvelerAdapter(ArrayList<Meyveler> meyvelerList, Context context) {
        this.meyvelerList = meyvelerList;
        this.context = context;
    }

    @NonNull
    @Override
    public Meyvelerholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context). inflate(R.layout.meyveler_item, parent, false);
        return new Meyvelerholder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull Meyvelerholder holder, int position) {
        Meyveler meyveler=meyvelerList.get(position);
        holder.setData(meyveler);

    }

    @Override
    public int getItemCount() {
        return meyvelerList.size();
    }

    class Meyvelerholder extends RecyclerView.ViewHolder{
        TextView meyveIsmi, meyveKaloiri;
        ImageView meyveResim;


        public Meyvelerholder(@NonNull View itemView) {
            super(itemView);
            meyveIsmi = (TextView) itemView.findViewById(R.id.meyveler_item_textViewMeyveIsmi);
            meyveKaloiri = (TextView)itemView.findViewById(R.id.meyveler_item_textViewMeyveKalori);
            meyveResim = (ImageView)itemView.findViewById(R.id.meyveler_item_imageViewResim);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(meyvelerList.get(position), position);
                }
            });
        }

        public void setData(Meyveler meyveler){
            this.meyveIsmi.setText(meyveler.getMeyveIsmi());
            this.meyveKaloiri.setText(String.valueOf(meyveler.getMeyveKalori()));
            this.meyveResim.setBackgroundResource(meyveler.getMeyveResim());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Meyveler meyveler, int position);
    }

    public void setOnItemClickListener(OnItemClickListener Listener){
        this.listener = listener;
    }
}
