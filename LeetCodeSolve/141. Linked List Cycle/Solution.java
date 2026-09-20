/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode left = head;
        ListNode right = head.next.next;

        while (left != right) {
            if (right == null || right.next == null) {
                return false;
            }
            left = left.next;
            right = right.next.next;
        }
        return true;
    }
}