package labuladong.review.list;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/09 20:01
 */
public class ReverseKGroup {


    public ListNode ReverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            n++;
        }
        if (n < k) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;

        ListNode pre = null;
        ListNode cur = head;
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
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
