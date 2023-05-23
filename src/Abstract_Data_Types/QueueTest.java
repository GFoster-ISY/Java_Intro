package Abstract_Data_Types;

public class QueueTest {
    public static void main(String[] args) {
        IntQueue q = new IntQueue(8);
        q.enqueue(7);
        q.enqueue(3);
        q.enqueue(9);
        q.display();
        q.enqueue(5);
        q.enqueue(1);
        q.display();
        q.dequeue();
        q.display();
        q.enqueue(4);
        q.display();
        q.enqueue(8);
        q.enqueue(15);
        q.enqueue(11);
        q.display();
        q.dequeue();
        q.display();
    }
}

class IntQueue {
    int[] queue;
    int front;
    int end;
    IntQueue(int size){
        queue = new int[size];
        front = 0;
        end = -1;
    }

    public void enqueue(int n){
        end = (end+1) % queue.length;
        queue[end] = n;
    }
    public int dequeue(){
        int value = queue[front];
        queue[front]=0;
        front = (front+1) % queue.length;
        return value;
    }

    public boolean isEmpty(){
        return queue[front] == 0;
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