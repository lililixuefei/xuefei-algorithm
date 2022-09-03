package me.binary_tree;

import leetcode.tree.TreeNode;

/**
 * @description: 对称二叉树
 * @author: xuefei
 * @date: 2022/09/03 21:31
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null ^ right == null) {
            return false;
        }
        if (left == null) {
            return true;
        }

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
