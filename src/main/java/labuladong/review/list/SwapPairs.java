package labuladong.review.list;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/09 10:55
 */
public class SwapPairs {


    public ListNode swapPairs_me_w(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = p0.next;

        while (cur != null && cur.next != null){
            ListNode next1 = cur.next;
            ListNode next2 = cur.next.next;

            cur.next = pre;
            next1.next = cur;
            pre = next1;
            cur = next2;
        }
        return null;
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


}
