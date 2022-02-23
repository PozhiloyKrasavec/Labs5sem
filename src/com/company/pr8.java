package com.company;

public class pr8 {
    public static void main(String[] args) {
        String l = Kancelyaria_1.valueOf("Paper2").getProizv();

        int ans = 0;
        Kancelyaria_1 g = null;
        for (Kancelyaria_1 m: Kancelyaria_1.values())
        {
            System.out.println("В наличии: " + m.getProizv() + ", "+ m.getKolvo());
            if (l == m.getProizv()){
                ans+= m.getKolvo();
                g = m;
            }
        }
        if (g.getDiam() == 0){
            System.out.println("Ответ: \n" + "\tКоличество товара производителя " + g.getProizv() + " - " + ans + "." + "\n" + "\tДругие характеристики товара (формат бумаги) - " + g.getForm() + "\n" + "\tСтоимость упаковки бумаги - " + g.getPrice() + " рублей.");
        }
        else {
            System.out.println("Ответ: \n" + "\tКоличество товара производителя " + g.getProizv() + " - " + ans + "." + "\n" + "\tДругие характеристики товара (диаметр стержня) - " + g.getDiam() + " мм." + "\n" + "\tСтоимость одной ручки - " + g.getPrice() + " рублей.");
        }
        int v= 0;
        for (Kancelyaria_1 m: Kancelyaria_1.values())
        {
            if (m.getPokupka() != 0){
                v+= m.getPrice() * m.getPokupka();
            }
        }
        System.out.println("Общая стоимость покупки составила: " + v + " рублей.");
    }
}
