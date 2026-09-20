import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LeetCode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (head.next == null) {
            return head;
        }
        if (size == n) {
            head = head.next;
            return head;
        }
        size = size - n;
        temp = head;

        int i = 1;
        while (i < size) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static ListNode removeElements(ListNode head, int val) {
        // base case
        while (head != null && head.val == val) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode temp = head.next;
        while (prev != null && prev.next.next != null && temp.next != null) {
            if (temp.val == val) {
                prev.next = temp.next;
                prev = temp.next;
                temp = temp.next;
            } else {
                if (prev.next != null) {
                    prev = prev.next;
                }
                temp = temp.next;
            }
        }
        if (temp.next.next == null) {
            prev.next = null;
        } else {
            prev = prev.next;
        }
        return head;
    }

    // public static String longestCommonPrefix(String[] arr) {
    // String str = "";
    // String s = arr[0];

    // for (int i = 0; i < arr.length; i++) {

    // for (int j = 0; j < arr[i].length(); j++) {

    // if (j < s.length() && s.charAt(j) == arr[i].charAt(j)) {
    // System.out.println(s.charAt(j));
    // }

    // }
    // str += arr[0].charAt(i) + "";
    // }
    // return "";
    // }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode list = new ListNode(-220);
        ListNode tail = list;

        ListNode left = head;
        ListNode right = head.next;
        boolean flag = false;

        while (right != null) {
            while (left.val == right.val) {
                right = right.next;
                flag = true;
            }
            if (flag) {
                left = right;
                flag = false;
            } else {
                tail.next = left;
                tail = left;
                left = right;
                tail.next = null;
            }
            right = right.next;
        }
        tail.next = left;
        return list.next;
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {

        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            hs.add(n);
        }

        ListNode prev = null;
        ListNode tail = head;
        ListNode temp = head;

        while (temp != null) {
            if (!hs.contains(temp.val)) {
                tail.val = temp.val;
                prev = tail;
                tail = tail.next;
            }
            temp = temp.next;
        }

        prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        // String str = "dvdf";
        // ArrayList<Character> chars = new ArrayList<>();
        // int maxLen = 0;
        // for (int i = 0; i < str.length(); i++) {
        // for (int j = i; j < str.length(); j++) {
        // if (!chars.contains(str.charAt(j))) {
        // chars.add(str.charAt(j));
        // } else {
        // break;
        // }
        // }
        // maxLen = Math.max(maxLen, chars.size());
        // chars.clear();
        // }
        // System.out.println("length: " + maxLen);

        // String strs[] = { "a", "a", "cbd" };
        // String r = longestCommonPrefix(strs);
        // String str = "1";
        // System.out.println(str.substring(0));

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(6);
        // head.next.next.next = new ListNode(3);
        // head.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next.next = new ListNode(6);

        // removeElements(head, 6);

        // while (head != null) {
        // System.out.print(head.val + " ");
        // head = head.next;
        // }
        // System.out.print("null");

        // ListNode r = removeNthFromEnd(head, 1);

        // while (r != null) {
        // System.out.println(r.val);
        // r = r.next;
        // }

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // ListNode newNode = new ListNode(5);
        // head.next.next = newNode;
        // head.next.next.next = new ListNode(3);
        // // head.next.next.next.next = newNode;

        // ArrayList<ListNode> list = new ArrayList<>();

        // ListNode temp = head;
        // while (temp != null) {
        // if (!list.contains(temp)) {
        // list.add(temp);
        // }
        // temp = temp.next;
        // }

        // System.out.println(list);

        // LinkedList<ListNode> ll = new LinkedList<>();

        // ListNode temp = head;

        // while (temp != null) {
        // System.out.println(ll.contains(temp));
        // if (!ll.contains(temp)) {
        // ll.addLast(temp);
        // }
        // temp = temp.next;
        // }

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(1);
        // head.next.next = new ListNode(1);
        // head.next.next.next = new ListNode(3);
        // head.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next.next = new ListNode(5);

        // ListNode r = deleteDuplicates(head);

        // ListNode temp = r;
        // while (temp != null) {
        // System.out.print(temp.val + " ");
        // temp = temp.next;
        // }

        String s = "abcd";
        String t = "dcba";

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        System.out.println(hm);

        for(int i=0; i<t.length(); i++){
            Character ch = t.charAt(i);
            if(!hm.containsKey(ch)){
                // return false;
            }
            hm.put(ch, hm.get(ch)-1);
        }

        System.out.println(hm.isEmpty());


    }
}
