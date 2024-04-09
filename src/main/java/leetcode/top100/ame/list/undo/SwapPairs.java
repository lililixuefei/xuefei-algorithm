package leetcode.top100.ame.list.undo;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/9 22:54
 * @Version 1.0
 */
public class SwapPairs {


	// 1 2 3 4 5 6
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(head);
		ListNode node0 = dummy;
		ListNode node1 = dummy.next;
		while (node1 != null && node1.next != null) {
			ListNode node2 = node1.next;
			ListNode node3 = node1.next.next;

			node2.next = node1;
			node1.next = node3;
			node0.next = node2;

			node0 = node1;
			node1 = node3;
		}
		return dummy.next;
	}

}
