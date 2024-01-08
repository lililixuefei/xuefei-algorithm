package leetcode.basic.list;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/10/31 17:05
 */
public class RemoveMidNode {


    public static ListNode removeMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

}
