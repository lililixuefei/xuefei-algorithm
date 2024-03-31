package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 14:13
 * @Version 1.0
 */
public class InorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		process(root, ans);
		return ans;
	}

	public void process(TreeNode node, List<Integer> ans) {
		if (node == null) {
			return;
		}
		process(node.left, ans);
		ans.add(node.val);
		process(node.right, ans);
	}

}
