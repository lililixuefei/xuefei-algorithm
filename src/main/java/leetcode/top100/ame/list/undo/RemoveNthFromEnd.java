package leetcode.top100.ame.list.undo;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/2 22:51
 * @Version 1.0
 */
public class RemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		int length = getLength(head);
		ListNode cur = dummy;
		for (int i = 1; i < length - n + 1; ++i) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return dummy.next;
	}

	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			++length;
			head = head.next;
		}
		return length;
	}

	// 主函数
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		// 虚拟头结点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		// 删除倒数第 n 个，要先找倒数第 n + 1 个节点
		ListNode x = findFromEnd(dummy, n + 1);
		// 删掉倒数第 n 个节点
		x.next = x.next.next;
		return dummy.next;
	}

	// 返回链表的倒数第 k 个节点
	ListNode findFromEnd(ListNode head, int k) {
		ListNode p1 = head;
		// p1 先走 k 步
		for (int i = 0; i < k; i++) {
			p1 = p1.next;
		}
		ListNode p2 = head;
		// p1 和 p2 同时走 n - k 步
		while (p1 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		// p2 现在指向第 n - k 个节点
		return p2;
	}


}
