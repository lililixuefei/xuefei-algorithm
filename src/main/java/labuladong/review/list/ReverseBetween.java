package labuladong.review.list;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/10 10:41
 */
public class ReverseBetween {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        for (int i = 1; i < left; i++) {
            temp = temp.next;
        }

        ListNode pre = null;
        ListNode cur = temp.next;
        for (int i = left; i < right; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        temp.next.next = cur;
        temp.next = pre;
        return dummy.next;
    }


}
