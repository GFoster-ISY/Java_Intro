package Abstract_Data_Types;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.display();
        list.addNode(2);
        list.addNode(5);
        list.addNode(4);
        list.addNode(9);
        list.addNode(7);
        list.addNode(1);
        list.display();
        list.deleteNode(4);
        list.display();
        list.deleteNode(5);
        list.addNode(3);
        list.addNode(8);
        list.display();
        Node n = list.findNode(3);
        n.display();
        n = list.findNode(9);
        n.display();
    }
}

class LinkedList{
    Node list;

    LinkedList(){
        list = null;
    }

    void appendNode(int data){
        list = new Node(data, list);
    }

    // Add nodes in ascending order
    void addNode(int data){
        // SPECIAL CASE empty list or wish to enter a new smaller number
        if (list == null || list.data >= data){
            appendNode(data);
            return;
        }
        // find where to insert the new node
        Node before = list;
        Node after = list.next;
        while (after != null && after.data <= data){
            before = after;
            after = after.next;
        }
        // create the new node and insert it at the right location
        Node newNode = new Node(data, after);
        before.next = newNode;
    }
    void deleteNode (int data){
        Node before = list;
        Node node = list;
        while (node != null && node.data != data){
            before = node;
            node = node.next;
        }
        if (node != null) {
            before.next = node.next;
        }
    }
    Node findNode(int data){
        Node node = list;
        while (node != null && node.data != data){
            node = node.next;
        }
        return node;
    }
    void display(){
        if (list == null){
            System.out.println("The list is empty");
            return;
        }
        Node posn = list;
        while (posn != null){
            System.out.print(posn.data + " ");
            posn = posn.next;
        }
        System.out.println();
    }
}
class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
    Node(int d, Node n){
        data = d;
        next = n;
    }
    void display(){
        System.out.println("data: " + data + " next: " + next);
    }
}