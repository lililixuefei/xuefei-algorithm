package leetcode.interviewgolden.unresolved;

import labuladong.list.ListNode;

/**
 * @description: 分割链表
 * @author: xuefei
 * @date: 2023/08/13 11:33
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode lessXList = new ListNode(-1);
        ListNode mareXList = new ListNode(-1);

        ListNode lessXHead = lessXList;
        ListNode moreXHead = mareXList;

        while (head != null) {
            if (head.val < x) {
                lessXHead.next = new ListNode(head.val);
                lessXHead = lessXHead.next;
            } else {
                moreXHead.next = new ListNode(head.val);
                moreXHead = moreXHead.next;
            }
            head = head.next;
        }
        lessXHead.next = mareXList.next;
        return lessXList.next;
    }

}
