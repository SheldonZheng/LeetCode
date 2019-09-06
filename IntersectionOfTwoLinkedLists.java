/**
 * LeetCode 160 Intersection of Two Linked Lists
 * 解法就是 两个指针来抹平链表长度的差距 最多两次循环 如果有相交会走到一起 没有相交会走到null
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointA = headA;
        ListNode pointB = headB;
        //这里不会死循环 因为null == null is true
        while (pointA != pointB) {
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;
        }
        return pointA;
    }
}
