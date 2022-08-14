package com.example.recyclerviewkullanm;

import java.util.ArrayList;

public class Meyveler {
    private String meyveIsmi;
    private int meyveKalori, meyveResim;

    public Meyveler(){}

    public Meyveler(String meyveIsmi, int meyveKalori, int meyveResim) {
        this.meyveIsmi = meyveIsmi;
        this.meyveKalori = meyveKalori;
        this.meyveResim = meyveResim;
    }

    public String getMeyveIsmi() {
        return meyveIsmi;
    }

    public void setMeyveIsmi(String meyveIsmi) {
        this.meyveIsmi = meyveIsmi;
    }

    public int getMeyveKalori() {
        return meyveKalori;
    }

    public void setMeyveKalori(int meyveKalori) {
        this.meyveKalori = meyveKalori;
    }

    public int getMeyveResim() {
        return meyveResim;
    }

    public void setMeyveResim(int meyveResim) {
        this.meyveResim = meyveResim;
    }

    static public ArrayList<Meyveler> getData(){
        ArrayList<Meyveler> meyvelerList = new ArrayList<Meyveler>();
        String[] meyveler = {"banana", "cherry", "strawberry", "apple"};
        int[] kaloriler = {15, 5, 25, 20};
        int[] resimler = {R.drawable.banana, R.drawable.cherry, R.drawable.strawberry, R.drawable.apple};

        for(int i = 0; i < meyveler.length; i++){
            Meyveler meyve = new Meyveler();
            meyve.setMeyveIsmi(meyveler[i]);
            meyve.setMeyveKalori(kaloriler[i]);
            meyve.setMeyveResim(resimler[i]);

            meyvelerList.add(meyve);
        }

        return meyvelerList;
    }
}
