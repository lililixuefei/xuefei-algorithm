package leetcode.interviewgolden.unresolved;

import labuladong.list.ListNode;

/**
 * @description: 环路检测
 * @author: xuefei
 * @date: 2023/08/13 14:52
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode b = fast;
                ListNode a = head;
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
