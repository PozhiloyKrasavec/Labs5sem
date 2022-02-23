package com.company;

import java.util.Scanner;

public class pr3_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = in.nextInt();
        char[] arr = new char[n];
        System.out.println("Enter a symbol array");
        try {
            enterArray(arr,in);
            System.out.println("Correct end");
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println("ArrayInderxOutOfBounds");
        }
    }
    public static void enterArray(char[] arr,Scanner in)  throws ArrayIndexOutOfBoundsException{
        for(int i=0;i<7;i++) arr[i] = (char)in.nextInt();
    }
}
