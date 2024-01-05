package leetcode.basic.list.reverselist;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/05 10:52
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
