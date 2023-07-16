package leetcode.swordfingeroffer.resolved;

import labuladong.list.ListNode;

/**
 * @description: 剑指 Offer 25. 合并两个排序的链表
 * @author: xuefei
 * @date: 2023/07/16 19:23
 */
public class MergeTwoLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				temp.next = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if (l1 != null) {
			temp.next = l1;
		}
		if (l2 != null) {
			temp.next = l2;
		}
		return dummy.next;

	}

}
