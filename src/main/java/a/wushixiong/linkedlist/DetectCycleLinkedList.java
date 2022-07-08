package a.wushixiong.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表    https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @author: xuefei
 * @date: 2022/05/04 00:17
 */
public class DetectCycleLinkedList {


    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
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


    public ListNode detectCycleWay1(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;

        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

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


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
