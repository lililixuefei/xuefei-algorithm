package leetcode.basic.monotonestack;

import xuefei.labuladong.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 链表中的下一个更大节点
 * @author: xuefei
 * @date: 2023/03/23 22:29
 */
public class NextLargerNodes {

	public int[] nextLargerNodes(ListNode head) {
		Stack<Integer> reverseStack = new Stack<>();
		while (head != null) {
			reverseStack.add(head.val);
			head = head.next;
		}
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		while (!reverseStack.isEmpty()) {
			while (!stack.isEmpty() && stack.peek() <= reverseStack.peek()) {
				stack.pop();
			}
			list.add(stack.isEmpty() ? 0 : stack.peek());
			stack.push(reverseStack.peek());
			reverseStack.pop();
		}
		int[] ans = new int[list.size()];
		int j = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			ans[j++] = list.get(i);
		}
		return ans;
	}

}
