package leetcode.basic.binarytree.bst;

import labuladong.list.ListNode;
import leetcode.basic.binarytree.TreeNode;

/**
 * @description: 有序链表转换二叉搜索树
 * @author: xuefei
 * @date: 2023/04/13 23:28
 */
public class SortedListToBST {

	public leetcode.basic.binarytree.TreeNode sortedListToBST(ListNode head) {
		return buildTree(head, null);
	}

	public leetcode.basic.binarytree.TreeNode buildTree(ListNode left, ListNode right) {
		if (left == right) {
			return null;
		}
		ListNode mid = getMedian(left, right);
		leetcode.basic.binarytree.TreeNode root = new TreeNode(mid.val);
		root.left = buildTree(left, mid);
		root.right = buildTree(mid.next, right);
		return root;
	}

	public ListNode getMedian(ListNode left, ListNode right) {
		ListNode fast = left;
		ListNode slow = left;
		while (fast != right && fast.next != right) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}


}
