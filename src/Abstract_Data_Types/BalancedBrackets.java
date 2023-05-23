package Abstract_Data_Types;

import java.util.HashSet;
import java.util.Set;

public class BalancedBrackets {
    static Queue<TestCase> testCases;
    static final int NUMBER_OF_TEST_CASES = 13;

    public static void main(String[] args) {
        testCases = new Queue<>(NUMBER_OF_TEST_CASES);
        testCases.enqueue(new TestCase("()", true));
        testCases.enqueue(new TestCase("([{(())}])", true));
        testCases.enqueue(new TestCase("([{(()}])", false));
        testCases.enqueue(new TestCase("([{(())}]", false));
        testCases.enqueue(new TestCase("([)]", false));
        testCases.enqueue(new TestCase(")(", false));
        testCases.enqueue(new TestCase("", true));
        testCases.enqueue(new TestCase("<<<<<>>>><<<<>>>>>", true));
        testCases.enqueue(new TestCase("<<<<<>>>><<<<>>>>", false));
        testCases.enqueue(new TestCase("((])", false));
        testCases.enqueue(new TestCase("()[]{}<>", true));
        testCases.enqueue(new TestCase("()[]{}>", false));
        testCases.enqueue(new TestCase("()[]{<}>", false));
        while (!testCases.isEmpty()){
            TestCase tc = testCases.dequeue();
            boolean result = tc.runTest();
            if (!result){
                System.out.println("ERROR: " + tc);
            }
        }
        TestCase.summary();
    }

} // end of class BalancedBrackets

class CheckBrackets {
    String data;
    static Set<String> open = new HashSet<>();
    static Set<String> pair = new HashSet<>();

    public static void init() {
        if (open.isEmpty()) {
            open.add("(");
            open.add("[");
            open.add("{");
            open.add("<");
            pair.add("()");
            pair.add("[]");
            pair.add("{}");
            pair.add("<>");
        }
    }

    public String toString(){
        return data;
    }

    CheckBrackets(String data){
        init();
        this.data = data;
    }

    public boolean runCheck(){
        StackTemplate<String> openBrackets = new StackTemplate<>(data.length());
        for (int i = 0; i < data.length(); i++) {
            String b = "" + data.charAt(i);
            if (open.contains(b)) {
                openBrackets.push(b);
            } else {
                if (openBrackets.isEmpty()) {return false;}
                String input = openBrackets.pop() + b;
                if (!pair.contains(input)){
                    return false;
                }
            }
        }
        return openBrackets.isEmpty();
    }
}
class TestCase{
    boolean expected;
    CheckBrackets data;
    static int testsRun = 0;
    static int testsFailed = 0;
    TestCase(String data, boolean expected){
        this.expected = expected;
        this.data = new CheckBrackets(data);
    }

    public boolean runTest(){
        boolean result = data.runCheck();
        testsRun++;
        if (result != expected){
            testsFailed++;
        }
        return result == expected;
    }

    @Override
    public String toString() {
        return data + " :" + expected;
    }

    public static void summary(){
        System.out.println(testsRun + " Tests run");
        System.out.println(testsFailed + " Tests failed");
    }
}

class Queue<T> {
    T[] queue;
    int front;
    int end;
    Queue(int size){
        queue = (T[])new Object[size];
        front = 0;
        end = -1;
    }

    public void enqueue(T n){
        end = (end+1) % queue.length;
        queue[end] = n;
    }
    public T dequeue(){
        T value = queue[front];
        queue[front]=null;
        front = (front+1) % queue.length;
        return value;
    }

    public boolean isEmpty(){
        return queue[front] == null;
    }

    public void display(){
        if (front < end) {
            for (int i = front; i <= end; i++) {
                if (i == front) System.out.print("front: ");
                if (i == end) System.out.print("end: ");
                System.out.print(queue[i] + " ");
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                if (i == end) System.out.print("end: ");
                if (i == front) System.out.print("front: ");
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= end; i++) {
                if (i == end) System.out.print("end: ");
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println();
    }
}