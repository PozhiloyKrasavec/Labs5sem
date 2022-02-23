package com.company;
import java.util.Scanner;

public class pr5 {
    public static abstract class Watch { //объявление абстрактного суперкласса(класс родитель)
        int price;// поля класса(переменные)
        String name;

        public Watch(int price, String name) { //конструктор класса с параметрами, присваиваются значения полям
            this.price = price;//т.к. имена параметров и полей одинаковые чтобы присвоить значение полям нужно использовать this
            this.name = name;//this указывает на объект который вызывает этот метод
        }

        public abstract int getPrice(); //объявление геттеров и сеттеров абстрактные методы не имеют функционала

        public abstract void setPrice(int price);

        public abstract String getName();

        public abstract void setName(String name);
    }
    public static class eWatch extends Watch{
        int power;

        public eWatch(int price, String name, int power) {
            super(price, name);//вызов конструктора суперкласса
            this.power = power;
        }

        public int getPrice() { //инициализации сеттеров и геттеров суперкласса, обязательно
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public static class mWatch extends Watch{//аналогично предыдущему
        int details_num;

        public mWatch(int price, String name, int details_num) {
            super(price, name);
            this.details_num = details_num;
        }

        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//объявления сканера(считывает с консоли значения)
        System.out.println("Enter arrays sizes");
        int n = in.nextInt(),m=in.nextInt(), max=-1;//объявление и инциализация размеров массива и максимума
        eWatch[] eWatches = new eWatch[n];//объявление массива
        mWatch[] mWatches = new mWatch[m];
        for (int i=0;i<n;i++)
        {
            eWatches[i] = new eWatch((int)(Math.random()*1000+100),"Apple",(int)(Math.random()*100));//инициализация элемента массива
            System.out.println("CHECK eWatch price: "+eWatches[i].getPrice());
            if (eWatches[i].getPrice()>max) max = eWatches[i].getPrice();//сравнений с максимумом, если цена больше, то максимум меняется на эту цен
        }
        for (int i=0;i<m;i++)
        {
            mWatches[i] = new mWatch((int)(Math.random()*1000+100),"Rolex",(int)(Math.random()*10));//мас рандом возвращает дабл, в конструкторе элемент инт, инт в скобочках приводит к типу инт
            System.out.println("CHECK mWatch price: "+mWatches[i].getPrice());
            if (mWatches[i].getPrice()>max) max = mWatches[i].getPrice();
        }
        System.out.println("Max price: "+max);
    }
}
