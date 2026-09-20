public class LinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add first
    public void addFirst(int data) {
        // create newNode
        Node newNode = new Node(data);
        size++;

        // head is null point head and tail = newNode
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // newNode.next point head
        newNode.next = head;
        head = newNode;
    }

    // add last
    public void addLast(int data) {
        // create newNode
        Node newNode = new Node(data);
        size++;

        // head is null
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // tail.next = newNode
        tail.next = newNode;
        tail = newNode;
    }

    // print
    public void print() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    // add
    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        // create newNode
        Node newNode = new Node(data);
        size++;
        Node tempNode = head;
        int i = 0;

        while (i < index - 1) {
            tempNode = tempNode.next;
            i++;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    // remove first
    public int removeFirst() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    // remove last
    public int removeLast() {
        // corner case
        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }

        Node tempNode = head;
        while (tempNode.next.next != null) {
            tempNode = tempNode.next;
        }

        int data = tempNode.next.data;
        tempNode.next = null;
        tail = tempNode;
        size--;
        return data;
    }

    // search(Iterative)
    public int iterativeSearch(int key) {
        int i = 0;
        Node tempNode = head;

        while (tempNode != null) {
            if (tempNode.data == key) {
                return i;
            }
            tempNode = tempNode.next;
            i++;
        }
        return -1;
    }

    // search (recursive ways)
    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    // helper
    public int helper(Node head, int key) {
        // base case
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int i = helper(head.next, key);
        if (i == -1) {
            return -1;
        }
        return i + 1;
    }

    // reverse a linked list (Iterative approach)
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and Remove Nth Node from End
    public void removeNthNodeFromEnd(int n) {
        // find node size
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        // corner case handle
        if (n == length) {
            head = head.next;
            return;
        }

        // find and remove nth node
        int i = 0;
        int size = length - n;
        Node prev = head;

        while (i < size - 1) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public Node findMid() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome() {
        // base case
        if (head == null || head.next == null) {
            return true;
        }

        // find mid
        Node midNode = findMid();
        // reverse right half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // compare last.data == right.data
        Node left = head;
        Node right = prev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // is Cycle in a linkedList
    public static boolean isCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // remove cycle detection
    public static void removeCycle(Node head) {
        // detected cycle
        Node slow = head;
        Node fast = head;

        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // slow = head // fast already meeting point
        // prev = null
        // slow+1 and fast+1 if not meeting
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge sort in LinkedList
    public Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // divide half
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        // call leftHead
        Node newLeft = mergeSort(leftHead);
        // call rightHead
        Node newRight = mergeSort(rightHead);
        // final merge heftHead,rightHead
        return merge(newLeft, newRight);
    }

    public Node merge(Node head1, Node head2) {
        Node mergeList = new Node(-1);
        Node temp = mergeList;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                temp = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = head2;
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            temp = head1;
            head1 = head1.next;
        }

        while (head2 != null) {
            temp.next = head2;
            temp = head2;
            head2 = head2.next;
        }
        return mergeList.next;
    }

    // Zig-Zag problem

    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        Node rightHead = mid.next;
        mid.next = null;

        // reverse 2nd half
        Node prev = null;
        Node curr = rightHead;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // alter merge left half and right half
        Node left = head;
        Node right = prev;
        Node nextL;
        Node nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // update node
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();
        ll.zigZag();
        ll.print();
        // head = ll.mergeSort(head);
        // ll.print();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(1);
        // // ll.addLast(1);
        // ll.print();
        // System.out.println("index: " + ll.iterativeSearch(1));
        // System.out.println("index: " + ll.recursiveSearch(4));
        // ll.removeNthNodeFromEnd(2);
        // boolean r = ll.isPalindrome();
        // System.out.println(r);

        // LinkedList.Node head = ll.new Node(1);
        // head.next = ll.new Node(2);
        // LinkedList.Node temp = ll.new Node(8);
        // head.next.next = temp;
        // head.next.next.next = ll.new Node(3);
        // head.next.next.next = temp;
        // System.out.println(isCycle(head));
        // removeCycle(head);
        // System.out.println(isCycle(head));
    }

}
