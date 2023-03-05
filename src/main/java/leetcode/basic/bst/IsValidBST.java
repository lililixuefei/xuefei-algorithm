package leetcode.basic.bst;

/**
 * @description: 验证二叉搜索树
 * @author: xuefei
 * @date: 2023/02/20 23:18
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);

    }
}
