package P01_Screen;

import java.util.Scanner;

public class C03_Exception {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the first number: ");
        String number = keyboard.nextLine();
        int a;
        int b;
        try {
            a = Integer.parseInt(number);
        } catch (NumberFormatException e){
            System.out.println (number + " is not a valid integer");
            return;
        }
        System.out.print("Please enter the second number: ");
        number = keyboard.nextLine();
        try {
            b = Integer.parseInt(number);
        } catch (NumberFormatException e){
            System.out.println (number + " is not a valid integer");
            return;
        }

        System.out.println(a + " + " + b + " = " + (a+b));
    } // end of main method
} // end of P01_Screen.C03_Exception class
