package leetcode.basic.list.reverselist;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/05 10:52
 */
public class ReverseBetween {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 1; i < left; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;

        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }


    public ListNode reverseBetween_me(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 1; i < left; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = left; i <= right; i++) {
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
