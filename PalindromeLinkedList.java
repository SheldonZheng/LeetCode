/**
 * LeetCode 234 Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null) return true;
    	ListNode slow = head, fast = head.next, pre = null, prepre = null;
    	while(fast != null && fast.next != null) {
    		pre = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    		pre.next = prepre;
    		prepre = pre;
    	}
    	ListNode p2 = slow.next;
    	slow.next = pre;
    	ListNode p1 = fast == null? slow.next : slow;
    	while(p1 != null) {
    		if(p1.val != p2.val)
    			return false;
    		p1 = p1.next;
    		p2 = p2.next;
    	}
		return true;
    }

}
