package Assessment;

public class TraceExample {
    public static void main(String[] args) {
        // Example 1
        System.out.println("Example 1");
        {
            int a = 3;
            int b = 10;
            int q = 0;
            System.out.println(a + " " + b + " " + q);
            while (b > a) {
                b = b - a;
                q = q + 1;
                System.out.println(a + " " + b + " " + q);
            }
        }
        // Example 2
        System.out.println("Example 2");
        {
            int a = 4;
            int b = 36;
            System.out.println(b + " " + a);
            while ((b+a) % 2 == 0){
                b = b / a;
                a = a - 1;
                System.out.println(b + " " + a);
            }
        }
        // Example 3
        System.out.println("Example 3");
        {
            int a = 10;
            int b = 3;
            System.out.println(b + " " + a);
            while (a > b){
                if (a % b == 0){
                    a = a - b;
                } else {
                    b = b + 1;
                }
                System.out.println(b + " " + a);
            }
        }
    }
}
