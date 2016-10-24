package List; /**
 * Created by Baiye on 2016/9/26.
 */

/**
 * LeetCode.83.Remove Duplicates from Sorted List
 * 有序链表去重
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode h = new ListNode(0);
        h.next = head;

        for(ListNode tempNode = h;tempNode.next != null; tempNode = tempNode.next)
        {
            while(tempNode.next.next != null && tempNode.next.val == tempNode.next.next.val)
            {
                tempNode.next = tempNode.next.next;
            }
        }

        return h.next;
    }

      private class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
