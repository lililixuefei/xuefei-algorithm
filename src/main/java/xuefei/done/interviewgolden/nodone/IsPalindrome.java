package xuefei.done.interviewgolden.nodone;

import xuefei.labuladong.list.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 回文链表
 * @author: xuefei
 * @date: 2023/03/06 23:13
 */
public class IsPalindrome {

	public boolean isPalindrome(ListNode head) {
		Deque<Integer> deque = new LinkedList<>();

		ListNode dummy = head;
		while (head != null) {
			deque.push(head.val);
			head = head.next;
		}

		while (dummy != null) {
			if (dummy.val != deque.pop()) {
				return false;
			}
			dummy = dummy.next;
		}
		return true;
	}

}
