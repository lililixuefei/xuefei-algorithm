package leetcode.top100.ame.list;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 23:15
 * @Version 1.0
 */
public class HasCycle {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast != null && slow == fast) {
				return true;
			}
		}
		return false;
	}

}
