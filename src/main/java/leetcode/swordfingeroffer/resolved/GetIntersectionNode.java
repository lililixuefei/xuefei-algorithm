package leetcode.swordfingeroffer.resolved;

import labuladong.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 剑指 Offer 52. 两个链表的第一个公共节点
 * @author: xuefei
 * @date: 2023/07/16 19:28
 */
public class GetIntersectionNode {

	public class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			// p1 指向 A 链表头结点，p2 指向 B 链表头结点
			ListNode p1 = headA;
			ListNode p2 = headB;
			while (p1 != p2) {
				// p1 走一步，如果走到 A 链表末尾，转到 B 链表
				if (p1 == null) {
					p1 = headB;
				} else {
					p1 = p1.next;
				}
				// p2 走一步，如果走到 B 链表末尾，转到 A 链表
				if (p2 == null) {
					p2 = headA;
				} else {
					p2 = p2.next;
				}
			}
			return p1;
		}
	}


	ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}

}
