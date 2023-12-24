package leetcode.top100.linkedlist;

import labuladong.list.ListNode;

/**
 * @Description 环形链表
 * @Author xuefei
 * @Date 2023/11/2 22:49
 * @Version 1.0
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
