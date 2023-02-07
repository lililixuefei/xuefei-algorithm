package xuefei.done.me.binary_tree;

import xuefei.done.leetcode.tree.TreeNode;

/**
 * @description: 路径总和   https://leetcode.cn/problems/path-sum/%C2%A0%C2%A0/
 * @author: xuefei
 * @date: 2022/08/23 23:57
 */
public class HasPathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}