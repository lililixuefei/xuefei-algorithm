package leetcode.top100.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description 对称二叉树
 * @Author xuefei
 * @Date 2023/11/5 17:48
 * @Version 1.0
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if (left == null ^ right == null) {
            return false;
        }
        if (left == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return process(left.left, right.right) &&
                process(left.right, right.left);
    }

}
