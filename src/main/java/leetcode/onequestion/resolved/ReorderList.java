package leetcode.onequestion.resolved;

import labuladong.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 143. 重排链表
 * @author: xuefei
 * @date: 2023/07/31 21:28
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }


    public void reorderList_me(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = head;
        while (dummy != null) {
            stack.push(dummy);
            dummy = dummy.next;
        }

        ListNode dummyHead = head;
        while (!stack.isEmpty()) {
            ListNode cur = stack.pop();
            ListNode next = dummyHead.next;
            if (dummyHead.equals(cur) || cur.equals(next)) {
                break;
            }
            if (stack.peek() != null) {
                stack.peek().next = null;
            }
            dummyHead.next = cur;
            cur.next = next;
            dummyHead = next;
        }
    }

}
