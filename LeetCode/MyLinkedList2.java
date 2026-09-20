class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;
    static int size;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (head == null || index > size) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node newNode = new Node(val);
        if (head == null) {
            return;
        } else if (index == 1) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node prev = head;
        for (int i = 0; i < index - 2; i++) {
            prev = prev.next;
        }
        Node next = prev.next;
        prev.next = newNode;
        newNode.next = next;
        if(index-1 == size){
            tail = newNode;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (head == null || index >= size) {
            return;
        }

        if (head.next == null && index == 0) {
            head = tail = null;
            size--;
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node prev = head;
        for (int i = 0; i < index - 2; i++) {
            prev = prev.next;
        }

        Node next = prev.next.next;
        prev.next = next;
        size--;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}

public class MyLinkedList2 {
    public static void main(String[] args) {
        // MyLinkedList ll = new MyLinkedList();
        // ll.addAtHead(7);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: "  + MyLinkedList.tail.val);
        // ll.print();
        // ll.addAtHead(2);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: "  + MyLinkedList.tail.val);
        // ll.print();
        // ll.addAtHead(1);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: "  + MyLinkedList.tail.val);
        // ll.print();
        // ll.addAtIndex(3, 0);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: "  + MyLinkedList.tail.val);
        // ll.print();

        // ll.deleteAtIndex(2);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: " + MyLinkedList.tail.val);
        // ll.print();

        // ll.addAtHead(6);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: " + MyLinkedList.tail.val);
        // ll.print();

        // ll.addAtTail(4);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: " + MyLinkedList.tail.val);
        // ll.print();
        // System.out.println("get: " + ll.get(4));
        // ll.addAtHead(4);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: " + MyLinkedList.tail.val);
        // ll.print();
        // ll.addAtIndex(5, 0);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: " + MyLinkedList.tail.val);
        // ll.print();
        // ll.addAtHead(6);
        // System.out.println("Head: " + MyLinkedList.head.val + "--Tail: " + MyLinkedList.tail.val);
        // ll.print();
        // // ll.print();

        // int arr[] = new int[5];

        // System.out.println(arr.hashCode);


    }
}
