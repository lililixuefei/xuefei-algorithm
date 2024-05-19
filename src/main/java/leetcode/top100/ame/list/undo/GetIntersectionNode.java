package leetcode.top100.ame.list.undo;

import labuladong.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 21:16
 * @Version 1.0
 */
public class GetIntersectionNode {


	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode p2 = headB;
		while (p1 != p2) {
			if (p1 == null) {
				p1 = headB;
			} else {
				p1 = p1.next;
			}
			if (p2 == null) {
				p2 = headA;
			} else {
				p2 = p2.next;
			}
		}
		return p1;
	}

	public static void main(String[] args) {
		Integer a = 128;
		int b = 128;
		System.out.println(a==b);
		List<Integer> list = new ArrayList<>();
		list.add(1);
	}


}
