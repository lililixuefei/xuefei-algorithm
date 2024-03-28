package leetcode.top100.linkedlist.reverselist;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/10/31 11:02
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy;
        ListNode node1 = head;
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node2; // 0 -> 2
            node2.next = node1; // 2 -> 1
            node1.next = node3; // 1 -> 3

            node0 = node1; // 下一轮交换，0 是 1
            node1 = node3; // 下一轮交换，1 是 3
        }
        return dummy.next; // 返回新链表的头节点

    }


    public ListNode swapPairs_me(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode p1 = head;
        while (p1 != null && p1.next != null) {
            ListNode p2 = p1.next;
            ListNode p3 = p2.next;

            p0.next = p2;
            p2.next = p1;
            p1.next = p3;

            p0 = p1;
            p1 = p3;
        }
        return dummy.next;
    }


}
