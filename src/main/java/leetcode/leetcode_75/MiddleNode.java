package leetcode.leetcode_75;

import leetcode.linkedlist.ListNode;

/**
 * @description: 链表的中间结点   https://leetcode.cn/problems/middle-of-the-linked-list/
 * @author: xuefei
 * @date: 2022/06/29 23:07
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
