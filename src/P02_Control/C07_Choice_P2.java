package P02_Control;

import java.util.Scanner;

public class C07_Choice_P2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int a = getNumber(keyboard, "Please enter your number: ");
        if (a >= 0) {
            do {
                System.out.print(a + " ");
                a = a - 1;
            } while (a >= 0);
        } else {
            do {
                System.out.print(a + " ");
                a = a + 1;
            } while (a <= 0);
        }
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
}
