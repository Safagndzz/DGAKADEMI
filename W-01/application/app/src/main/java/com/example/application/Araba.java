package com.example.application;

public class Araba {
    String marka;
    int kapiSayisi ;
    int motorSayisi;
    int tekerSayisi;

    public Araba() {
    }

    public Araba(String marka, int kapiSayisi, int motorSayisi, int tekerSayisi) {
        this.marka = marka;
        this.kapiSayisi = kapiSayisi;
        this.motorSayisi = motorSayisi;
        this.tekerSayisi = tekerSayisi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getKapiSayisi() {
        return kapiSayisi;
    }

    public void setKapiSayisi(int kapiSayisi) {
        this.kapiSayisi = kapiSayisi;
    }

    public int getMotorSayisi() {
        return motorSayisi;
    }

    public void setMotorSayisi(int motorSayisi) {
        this.motorSayisi = motorSayisi;
    }

    public int getTekerSayisi() {
        return tekerSayisi;
    }

    public void setTekerSayisi(int tekerSayisi) {
        this.tekerSayisi = tekerSayisi;
    }
}
