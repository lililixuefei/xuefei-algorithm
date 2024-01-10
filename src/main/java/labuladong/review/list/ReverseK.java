package labuladong.review.list;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/09 19:49
 */
public class ReverseK {


    public ListNode reverseK(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            count++;
            temp = temp.next;
        }
        if (count < k) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }


}
