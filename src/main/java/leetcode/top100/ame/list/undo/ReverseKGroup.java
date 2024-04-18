package leetcode.top100.ame.list.undo;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/10 23:16
 * @Version 1.0
 */
public class ReverseKGroup {

	// 1 2 3  4 5 6
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		int n = 0;
		for (ListNode temp = head; temp != null; temp = temp.next) {
			n++;
		}

		ListNode dummy = new ListNode(0, head);
		ListNode p0 = dummy;
		ListNode pre = null;
		ListNode cur = head;
		for (; n >= k; n -= k) {
			for (int i = 0; i < k; i++) {
				ListNode next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}

			ListNode next = p0.next;
			p0.next.next = cur;
			p0.next = pre;
			p0 = next;
		}
		return dummy.next;
	}

}
