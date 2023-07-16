package leetcode.swordfingeroffer;

import labuladong.list.ListNode;

/**
 * @description: 剑指 Offer 24. 反转链表
 * @author: xuefei
 * @date: 2023/07/16 18:48
 */
public class ReverseList {

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = null;
		while (head != null) {
			cur = head;
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			head = next;
		}
		return cur;
	}

}
