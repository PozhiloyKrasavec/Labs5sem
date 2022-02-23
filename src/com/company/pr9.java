package com.company;
import java.util.Scanner;
import java.util.Vector;
public class pr9 {
    static String[] companies ={"Snezhinka", "Svetocopy", "ACBK", "Bic", "Erich Krause", "InfoLine" };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kolvo = 0, summa = 0;
        System.out.println("Введите искомую компанию:");
        String insertComp = scanner.nextLine();
        Vector<Kancelyaria> kancelyarias = new Vector<>();
        int n = (int)Math.round(Math.random()*10+5);
        System.out.println("Размер массива: "+n);
        for (int i=0;i<n;i++)
        {
            if(i%2==0){
                kancelyarias.add(new Kancelyaria(companies[(int)Math.round(Math.random()*5)]));
            } else kancelyarias.add(new Kancelyaria((int)Math.round(Math.random()*15+40)));
            System.out.println("В наличии: "
                    + kancelyarias.get(i).getCalculated()
                    + ", Тип -  "
                    + kancelyarias.get(i).getCalculated().getClass().getTypeName().subSequence(10,kancelyarias.get(i).getCalculated().getClass().getTypeName().length()));
        }
        for(int i=0;i<n;i++)
        {
            if (kancelyarias.elementAt(i).getCalculated().getClass().getTypeName().contains("Integer"))
            {
                summa+=(int)kancelyarias.elementAt(i).getCalculated();
            }
            else if (kancelyarias.elementAt(i).getCalculated().equals(insertComp)) kolvo++;
        }
        System.out.println("Количество товаров заданной фирмы - " + kolvo + "\nОбщая сумма покупки составила - " + summa);
    }
    }



