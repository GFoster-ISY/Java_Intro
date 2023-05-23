package Abstract_Data_Types;

public class Recursion {
    public static void main(String[] args){
        System.out.println(factorial(10));
        System.out.println(fun(5));
        System.out.println(fun2(10,8));
        System.out.println(fun3(5,1));
        long startTime = System.nanoTime();
        System.out.println("35: " + fib(35));
        long duration = System.nanoTime() - startTime;
        System.out.println(duration + " nanoseconds");
        startTime = System.nanoTime();
        System.out.println("40: " + fib(40));
        duration = System.nanoTime() - startTime;
        System.out.println(duration + " nanoseconds");
        startTime = System.nanoTime();
        System.out.println("45: " + fib(45));
        duration = System.nanoTime() - startTime;
        System.out.println(duration + " nanoseconds");
        startTime = System.nanoTime();
        System.out.println("50: " + fib2(50));
        duration = System.nanoTime() - startTime;
        System.out.println(duration + " nanoseconds");
    }

    public static int factorial(int n){
        if (n<=1) return 1;
        return factorial(n-1)*n;
    }

    public static int fun(int n){
        if (n <= 0) return 1;
        return n + 2*fun(n-1);
    }

    public static int fun2(int x, int y){
        if (x<=0 || y <=0)return x+y;
        return x + y + fun2(2*x-y, 2*y-x);
    } // will this always end?

    public static int fun3(int x, int y){
        if (x <=0) return y;
        return y+fun3(x-1, y+1);
    }

    public static long fib(int n) {
        if (n == 0 || n == 1) return 1;
        return fib(n-1)+ fib(n-2);
    }

    static long[] fibN;
    public static long fib2(int n) {
        fibN = new long[n + 1];
        return fibD(n);
    }
    public static long fibD(int n){
        if (fibN[n]!= 0) return fibN[n];
        if (n == 0 || n == 1){
            fibN[n]=1;
            return 1;
        }
        fibN[n] =fibD(n-1)+ fibD(n-2);
        return fibN[n];
    }
}
