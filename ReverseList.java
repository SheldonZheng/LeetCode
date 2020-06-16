/**
 * Reverse List ţ��
 */
public class Solution {

  public ListNode ReverseList(ListNode head) {

    ListNode next = null;
    ListNode pre = null;

    while (head != null) {
      // ����Ҫ��ת��ͷ���Ǹ��ڵ�
      next = head.next;
      // Ҫ��ת���Ǹ��ڵ�ָ���Ѿ���ת����һ���ڵ�(��ע:��һ�η�ת��ʱ���ָ��null)
      head.next = pre;
      // ��һ���Ѿ���ת��ͷ���Ľڵ�
      pre = head;
      // һֱ������β��
      head = next;
    }
    return pre;
  }

}
