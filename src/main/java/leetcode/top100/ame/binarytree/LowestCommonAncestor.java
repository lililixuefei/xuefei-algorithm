package leetcode.top100.ame.binarytree;

import labuladong.binarytree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/31 20:44
 * @Version 1.0
 */
public class LowestCommonAncestor {


	private final Map<TreeNode, TreeNode> parentMap = new HashMap<>();


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		buildParent(root, null);

		Set<TreeNode> parentSet = new HashSet<>();
		while (p != null) {
			parentSet.add(p);
			p = parentMap.get(p);
		}
		while (q != null) {
			if (parentSet.contains(q)) {
				return q;
			}
			q = parentMap.get(q);
		}
		return null;
	}

	private void buildParent(TreeNode root, TreeNode parent) {
		if (root == null) {
			return;
		}
		parentMap.put(root, parent);
		if (root.left != null) {
			buildParent(root.left, root);
		}
		if (root.right != null) {
			buildParent(root.right, root);
		}
	}

}
