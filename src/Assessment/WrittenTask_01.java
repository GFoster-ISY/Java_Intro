package Assessment;

public class WrittenTask_01 {
    public static void main (String[] args){
        // Question 1
        System.out.println("10 9 8 7 6 5 4 3 2 1");
        // Question 2
        int num = 7;
        for (int i = 1;i <= num; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        // Question 3
        int num1 = 3;
        int num2 = 8;
        for (int i = num1; i < num2; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        // Question 4
        num1 = 56;
        num2 = 74;
        if (num1 < num2){
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }
        // Question 5
        String str = new String("Hello");
        String rev = new String();
        for (int i = str.length()-1; i>= 0; i--){
            rev = rev + str.substring(i,i+1);
        }
        System.out.println(rev);
        // Question 6
        int [] data = {3,7,5,6,9,12,2,7};
        int largest = data[0];
        for (int i = 0; i < data.length; i++){
            if (largest < data[i]){
                largest = data[i];
            }
        }
        System.out.println(largest);
        // Question 7 - trace table
        int a = 3;
        int b = 6;
        while (b>0){
            if (a%2 == 0){
                b = b - a;
                System.out.println(b);
            }
            a++;
            System.out.println(a);
        }
    }
}
