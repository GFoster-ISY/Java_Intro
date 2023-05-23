package P02_Control;

import java.util.Scanner;

public class C07_Choice { public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    String cont;
    do {
        int a = getNumber(keyboard, "Please enter the first number: ");
        int b = getNumber(keyboard, "Please enter the second number: ");
        System.out.println("Which operation do you wish to perform?");
        System.out.println("   1) Addition");
        System.out.println("   2) Subtraction");
        System.out.println("   3) Multiplication");
        System.out.println("   4) Division");
        String op = keyboard.nextLine();
        op = op.substring(0,1).toUpperCase();
        if (op.equals("1") || op.equals("+")) {
            System.out.println(a + " + " + b + " = " + (a + b));
        } else if (op.equals("2") || op.equals("-")) {
            System.out.println(a + " - " + b + " = " + (a - b));
        } else if (op.equals("3") || op.equals("*")) {
            System.out.println(a + " × " + b + " = " + (a * b));
        } else if (op.equals("4") || op.equals("/")) {
            System.out.println(a + " ÷ " + b + " = " + (a / b) + " remainder " + (a % b));
        } else {
            System.out.println("Unknown operation");
        }
        System.out.print("Do you wish to continue? (Y/y) ");
        cont = keyboard.nextLine();
        cont = cont.substring(0,1).toUpperCase();
    } while (cont.equals("Y"));
    System.out.println("Goodbye.");
} // end of main method

    public static int getNumber(Scanner keyboard, String prompt){
        boolean finished = false;
        int num=0;
        do {
            System.out.print(prompt);
            String number = keyboard.nextLine();
            try {
                finished = true;
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.out.println("'" + number + "'" + " is not a valid integer. Please try again.");
                finished = false;
            }
        } while (!finished);
        return num;
    } // end of getNumber method
} // end of C07_Choice class
