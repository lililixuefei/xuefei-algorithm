package leetcode.onequestion.resolved;

import labuladong.list.ListNode;

/**
 * @description: 环形链表
 * @author: xuefei
 * @date: 2023/07/29 23:04
 */
public class HasCycle {


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

}
