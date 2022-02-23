package com.company;
import java.util.Scanner;

public class pr3_1 {
    public static void main(String[] args) {
    System.out.println("Enter a number");
    Scanner in = new Scanner(System.in);
    while (in.hasNext())
    {
        int x = in.nextInt();
        try {
            int y = 78/x;
            System.out.println(y);
        }
        catch (ArithmeticException exception)
        {
            System.out.println("Division by zero");
        }
    }
}

}
