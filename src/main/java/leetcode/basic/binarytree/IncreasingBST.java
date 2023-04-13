package leetcode.basic.binarytree;

/**
 * @description: 递增顺序搜索树
 * @author: xuefei
 * @date: 2023/04/13 23:46
 */
public class IncreasingBST {

	TreeNode dummy = new TreeNode(-1);
	TreeNode temp = dummy;

	public TreeNode increasingBST(TreeNode root) {
		if (root == null){
			return null;
		}
		increasingBST(root.left);

		TreeNode node = new TreeNode(root.val);
		temp.right = node;
		temp = node;

		increasingBST(root.right);
		return dummy.right;
	}

}
