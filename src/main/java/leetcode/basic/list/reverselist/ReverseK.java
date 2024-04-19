package leetcode.basic.list.reverselist;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/05 10:51
 */
public class ReverseK {


    // 1 2 3 4
    public ListNode reverseK(ListNode head, int k) {
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
