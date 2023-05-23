package Abstract_Data_Types;

import java.util.ArrayList;

public class StackTestTemplate {
    public static void main(String[] args) {
        StackTemplate<Integer> stack = new StackTemplate<>(10);
        stack.display();
        stack.push(3);
        stack.push(6);
        stack.push(2);
        stack.display();
        displayPop(stack);
        stack.display();
        displayPop(stack);
        displayPop(stack);
        stack.display();
        StackTemplate<String> stack2 = new StackTemplate<>(10);
        stack2.push("Hello");
        stack2.push("Goodbye");
        stack2.push("The end");
        stack2.display();
        displayPop(stack2);
        stack2.display();
    }

    public static void displayPop(StackTemplate s){
        System.out.println(s.pop() + " was popped from the stack.");
    }
}

class StackTemplate<T>{
    T[] stack;
    int top;
    StackTemplate(int size){
        stack = (T[])new Object[size];
        top = 0;
    }
    public void push(T n){
        stack[top]=n;
        top++;
    }
    public T pop(){
        top--;
        return stack[top];
    }
    public boolean isEmpty(){
        return top==0;
    }
    public void display(){
        if (isEmpty()) System.out.print("The stack is empty.");
        for (int i = 0; i < top; i++){
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
}