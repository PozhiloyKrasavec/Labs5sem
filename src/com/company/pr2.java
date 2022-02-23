package com.company;


import java.util.Scanner;

public class pr2 {
    public static void main(String[] args) {

        String alfa = "абвгдежзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ" + ", ;.-";

        String keyword = "СЕКРЕТ";

        String sentence = "Привет.привет";

        System.out.println(sentence);

        char[] sent = sentence.toCharArray(); //массив с предложением

        char[] alfaArray = alfa.toCharArray(); //массив с алфавитом

        int x = 3; //переменная для цикла

        int i = 0;

        Scanner in = new Scanner(System.in);

        while (x != 0) {

            System.out.println();

            System.out.println("1 - Кодирование шифром замены");

            System.out.println("2 - Побитовое кодирование");

            System.out.println("Для выхода введите 0");

            System.out.print("Команда №");

            x = in.nextInt(); //x принимает введеное значение

            System.out.println();

            switch (x) {

                case 1: {

                    System.out.print("Введите величину сдвига:");

                    int n = in.nextInt();

                    sentence.getChars(0, sentence.length(), sent, 0);

                    alfa.getChars(0, alfa.length(), alfaArray, 0);

                    for (i = 0; i < sent.length; i++) {

                        for (int j = 0; j < alfaArray.length; j++) {

                            if (sent[i] == alfaArray[j]) {

                                sent[i] = alfaArray[(j + n) % alfaArray.length];

                                break;

                            }

                        }

                    }

                    System.out.print("Текст: ");

                    System.out.println(sentence);

                    System.out.print("Закодированный текст: ");

                    System.out.println(sent);

                    break;

                }

                case 2: {

                    System.out.print("Текст: ");

                    System.out.println(sentence);

                    System.out.print("Ключ: ");

                    System.out.println(keyword);

                    char[] key = keyword.toCharArray(); //массив в котором находится ключ

                    for (i = 0; i < sentence.length(); i++) {

                        sent[i] = alfa.charAt(alfa.indexOf(sent[i]) ^ alfa.indexOf(key[i % key.length]));
                    }

                    System.out.println("Закодированный текст: ");

                    System.out.println(sent);

                    for (i = 0; i < sentence.length(); i++) {

                        sent[i] = alfa.charAt(alfa.indexOf(sent[i]) ^ alfa.indexOf(key[i % key.length]));
                    }

                    System.out.println("Изначальный текст: ");

                    System.out.println(sent);

                    break;

                }

            }

        }
    }
}


