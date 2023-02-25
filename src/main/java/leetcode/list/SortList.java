package leetcode.list;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 排序链表
 * @author: xuefei
 * @date: 2023/02/25 12:41
 */
public class SortList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		sortList(node1);
	}

	public static ListNode sortList(ListNode head) {

		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
		while (head != null) {
			priorityQueue.add(head);
			head = head.next;
		}
		ListNode dummy = new ListNode();
		head = dummy;
		while (!priorityQueue.isEmpty()) {
			ListNode curNode = priorityQueue.poll();
			curNode.next = null;
			head.next = curNode;
			head = head.next;
		}
		return dummy.next;
	}

}
