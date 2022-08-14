package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ArabaAdapter extends ArrayAdapter<Araba> {
    Context context;
    private int resourceLayout;
    public ArabaAdapter(@NonNull Context context, int resource, List<Araba> items) {
        super(context, resource, items);
        this.context = context;
        this.resourceLayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(resourceLayout, null);
        }

        Araba p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.marka_tv);
            TextView tt2 = (TextView) v.findViewById(R.id.tekersayisi_tv);
            TextView tt3 = (TextView) v.findViewById(R.id.kapisayisi_tv);
            TextView tt4 = (TextView) v.findViewById(R.id.motorsayisi_tv);

            if (tt1 != null) {
                tt1.setText("Marka: " + p.getMarka());
            }

            if (tt2 != null) {
                tt2.setText("TekerSayisi: " + p.getTekerSayisi());
            }

            if (tt3 != null) {
                tt3.setText("KapiSayisi: " + p.getKapiSayisi());
            }

            if (tt4 != null) {
                tt4.setText("MotorSayisi: " + p.getMotorSayisi());
            }

        }

        return v;
    }
}
