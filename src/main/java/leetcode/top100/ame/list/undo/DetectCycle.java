package leetcode.top100.ame.list.undo;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 23:26
 * @Version 1.0
 */
public class DetectCycle {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast != null && slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

}
