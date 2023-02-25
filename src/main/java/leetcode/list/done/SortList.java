package leetcode.list.done;


import leetcode.list.ListNode;

import java.util.*;

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

		sortListUserList(node1);
	}

	/**
	 * 使用集合排序
	 *
	 * @param head
	 * @return
	 */
	public static ListNode sortListUserList(ListNode head) {
		List<ListNode> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		for (ListNode listNode : list) {
			listNode.next = null;
		}
		list.sort(Comparator.comparingInt(e -> e.val));
		ListNode dummy = new ListNode();
		head = dummy;
		for (ListNode listNode : list) {
			head.next = listNode;
			head = head.next;
		}
		return dummy.next;
	}


	/**
	 * 使用优先级队列
	 *
	 * @param head
	 * @return
	 */
	public static ListNode sortListUserPriorityQueue(ListNode head) {
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
