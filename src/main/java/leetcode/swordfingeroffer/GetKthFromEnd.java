package leetcode.swordfingeroffer;

import labuladong.list.ListNode;

/**
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 * @author: xuefei
 * @date: 2023/07/16 19:21
 */
public class GetKthFromEnd {

	public ListNode getKthFromEnd(ListNode head, int k) {

		ListNode cur = head;

		for (int i = 0; i < k; i++) {
			cur = cur.next;
		}
		while (cur != null) {
			head = head.next;
			cur = cur.next;
		}
		return head;
	}
}
