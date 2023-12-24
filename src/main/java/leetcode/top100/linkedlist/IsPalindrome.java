package leetcode.top100.linkedlist;

import labuladong.list.ListNode;

import java.util.Stack;

/**
 * @Description 回文链表
 * @Author xuefei
 * @Date 2023/11/2 22:44
 * @Version 1.0
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;

    }

}
