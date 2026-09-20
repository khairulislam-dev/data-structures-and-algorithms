public class DoublyLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add
    public void addFirst(int data) {
        Node newNode = new Node(data);
        // base case: if first node
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        Node next = head;
        head.prev = newNode;
        head = newNode;
        head.next = next;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        // base case: if first node
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        Node prev = tail;
        tail.next = newNode;
        tail = newNode;
        tail.prev = prev;
        size++;
    }

    // remove first node
    public int removeFirst() {
        if (head == null) {
            return Integer.MIN_VALUE;
        } else if (head.next == null && head.prev == null) {
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }

        int oldData = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return oldData;
    }

    // remove last node from doubly LinkedList
    public int removeLast() {
        if (head == null) {
            return Integer.MIN_VALUE;
        } else if (head.next == null && head.prev == null) {
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }

        int oldData = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return oldData;
    }

    // print node data
    public void print() {
        if (head == null) {
            System.out.println("Doubly linkedList are empty. ");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void print(Node head) {
        if (head == null) {
            System.out.println("Doubly linkedList are empty. ");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // reverse Doubly LinkedList
    public Node reverse() {
        if (head == null && head.next == null) {
            return head;
        }

        Node prev = head.prev;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String args[]) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(3);
        dll.addLast(4);
        dll.print();
        System.out.println("---------------------");
        Node result = dll.reverse();
        dll.print(result);
    }
}
