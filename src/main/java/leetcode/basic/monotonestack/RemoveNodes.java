package leetcode.basic.monotonestack;

import leetcode.basic.list.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 从链表中移除节点
 * @author: xuefei
 * @date: 2023/02/24 22:33
 */
public class RemoveNodes {

	public ListNode removeNodes(ListNode head) {
		Deque<ListNode> stack = new LinkedList<>();
		while (head != null) {
			while (!stack.isEmpty() && stack.peek().val < head.val) {
				stack.pop();
			}
			stack.push(head);
			head = head.next;
		}
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		while (!stack.isEmpty()) {
			temp.next = new ListNode(stack.pollLast().val);
			temp = temp.next;
		}
		return dummy.next;
	}
}
