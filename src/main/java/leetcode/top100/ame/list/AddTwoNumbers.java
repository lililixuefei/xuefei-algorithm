package leetcode.top100.ame.list;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 23:59
 * @Version 1.0
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		int[] nums1 = {9, 9, 9, 9, 9, 9, 9};
		int[] nums2 = {9, 9, 9, 9};

		ListNode listNode1 = arrayToLinkedList(nums1);
		ListNode listNode2 = arrayToLinkedList(nums2);
		addTwoNumbers(listNode1, listNode2);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int l1Val = 0;
			if (l1 != null) {
				l1Val = l1.val;
				l1 = l1.next;
			}
			int l2Val = 0;
			if (l2 != null) {
				l2Val = l2.val;
				l2 = l2.next;
			}
			int sum = (l1Val + l2Val + carry) % 10;
			carry = (l1Val + l2Val + carry) / 10;
			temp.next = new ListNode(sum);
			temp = temp.next;
		}
		if (carry == 1) {
			temp.next = new ListNode(carry);
		}
		return dummy.next;
	}


	public static ListNode arrayToLinkedList(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		for (int num : nums) {
			current.next = new ListNode(num);
			current = current.next;
		}

		return dummy.next;
	}

}
