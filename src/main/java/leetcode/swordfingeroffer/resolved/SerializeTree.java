package leetcode.swordfingeroffer.resolved;

import labuladong.binarytree.TreeNode;

import java.util.*;

/**
 * @description: 剑指 Offer 37. 序列化二叉树
 * @author: xuefei
 * @date: 2023/07/22 17:49
 */
public class SerializeTree {

	public static void main(String[] args) {
		SerializeTree serializeTree = new SerializeTree();

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;

		node3.left = node4;
		node3.right = node5;

		serializeTree.serialize(node1);
		serializeTree.deserialize("");
	}


	private Deque<String> preList = new LinkedList<>();


	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}
		preList = preSerialize(root);
		return String.join(",", preList);
	}

	private Deque<String> preSerialize(TreeNode root) {
		if (root == null) {
			preList.add("null");
			return preList;
		}
		preList.add(root.val + "");
		preSerialize(root.left);
		preSerialize(root.right);
		return preList;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return preDeserialize(preList);
	}

	private TreeNode preDeserialize(Deque<String> preList) {
		String curVal = preList.poll();
		if (curVal == null || curVal == "null") {
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(curVal));
		node.left = preDeserialize(preList);
		node.right = preDeserialize(preList);
		return node;
	}

}
