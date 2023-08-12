package xuefei.done.interviewgolden;

import xuefei.labuladong.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分割链表
 * @author: xuefei
 * @date: 2023/03/06 22:57
 */
public class Partition {

	public ListNode partition_3(ListNode head, int x) {
		ListNode small = new ListNode(0);
		ListNode large = new ListNode(0);
		ListNode smallHead = small;
		ListNode largeHead = large;
		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				large.next = head;
				large = large.next;
			}
			head = head.next;
		}
		large.next = null;
		small.next = largeHead.next;
		return smallHead.next;
	}


	public ListNode partition_2(ListNode head, int x) {
		ListNode lessXList = new ListNode(-1);
		ListNode mareXList = new ListNode(-1);

		ListNode lessXHead = lessXList;
		ListNode moreXHead = mareXList;

		while (head != null) {
			if (head.val < x) {
				lessXHead.next = new ListNode(head.val);
				lessXHead = lessXHead.next;
			} else {
				moreXHead.next = new ListNode(head.val);
				moreXHead = moreXHead.next;
			}
			head = head.next;
		}
		lessXHead.next = moreXHead.next;
		return lessXList.next;
	}


	public ListNode partition_1(ListNode head, int x) {
		List<ListNode> lessXList = new ArrayList<>();
		List<ListNode> moreXList = new ArrayList<>();
		while (head != null) {
			if (head.val < x) {
				lessXList.add(head);
			} else {
				moreXList.add(head);
			}
			head = head.next;
		}
		ListNode dummy = new ListNode(-1);
		head = dummy;
		for (ListNode listNode : lessXList) {
			head.next = listNode;
			listNode.next = null;
			head = head.next;
		}
		for (ListNode listNode : moreXList) {
			head.next = listNode;
			listNode.next = null;
			head = head.next;
		}
		return dummy.next;
	}

}
