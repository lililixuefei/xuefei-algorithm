package labuladong.review.binarytree;

import leetcode.basic.binarytree.bst.TreeNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/11 10:34
 */
public class MaxPathSum {


    int maxPathSum = 0;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lPathSum = Math.max(0, dfs(root.left));
        int rPathSum = Math.max(0, dfs(root.right));

        int curPathSum = lPathSum + rPathSum + root.val;
        maxPathSum = Math.max(maxPathSum, curPathSum);
        return root.val + Math.max(lPathSum, rPathSum);
    }


}
