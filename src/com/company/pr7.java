package com.company;

import java.util.Scanner;

public class pr7 {
    public static interface Comparator{
        boolean compare(int max);
    }
    public static class Watch implements Comparator  { //объявление суперкласса(класс родитель)
        int price;// поля класса(переменные)
        static boolean broken = false;
        String name;


        public Watch(int price, String name) { //конструктор класса с параметрами, присваиваются значения полям
            this.price = price;//т.к. имена параметров и полей одинаковые чтобы присвоить значение полям нужно использовать this
            this.name = name;//this указывает на объект который вызывает этот метод
        }

        public Watch() {
        }

        public int getPrice() {//геттеры и сеттеры
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
        public static void Broke(Watch watch){//статический метод чтобы поменять брокен
            watch.broken = true;
        }
        public static void Broke(eWatch watch){
            watch.broken = true;
        }
        public static void Broke(mWatch watch){
            watch.broken = true;
        }

        public static boolean isBroken(Watch watch) {//вывести брокен метод тоже статический
            return watch.broken;
        }
        public static boolean isBroken(eWatch watch) {
            return watch.broken;
        }
        public static boolean isBroken(mWatch watch) {
            return watch.broken;
        }
        public boolean compare(int max) {
            if(this.price>max) return true;
            return false;
        }
    }
    public static class eWatch extends Watch {
        int power = 0;

        public eWatch(int price, String name, int power) {
            super(price, name);//вызов конструктора суперкласса
            this.power = power;
        }

        public eWatch() {
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }
    }
    public static class mWatch extends Watch {//аналогично предыдущему
        int details_num = 0;

        public mWatch(int price, String name, int details_num) {
            super(price, name);
            this.details_num = details_num;
        }

        public mWatch() {
        }

        public int getDetails_num() {
            return details_num;
        }

