package leetcode.swordfinger_offer;

import leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * @author: xuefei
 * @date: 2022/11/13 12:02
 */
public class ReversePrint {

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(5, null);
        ListNode listNode3 = new ListNode(1, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(3, listNode2);
    }


    /**
     * 使用栈进行遍历
     *
     * @param head
     * @return
     */
    public int[] reversePrint_iteration(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public int[] reversePrint_recursion(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> ansList = new ArrayList<>();
        process(head,ansList);
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void process(ListNode head, List<Integer> ansList) {
        if (head.next == null) {
            ansList.add(head.val);
            return;
        }
        process(head.next, ansList);
        ansList.add(head.val);
    }
}
