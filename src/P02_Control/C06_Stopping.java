package P02_Control;

import java.util.Scanner;

public class C06_Stopping {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String cont;
        do {
            int a = getNumber(keyboard, "Please enter the first number: ");
            int b = getNumber(keyboard, "Please enter the second number: ");
            System.out.println(a + " + " + b + " = " + (a + b));
            System.out.print("Do you wish to continue? (Y/y) ");
            cont = keyboard.nextLine();
            cont = cont.substring(0,1).toUpperCase();
        } while (cont.equals("Y"));
        System.out.println("Goodbye.");
    } // end of main method

    public static int getNumber(Scanner keyboard, String prompt){
        System.out.print(prompt);
        String number = keyboard.nextLine();
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            System.out.println ("'" + number + "'" + " is not a valid integer. Please try again.");
            return getNumber(keyboard, prompt);
        }
    } // end of getNumber method
} // end of C06_Stopping class
