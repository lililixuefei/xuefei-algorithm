package leetcode.top100.ame.list;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/11 22:33
 * @Version 1.0
 */
public class RemoveNthFromEnd {


	// 1 2 3 4 5
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 0;
		ListNode temp;
		for (temp = head; temp != null; temp = temp.next) {
			length++;
		}
		ListNode dummy = new ListNode(0, head);
		temp = dummy;
		for (int i = 0; i < length - n; i++) {
			temp = temp.next;
		}
		if (temp != null) {
			temp.next = temp.next.next;
		}
		return dummy.next;
	}

}
