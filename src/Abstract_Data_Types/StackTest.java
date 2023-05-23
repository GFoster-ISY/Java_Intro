package Abstract_Data_Types;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
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
        stack.pop();
    }

    public static void displayPop(Stack s){
        int value = s.pop();
        System.out.println(value + " was popped from the stack.");
    }
}

class Stack{
    int [] stack;
    int top;
    Stack(int size){
        stack = new int[size];
        top = 0;
    }
    public void push(int n){
        stack[top]=n;
        top++;
    }
    public int pop(){
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