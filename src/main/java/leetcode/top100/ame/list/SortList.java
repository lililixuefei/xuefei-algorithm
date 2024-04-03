package leetcode.top100.ame.list;

import labuladong.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/1 22:12
 * @Version 1.0
 */
public class SortList {

	public ListNode sortList(ListNode head) {
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
		while (head != null) {
			priorityQueue.add(head);
			head = head.next;
		}
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		while (!priorityQueue.isEmpty()) {
			temp.next = priorityQueue.poll();
			temp.next.next = null;
			temp = temp.next;
		}
		return dummy.next;
	}

}
