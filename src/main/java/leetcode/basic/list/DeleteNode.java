package leetcode.basic.list;


import java.util.Stack;

/**
 * @description: 删除链表的节点
 * @author: xuefei
 * @date: 2023/02/23 22:46
 */
public class DeleteNode {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        deleteNode2(node1, 2);
    }

    public static ListNode deleteNode2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode cur = head;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return cur;
    }


    public static ListNode deleteNode(ListNode head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }

        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static ListNode removeValue1(ListNode head, int num) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            if (head.val != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }


    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
