package leetcode.basic.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 合并 K 个升序链表
 * @author: xuefei
 * @date: 2023/03/26 20:45
 */
public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
		for (ListNode list : lists) {
			if (list != null) {
				priorityQueue.add(list);
			}
		}
		ListNode head = new ListNode();
		ListNode dummy = head;
		while (!priorityQueue.isEmpty()) {
			ListNode node = priorityQueue.poll();
			dummy.next = node;
			if (node.next != null) {
				priorityQueue.add(node.next);
			}
			dummy = dummy.next;
		}
		return head.next;
	}

}
