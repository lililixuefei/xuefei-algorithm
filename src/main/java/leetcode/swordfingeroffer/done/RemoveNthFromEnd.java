package leetcode.swordfingeroffer.done;

import xuefei.labuladong.list.ListNode;


/**
 * @description: 删除链表的倒数第 n 个结点
 * @author: xuefei
 * @date: 2023/03/08 23:36
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = head;
		int length = 0;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		if (length < n) {
			return head;
		}
		if (length == n) {
			return head.next;
		}

		temp = head;
		int k = length - n - 1;
		while (k != 0) {
			temp = temp.next;
			k--;
		}
		ListNode pre  = temp;
		ListNode deleted = temp.next;
		if (deleted != null){
			pre.next = deleted.next;
		}
		return head;
	}

}
