package leetcode.basic.binarytree;

/**
 * @description: 判断根结点是否等于子结点之和
 * @author: xuefei
 * @date: 2023/04/12 23:24
 */
public class CheckTree {

	public boolean checkTree(TreeNode root) {
		return root.val == root.left.val + root.right.val;
	}

}
