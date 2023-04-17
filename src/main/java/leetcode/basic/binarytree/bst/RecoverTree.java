package leetcode.basic.binarytree.bst;


import java.util.ArrayList;
import java.util.List;


/**
 * @description: 恢复二叉搜索树
 * @author: xuefei
 * @date: 2023/04/17 23:32
 */
public class RecoverTree {

	public void recoverTree(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		dfs(root, list);
		TreeNode x = null;
		TreeNode y = null;
		//扫面遍历的结果，找出可能存在错误交换的节点x和y
		for (int i = 0; i < list.size() - 1; ++i) {
			if (list.get(i).val > list.get(i + 1).val) {
				y = list.get(i + 1);
				if (x == null) {
					x = list.get(i);
				}
			}
		}
		//如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
		if (x != null && y != null) {
			int tmp = x.val;
			x.val = y.val;
			y.val = tmp;
		}
	}

	//中序遍历二叉树，并将遍历的结果保存到list中
	private void dfs(TreeNode node, List<TreeNode> list) {
		if (node == null) {
			return;
		}
		dfs(node.left, list);
		list.add(node);
		dfs(node.right, list);
	}
}
