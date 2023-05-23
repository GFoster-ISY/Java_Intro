package Numbers;

import java.util.HashMap;

public class Palindrome {
    static HashMap<Integer, Integer> steps = new HashMap<>();
    static boolean DIAG = false;
    public static void main(String[] args) {
        test(65);
        test(75);
        test(747);
        DIAG = true;
        puzzle (196);
        DIAG = false;
        System.out.println();
//        System.out.print("  0:");
        for (int i = 1; i <10000000; i++) {
            int stepCount = puzzle(i);
            if (steps.containsKey(stepCount)) {
                Integer count = steps.get(stepCount);
                steps.put(stepCount, count + 1);
            } else {
                steps.put(stepCount,1);
            }
//            System.out.print(puzzle(i) + " ");
//            if (i % 100 == 0) {
//                System.out.println();
//                System.out.print(" " + i + ": ");
//            }
        }
        System.out.println(steps.size());
        for (Integer step : steps.keySet()){
            System.out.println(step + " " + steps.get(step));
        }
    }

    private static void test(long number){
        System.out.println(number + " " + isPalindrome(number));
    }

    private static int  puzzle (long number){
        int count = 0;
        if (DIAG) System.out.print(number);
        while (!isPalindrome(number)){
            number = number + reverse(number);
            if (number < 0 ){
                return -1;
            }
            count++;
            if (DIAG) System.out.print(" : " + number);
        }
        if (DIAG) System.out.println("\n(" + count + ") " + number);
        return count;
    }
    private static long reverse(long number){
        long reverse = 0;

        while(number != 0){
            reverse = reverse*10 + number%10;
            number = number/10;
        }

        return reverse;
    }

    private static boolean isPalindrome(long number){
        return number == reverse(number);
    }
}
