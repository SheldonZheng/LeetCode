/**
 * Reverse List 牛逼
 */
public class Solution {

  public ListNode ReverseList(ListNode head) {

    ListNode next = null;
    ListNode pre = null;

    while (head != null) {
      // 保存要反转到头的那个节点
      next = head.next;
      // 要反转的那个节点指向已经反转的上一个节点(备注:第一次反转的时候会指向null)
      head.next = pre;
      // 上一个已经反转到头部的节点
      pre = head;
      // 一直向链表尾走
      head = next;
    }
    return pre;
  }

}
