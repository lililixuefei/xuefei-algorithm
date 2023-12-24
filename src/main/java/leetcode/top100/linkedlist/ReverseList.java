package leetcode.top100.linkedlist;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/2 22:42
 * @Version 1.0
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
