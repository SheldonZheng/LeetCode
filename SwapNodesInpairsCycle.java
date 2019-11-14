/**
 * LeetCode 24 Swap Nodes in Pairs
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;

        ListNode curr = prev;
        while (curr.next != null && curr.next.next != null) {
            ListNode l = curr.next;
            ListNode r = curr.next.next;
            curr.next = r;
            l.next = r.next;
            r.next = l;
            curr = l;
        }
        return prev.next;
    }
}
