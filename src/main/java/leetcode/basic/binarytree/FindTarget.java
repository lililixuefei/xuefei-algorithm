package leetcode.basic.binarytree;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 二叉搜索树中两个节点之和
 * @author: xuefei
 * @date: 2023/04/13 23:57
 */
public class FindTarget {

	Set<Integer> set = new HashSet<>();

	public boolean findTarget(TreeNode root, int k) {
		if (root == null) {
			return false;
		}
		if (set.contains(k - root.val)) {
			return true;
		}
		set.add(root.val);
		return findTarget(root.left, k) || findTarget(root.right, k);
	}

}
