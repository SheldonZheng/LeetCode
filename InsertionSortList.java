//LeetCode 147
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode c = new ListNode(-1);
        c.next = head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val >= p.val) {
                p = p.next;
            } else {
               ListNode t = p.next;
               ListNode f = c;
               //cut
               p.next = p.next.next;
               //find
               while (f.next.val < t.val) {
                   f = f.next;
               }
               //link
                t.next = f.next;
                f.next = t;
            }

        }
        return c.next;
    }
}
