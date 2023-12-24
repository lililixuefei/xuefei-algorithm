package leetcode.top100.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description 翻转二叉树
 * @Author xuefei
 * @Date 2023/11/5 17:46
 * @Version 1.0
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        process(root);
        return root;
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        process(root.left);
        process(root.right);
    }

}
