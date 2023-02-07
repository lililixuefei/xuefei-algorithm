package xuefei.done.me.binary_tree;

import xuefei.done.leetcode.tree.TreeNode;

/**
 * @description: 合并二叉树
 * @author: xuefei
 * @date: 2022/09/03 22:23
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        return process(root1, root2);
    }

    private TreeNode process(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int val;
        if (root1 == null) {
            val = root2.val;
        } else if (root2 == null) {
            val = root1.val;
        } else {
            val = root1.val + root2.val;
        }

        TreeNode left;
        if (root1 == null) {
            left = process(null, root2.left);
        } else if (root2 == null) {
            left = process(root1.left, null);
        } else {
            left = process(root1.left, root2.left);
        }

        TreeNode right;
        if (root1 == null) {
            right = process(null, root2.right);
        } else if (root2 == null) {
            right = process(root1.right, null);
        } else {
            right = process(root1.right, root2.right);
        }

        return new TreeNode(val, left, right);
    }
}
