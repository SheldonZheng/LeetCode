/**
 * LeetCode 328 Odd Even Linked List
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head.next;
        ListNode holderTwo = two;
        while (two != null && two.next != null) {
            one.next = two.next;
            one = one.next;
            two.next = one.next;
            two = two.next;
        }
        one.next = holderTwo;
        return head;
    }
}
