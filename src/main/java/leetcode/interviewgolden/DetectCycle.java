package leetcode.interviewgolden;

import xuefei.labuladong.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环路检测
 * @author: xuefei
 * @date: 2023/03/06 23:29
 */
public class DetectCycle {

	public ListNode detectCycle_good(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				return null;
			}
			if (fast == slow) {
				ListNode ptr = head;
				while (ptr != slow) {
					ptr = ptr.next;
					slow = slow.next;
				}
				return ptr;
			}
		}
		return null;
	}


	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode dummy = head;
		while (head != null) {
			if (set.contains(head)) {
				return head;
			}
			set.add(head);
			head = head.next;
		}
		return null;
	}

}
