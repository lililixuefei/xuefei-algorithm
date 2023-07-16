package leetcode.swordfingeroffer.resolved;

import labuladong.list.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * @author: xuefei
 * @date: 2023/07/16 18:34
 */
public class ReversePrint {

	public int[] reversePrint2(ListNode head) {
		if (head == null) {
			return new int[0];
		}
		List<Integer> ansList = new ArrayList<>();
		process(head, ansList);
		return ansList.stream().mapToInt(Integer::intValue).toArray();
	}

	public void process(ListNode head, List<Integer> ansList) {
		if (head.next == null) {
			ansList.add(head.val);
			return;
		}
		process(head.next, ansList);
		ansList.add(head.val);
	}

	public int[] reversePrint(ListNode head) {
		if (head == null) {
			return new int[0];
		}
		Deque<Integer> stack = new LinkedList<>();
		while (head != null) {
			stack.push(head.val);
			head = head.next;
		}
		int[] ans = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty()) {
			ans[i++] = stack.pop();
		}
		return ans;
	}

}
