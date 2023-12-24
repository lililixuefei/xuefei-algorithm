package leetcode.top100.linkedlist;

import labuladong.list.ListNode;


/**
 * @Description 两两交换链表中的节点
 * @Author xuefei
 * @Date 2023/10/27 23:17
 * @Version 1.0
 */
public class SwapPairs {

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs_wrong(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode newHead = head.next;
        while (slow != null && slow.next != null) {
            ListNode next = slow.next;
            ListNode next2 = next.next;
            next.next = slow;
            slow.next = next2;
            slow = next2;
        }
        return newHead;
    }

}
