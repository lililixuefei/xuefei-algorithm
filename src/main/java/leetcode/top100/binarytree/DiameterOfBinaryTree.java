package leetcode.top100.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @Description 二叉树的直径
 * @Author xuefei
 * @Date 2023/11/5 17:52
 * @Version 1.0
 */
public class DiameterOfBinaryTree {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序遍历位置顺便计算最大直径
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }













}
