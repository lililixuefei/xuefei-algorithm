package leetcode.linkedlist;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/06/08 23:33
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
