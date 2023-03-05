package leetcode.basic.list.done;

import leetcode.basic.list.ListNode;

/**
 * @description: 删除链表的节点
 * @author: xuefei
 * @date: 2023/02/23 22:46
 */
public class DeleteNode {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        deleteNode(node1, 5);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        while (head.val == val) {
            head = head.next;
        }

        ListNode cur = head;
        while (head!= null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return cur;
    }

}
