package P01_Screen;

import java.util.Scanner;

public class C04_Valid_Input {

    public static void main(String[] args) {
        int a = getNumber("Please enter the first number: ");
        int b = getNumber("Please enter the second number: ");
        System.out.println(a + " + " + b + " = " + (a+b));
    } // end of main method

    public static int getNumber(String prompt){
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        String number = keyboard.nextLine();
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            System.out.println (number + " is not a valid integer. Please try again.");
            return getNumber(prompt);
        }
    } // end of getNumber method
} // end of class P01_Screen.C04_Valid_Input
