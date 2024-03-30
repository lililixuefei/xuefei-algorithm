package leetcode.top100.ame.list;

import labuladong.list.ListNode;

import java.util.Stack;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 22:36
 * @Version 1.0
 */
public class IsPalindrome {

	public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		while (head != null) {
			if (head.val != stack.pop().val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

}
