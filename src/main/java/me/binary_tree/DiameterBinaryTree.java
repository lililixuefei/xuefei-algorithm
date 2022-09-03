package me.binary_tree;

import leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 二叉树的直径
 * @author: xuefei
 * @date: 2022/09/03 21:43
 */
public class DiameterBinaryTree {


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 0;
        }
        int curMax = maxDepth(root.left) + maxDepth(root.right);
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        return Math.max(curMax, Math.max(leftMax, rightMax));
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer depth = map.get(root);
        if (depth == null) {
            depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            map.put(root, depth);
        }
        return depth;
    }
}
