/**
 * LeetCode 876 Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode twoPoint = head.next.next;
        head = head.next;
        while (twoPoint != null && twoPoint.next != null) {
            twoPoint = twoPoint.next.next;
            head = head.next;
        }
        return head;
    }
}
