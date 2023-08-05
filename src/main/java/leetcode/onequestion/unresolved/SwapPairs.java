package leetcode.onequestion.unresolved;

import labuladong.list.ListNode;

/**
 * @description: 两两交换链表中的节点
 * @author: xuefei
 * @date: 2023/08/06 00:01
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
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
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (head != null && head.next != null) {

            ListNode next = head.next;
            ListNode nnext = next.next;
            next.next = head;
            head.next = nnext;
            head = nnext;

        }
        return dummy;
    }

}
