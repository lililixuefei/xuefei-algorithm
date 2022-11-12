package study.zuoshen.binary_tree;

/**
 * @description: 二叉树的最大深度   https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @author: xuefei
 * @date: 2022/08/21 23:23
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.right),maxDepth(root.left)) + 1;
    }
}