        public void setDetails_num(int details_num) {
            this.details_num = details_num;
        }
    }
    public static void show(Watch watch)//метод выводит характеристики объектов
    {
        System.out.println("\t1-Type:"+new StringBuilder(watch.getClass().toString()).delete(0,10)+"\n" +"\t2-Price: " + watch.getPrice() + "\n" + "\t3-Name: " + watch.getName() + "\n" + "\t4-IsBroken: " + Watch.isBroken(watch) );
    }
    public static void show(eWatch watch)
    {
        System.out.println("\t1-Type:"+new StringBuilder(watch.getClass().toString()).delete(0,10)+"\n" +"\t2-Price: " + watch.getPrice() + "\n" + "\t3-Name: " + watch.getName() + "\n" + "\t4-IsBroken: " + Watch.isBroken(watch) + "\n" + "\t5-Power: " + watch.getPower() );
    }
    public static void show(mWatch watch)
    {
        System.out.println("\t1-Type:"+new StringBuilder(watch.getClass().toString()).delete(0,10)+"\n" +"\t2-Price: " + watch.getPrice() + "\n" + "\t3-Name: " + watch.getName() + "\n" + "\t4-IsBroken: " + Watch.isBroken(watch)+ "\n" + "\t5-Details num: " + watch.getDetails_num() );
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);// объявления сканера(считывает с консоли значения)
        System.out.println("Enter arrays sizes");
        int n = in.nextInt(),m=in.nextInt(), max=-1;//объявление и инциализация размеров массива и максимума
        eWatch[] eWatches = new eWatch[n];//объявление массива
        mWatch[] mWatches = new mWatch[m];
        int comm;
        System.out.println("Menu: 1-calculate, 2-show obj char, 3-change obj char");
        for (int i=0;i<n;i++)
        {
            eWatches[i] = new eWatch((int)(Math.random()*1000+100),"Apple",(int)(Math.random()*100));//инициализация элемента массива
            System.out.println("CHECK: "+(i+1));
            show(eWatches[i]);
        }
        for (int i=0;i<m;i++)
        {
            mWatches[i] = new mWatch((int)(Math.random()*1000+100),"Rolex",(int)(Math.random()*10));//мас рандом возвращает дабл, в конструкторе элемент инт, инт в скобочках приводит к типу инт
            System.out.println("CHECK: "+(i+1+n));
            show(mWatches[i]);
        }
        System.out.println("Menu: 1-calculate, 2-show obj char, 3-change obj char,4-exit");
        System.out.println("Enter comm");
        comm = in.nextInt();
        while (comm!=4){
            switch (comm)
            {
                case 1:{
                    for (int i=0;i<n;i++) if(eWatches[i].compare(max)) max = eWatches[i].getPrice();
                    for (int i=0;i<m;i++) if(mWatches[i].compare(max)) max = mWatches[i].getPrice();
                    System.out.println("Max price: "+max);
                    break;
                }
                case 2:{
                    System.out.println("Enter obj num,if u want show all enter -1");
                    int objNum = in.nextInt();
                    if(objNum==-1)
                    {
                        for (int i=0;i<n;i++)
                        {
                            System.out.println("CHECK: "+(i+1));
                            show(eWatches[i]);
                        }
                        for (int i=0;i<m;i++)
                        {
                            System.out.println("CHECK: "+(i+1+n));
                            show(mWatches[i]);
                        }
                    }
                    else if (objNum<=eWatches.length) show(eWatches[objNum-1]);
                    else  show(mWatches[objNum-1-m]);
                    break;
                }
                case 3:{
                    System.out.println("Enter obj num");
                    int objNum = in.nextInt();
                    if (objNum<=eWatches.length) {
                        show(eWatches[objNum- 1]);
                        System.out.println("Enter char num");
                        int comm2 = in.nextInt();
                        switch (comm2){
                            case 1:{
                                System.out.println("Type doesnt changes");
                                break;
                            }
                            case 2:{
                                System.out.println("Enter new price");
                                eWatches[objNum-1].setPrice(in.nextInt());
                                break;
                            }
                            case 3:{
                                System.out.println("Enter new name");
                                in.nextLine();
                                eWatches[objNum-1].setName(in.nextLine());
                                break;
                            }
                            case 4:{
                                System.out.println("Broke?(Enter true or false)");
                                in.nextLine();
                                if(in.nextLine().equals("true")) Watch.Broke(eWatches[objNum-1]);
                                break;
                            }
                            case 5:{
                                System.out.println("Enter a power");
                                eWatches[objNum-1].setPower(in.nextInt());
                                break;
                            }
                        }
                        show(eWatches[objNum-1]);
                    }
                    else {
                        show(mWatches[objNum-n-1]);
                        System.out.println("Enter char num");
                        int comm2 = in.nextInt();
                        switch (comm2){
                            case 1:{
                                System.out.println("Type doesnt changes");
                                break;
                            }
                            case 2:{
                                System.out.println("Enter new price");
                                mWatches[objNum-1-n].setPrice(in.nextInt());
                                break;
                            }
                            case 3:{
                                System.out.println("Enter new name");
                                in.nextLine();
                                mWatches[objNum-1-n].setName(in.nextLine());
                                break;
                            }
                            case 4:{
                                System.out.println("Broke?(Enter true or false)");
                                in.nextLine();
                                if(in.nextLine().equals("true")) Watch.Broke(mWatches[objNum-1-n]);
                                break;
                            }
                            case 5:{
                                System.out.println("Enter a details_num");
                                mWatches[objNum-1-n].setDetails_num(in.nextInt());
                                break;
                            }
                        }
                        show(mWatches[objNum-n-1]);
                    }
                    break;
                }
                default:{
                    break;
                }
            }
            System.out.println("Menu: 1-calculate, 2-show obj char, 3-change obj char,4-exit");
            System.out.println("Enter comm");
            comm = in.nextInt();
        }
    }
}
