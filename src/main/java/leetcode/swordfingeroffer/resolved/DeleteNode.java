package leetcode.swordfingeroffer.resolved;

import labuladong.list.ListNode;

/**
 * @description: 剑指 Offer 18. 删除链表的节点
 * @author: xuefei
 * @date: 2023/07/16 19:14
 */
public class DeleteNode {

	public ListNode deleteNode(ListNode head, int val) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode temp = dummy;
		while (true) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
		}
		return dummy.next;
	}

}
