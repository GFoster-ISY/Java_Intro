package P01_Screen;

import java.util.Scanner;

public class C02_Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the first number: ");
        String number = in.nextLine();
        int a = Integer.parseInt(number);

        System.out.print("Please enter the second number: ");
        number = in.nextLine();
        int b = Integer.parseInt(number);

        System.out.println(a + " + " + b + " = " + (a+b));
    }
}