package xuefei.done.leetcode.leetcode_75;

import xuefei.done.leetcode.linkedlist.ListNode;

/**
 * @description: 反转链表   https://leetcode.cn/problems/reverse-linked-list/
 * @author: xuefei
 * @date: 2022/06/28 22:51
 */
public class ReverseList {

    /**
     * 递归翻转
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代翻转
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
