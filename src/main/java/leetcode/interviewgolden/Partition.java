package leetcode.interviewgolden;

import labuladong.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分割链表
 * @author: xuefei
 * @date: 2023/03/06 22:57
 */
public class Partition {

	public ListNode partition(ListNode head, int x) {
		List<ListNode> lessXList = new ArrayList<>();
		List<ListNode> moreXList = new ArrayList<>();
		while (head != null){
			if (head.val < x) {
				lessXList.add(head);
			}else {
				moreXList.add(head);
			}
			head = head.next;
		}
		ListNode dummy = new ListNode(-1);
		head = dummy;
		for (ListNode listNode : lessXList) {
			head.next = listNode;
			listNode.next = null;
			head = head.next;
		}
		for (ListNode listNode : moreXList) {
			head.next = listNode;
			listNode.next = null;
			head = head.next;
		}
		return dummy.next;
	}

}
