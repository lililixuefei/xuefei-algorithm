package leetcode.me;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/11/23 19:21
 */
public class SwapPairs {


    public ListNode swapPairs_wrong(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode node1 = head.next;
            ListNode node2 = node1.next;
            head.next = node2;
            node1.next = head;
            head = node2;
        }
        return dummy.next;
    }


}
