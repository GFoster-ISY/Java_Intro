package Assessment;

public class WrittenTask_02 {
    public static void main (String[] args) {
        // Question 1
        System.out.println("1,2,3,4,5,6,7,8,9,10");
        // Question 2
        int num = 11;
        for (int i = 2; i <= num; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        // Question 3
        int num1 = 5;
        int num2 = 13;
        for (int i = num1 + 1; i < num2; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // Question 4
        num1 = 56;
        num2 = 74;
        if (num1 > num2) {
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }
        // Question 5
        String str = new String("Hello");
        String mid = str.substring(1, str.length() - 1);
        System.out.println(mid);
        // Question 6
        int[] data = {3, 7, 5, 6, 9, 12, 2, 7};
        int evenCount = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println(evenCount);

        // Question 7 - trace table
        int a = 3;
        int b = 6;
        while (b % 2 == 0) {
            if (a >= b) {
                b = b - a;
                System.out.println(b);
            }
            a = a + 3;
            System.out.println(a);
        }
    }
}
