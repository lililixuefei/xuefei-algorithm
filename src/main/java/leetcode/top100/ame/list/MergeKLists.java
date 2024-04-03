package leetcode.top100.ame.list;

import labuladong.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/2 23:03
 * @Version 1.0
 */
public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
		for (ListNode list : lists) {
			if (list == null) {
				continue;
			}
			priorityQueue.add(list);
		}
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		while (!priorityQueue.isEmpty()) {
			ListNode node = priorityQueue.poll();
			temp.next = node;
			temp = temp.next;
			if (node.next != null) {
				priorityQueue.add(node.next);
			}
		}
		return dummy.next;
	}

}
