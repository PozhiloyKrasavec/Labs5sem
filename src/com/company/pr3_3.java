package com.company;

import java.lang.reflect.Member;

public class pr3_3 {
    static class MyException extends Exception{
        private int code;
        private char c;
        MyException(int a, char cc)
        {
            code = a;
            c = cc;
        }
        public String toString()
        {
            return "Character("+c+") = "+code;
        }

    }
    public static void sdvig(char a, char b) throws MyException
    {
        int a1 = (int) a, b1 = (int) b;
        if((a1<<2)<48) throw new MyException(a1<<2,a);
        if((b1>>1)<48) throw new MyException(b1>>1,b);
    }
    public static void main(String[] args) {
        char a='b',b='B';
        try {
            sdvig(a,b);
            System.out.println("without exception");
        }
        catch (MyException exc)
        {
            System.out.println("Exception worked "+exc);
        }
    }
}
