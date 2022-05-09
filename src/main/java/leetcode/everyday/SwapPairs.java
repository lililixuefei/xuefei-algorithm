package leetcode.everyday;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 两两交换链表中的节点   https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @author: xuefei
 * @date: 2022/05/09 22:52
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode headNode1 = createLinkedList(Arrays.asList(2, 5, 3, 4, 6, 2, 2));
        swapPairs(headNode1);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null) {
            listNodeList.add(head);
            head = head.next;
        }
        int size = listNodeList.size();

        ListNode lastNode = null;
        int m = size % 2;
        if (m == 1) {
            lastNode = listNodeList.remove(--size);
        }
        for (int j = 0; j < size; j = j + 2) {
            ListNode cur = listNodeList.get(j);
            int k = j + 1;
            ListNode next = listNodeList.get(k);
            cur.next = null;
            next.next = null;

            dummy.next = next;
            next.next = cur;
            dummy = dummy.next.next;
        }
        if (m == 1) {
            dummy.next = lastNode;
        }
        return temp.next;
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

    public static class ListNode {
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
