/**
 * LeetCode 160 Intersection of Two Linked Lists
 * �ⷨ���� ����ָ����Ĩƽ�����ȵĲ�� �������ѭ�� ������ཻ���ߵ�һ�� û���ཻ���ߵ�null
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
        //���ﲻ����ѭ�� ��Ϊnull == null is true
        while (pointA != pointB) {
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;
        }
        return pointA;
    }
}
