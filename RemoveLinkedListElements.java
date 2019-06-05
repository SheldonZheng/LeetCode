//LeetCode 203
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode holder = new ListNode(1);
        holder.next = head;
        ListNode point = holder;
        
        while (point.next != null) {
            if (point.next.val == val) {
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
        return holder.next;
    }
}
