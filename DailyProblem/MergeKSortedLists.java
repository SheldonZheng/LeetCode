/**
 * LeetCode 23 Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] listNodes,int left,int right) {
        if (left >= right) {
            return listNodes[left];
        }
        int mid = (left + right) / 2;
        ListNode l = merge(listNodes,left,mid);
        ListNode r = merge(listNodes,mid + 1,right);
        return mergeTwoList(l,r);
    }

    public ListNode mergeTwoList(ListNode l ,ListNode r) {
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        if (l.val < r.val) {
            l.next = mergeTwoList(l.next,r);
            return l;
        } else {
            r.next = mergeTwoList(l,r.next);
            return r;
        }
    }
}
