package solve;

public class addTowNumber {

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tail = null;
        ListNode ll = null;
        int remainder = 0;

        while (l1 != null || l2 != null) {

            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10 || (sum + remainder) >= 10) {
                if (remainder == 1) {
                    sum += 1;
                }
                sum = sum % 10;
                if (ll == null) {
                    tail = ll = new ListNode(sum);
                } else {
                    ListNode newNode = new ListNode(sum);
                    tail.next = newNode;
                    tail = newNode;
                }
                remainder = 1;
            } else {
                if (remainder == 1) {
                    sum += 1;
                    if (sum == 10) {
                        remainder = 1;
                    }
                }
                if (ll == null) {
                    tail = ll = new ListNode(sum);
                } else {
                    ListNode newNode = new ListNode(sum);
                    tail.next = newNode;
                    tail = newNode;
                }
                remainder = 0;
            }
            sum = 0;
        }

        if (remainder == 1) {
            tail.next = new ListNode(1);
        }
        return ll;
    }
}