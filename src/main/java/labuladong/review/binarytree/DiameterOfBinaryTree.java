package labuladong.review.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/10 20:04
 */
public class DiameterOfBinaryTree {


    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, lDepth + rDepth);
        return Math.max(lDepth, rDepth) + 1;
    }

}
