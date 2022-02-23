package com.company;

public enum Kancelyaria_1 {
    Paper1((int) Math.round(Math.random() * 40 + 30),"Snezhinka","A4", 250, 2),
    Paper2((int) Math.round(Math.random() * 40 + 30),"Svetocopy","A3", 300, 0),
    Paper3((int) Math.round(Math.random() * 40 + 30),"ACBK","A5", 150, 0),
    Pen1((int) Math.round(Math.random() * 40 + 30),"Erich Krause",12, 95, 4),
    Pen2((int) Math.round(Math.random() * 40 + 30),"Bic",23,15, 2),
    Pen3((int) Math.round(Math.random() * 40 + 30),"InfoLine",12, 45, 3);
    private int kolvo;
    private String proizv;
    private int diam;
    private String form;
    private int price;
    private int pokupka;
    Kancelyaria_1(int x,String s,int diam, int price, int pokupka) {
        kolvo = x;
        proizv = s;
        this.diam = diam;
        this.price = price;
        this.pokupka = pokupka;
    }
    Kancelyaria_1(int x,String s,String form, int price, int pokupka) {
        kolvo = x;
        proizv = s;
        this.form = form;
        this.price = price;
        this.pokupka = pokupka;
    }
    int getKolvo() {
        return kolvo;
    }
    public String getProizv() {
        return proizv;
    }
    public int getDiam() {
        return diam;
    }
    public String getForm() {
        return form;
    }
    public int getPrice() {
        return price;
    }
    public int getPokupka() {
        return pokupka;
    }

}
