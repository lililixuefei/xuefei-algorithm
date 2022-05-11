package leetcode.everyday;

import linkedlist.assist.LinkedListCreator;
import linkedlist.node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 旋转链表   https://leetcode.cn/problems/rotate-list/
 * @author: xuefei
 * @date: 2022/05/10 22:59
 */
public class RotateRight {

    public static void main(String[] args) {
        ListNode headNode1 = LinkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        rotateRight(headNode1,2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        int size = listNodes.size();
        int i = k % size;
        if (i == 0) {
            return dummy;
        }

        List<ListNode> newListNodes = new ArrayList<>(size);
        for (int j = 0; j < size; j++) {
            newListNodes.add(null);
            listNodes.get(j).next = null;
        }

        for (int j = 0; j < size; j++) {
            int index = (j + k) % size;
            ListNode listNode1 = listNodes.get(j);
            newListNodes.set(index, listNode1);
        }

        ListNode listNode = new ListNode(-1);
        ListNode listNode2 = listNode;
        for (int j = 0; j < newListNodes.size(); j++) {
            ListNode listNode1 = newListNodes.get(j);
            listNode.next = listNode1;
            listNode = listNode.next;
        }
        return listNode2.next;
    }
}
