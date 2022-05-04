package wushixiong.linkedlist;

/**
 * @description: 反转链表   https://leetcode-cn.com/problems/reverse-linked-list/
 * @author: xuefei
 * @date: 2022/05/04 23:09
 */
public class ReverseList {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
