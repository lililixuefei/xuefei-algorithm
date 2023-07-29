package leetcode.onequestion;

import labuladong.list.ListNode;

/**
 * @description: 环形链表 II
 * @author: xuefei
 * @date: 2023/07/30 00:07
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode a = head;
                ListNode b = fast;
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }
                return a;
            }
        }
        return null;
    }
}
