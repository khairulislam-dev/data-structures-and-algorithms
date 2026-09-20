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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode list = head;
        ListNode tail = list;
        ListNode temp = head.next;

        while (temp != null) {
            if (tail.val != temp.val) {
                tail = tail.next;
                temp = temp.next;
            } else {
                temp = temp.next;
                tail.next = temp;
            }
        }
        return list;
    }
}