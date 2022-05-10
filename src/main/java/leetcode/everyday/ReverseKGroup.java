package leetcode.everyday;

import linkedlist.node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: K 个一组翻转链表  https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @author: xuefei
 * @date: 2022/05/10 21:53
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode headNode1 = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));

        reverseKGroup2(headNode1, 2);
    }

    /**
     * K 个一组翻转链表 --> 转换为 将K个链表翻转 连接在一起
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }

        int size = listNodes.size();

        List<ListNode> newListNodes = new ArrayList<>();

        int m;
        for (int i = 0; i < size; i = i + k) {
            m = i + k - 1;
            ListNode listNode = listNodes.get(i);
            if (m < size) {
                listNodes.get(m).next = null;
                ListNode newListNode = reverseLinkedList(listNode);
                newListNodes.add(newListNode);
            } else {
                newListNodes.add(listNode);
            }
        }

        ListNode newListNode = new ListNode(-1);
        ListNode dummy = newListNode;

        for (int i = 0; i < newListNodes.size(); i++) {
            ListNode listNode = newListNodes.get(i);
            newListNode.next = listNode;

            while (newListNode.next != null) {
                newListNode = newListNode.next;
            }
        }
        return dummy.next;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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

    /**
     * 构建链表
     *
     * @param list
     * @return
     */
    public static ListNode createLinkedList(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode headNode = new ListNode(list.get(0));
        ListNode tempNode = createLinkedList(list.subList(1, list.size()));
        headNode.next = tempNode;
        return headNode;
    }


}
