package Abstract_Data_Types;

public class LinkedListTestTemplate {

    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.display();
        list.addNode(2);
        list.display();
        list.deleteNode(2);
        list.display();
        list.append(2);
        list.display();
        list.addNode(5);
        list.addNode(4);
        list.addNode(9);
        list.addNode(7);
        list.addNode(1);
        list.display();
        list.deleteNode(4);
        list.display();
        list.deleteNode(1);
        list.display();
        list.deleteNode(2);
        list.display();
        list.append(8);
        list.display();
        NodeT<Integer> n = list.findNode(9);
        n.display();
        n = list.findNode(8);
        n.display();
        n = list.findNode(10);
        if (n == null) {
            System.out.println("Node not found");
        } else {
            n.display();
        }
        n = list.deleteNode(7);
        n.display();
        list.display();
    }
}

class List<T>{
    NodeT<T> startNode;
    NodeT <T>endNode;

    List(){
        startNode = null;
        endNode = null;
    }

    public void addNode(T data){
        NodeT<T> newNode = new NodeT<>(data);
        if (startNode == null){
            startNode = newNode;
            endNode = newNode;
        } else {
            newNode.next = startNode;
            startNode = newNode;
        }
    }

    public void append(T data){
        NodeT<T> newNode = new NodeT<>(data);
        if (startNode == null){
            startNode = newNode;
        } else {
            endNode.next = newNode;
        }
        endNode = newNode;
    }
    public NodeT<T> findNode(T data){
        NodeT<T> currentNode = startNode;
        while (currentNode != null){
            if (currentNode.data.equals(data)){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void display(){
        if (startNode == null){
            System.out.println("The list is empty");
            return;
        }
        NodeT<T> posn = startNode;
        while (posn != null){
            System.out.print(posn.data + " ");
            posn = posn.next;
        }
        System.out.println();
    }

    public NodeT<T> deleteNode(T data){
        NodeT<T> currentNode = startNode;
        NodeT<T> beforeNode = startNode;
        if (startNode == null){
            return null;
        }
        if (currentNode.data == data){
            startNode = currentNode.next;
            if (startNode == null){
                endNode = null;
            }
            return currentNode;
        }
        currentNode = currentNode.next;
        while (currentNode != null){
            if (currentNode.data == data){
                beforeNode.next = currentNode.next;
                if (beforeNode.next == null){
                    endNode = beforeNode;
                }
                return currentNode;
            }
            beforeNode = currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
}

class NodeT<T>{
    T data;
    NodeT<T> next;
    NodeT(T d){
        data = d;
        next = null;
    }
    void display(){
        System.out.println("data: " + data + " next: " + next);
    }
}