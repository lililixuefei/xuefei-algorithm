package leetcode.linkedlist;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/06/08 23:33
 */
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
