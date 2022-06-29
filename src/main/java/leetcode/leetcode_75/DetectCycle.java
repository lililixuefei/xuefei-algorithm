package leetcode.leetcode_75;

import leetcode.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表 II   https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author: xuefei
 * @date: 2022/06/29 23:13
 */
public class DetectCycle {

    public ListNode detectCycle1(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
