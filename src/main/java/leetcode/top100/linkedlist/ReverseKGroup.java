package leetcode.top100.linkedlist;

import labuladong.list.ListNode;

/**
 * @Description K 个一组翻转链表
 * @Author xuefei
 * @Date 2023/11/2 23:17
 * @Version 1.0
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 0) {
            return head;
        }
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

        for (; n >= k; n -= k) {
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }
        return dummy.next;
    }

}
