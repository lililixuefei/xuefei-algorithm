package leetcode.basic.list;

import labuladong.list.ListNode;

/**
 * @description: 反转链表
 * @author: xuefei
 * @date: 2023/10/30 19:55
 */
public class ReverseList {

    public ListNode reverseK(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            n++;
        }
        if (n < k) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;

        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;

        ListNode pre = null;
        ListNode cur = head;
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }
        return dummy.next;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 1; i < left; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;

        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }


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
