package leetcode.interviewgolden.unresolved;

import labuladong.binarytree.TreeNode;

/**
 * @Description 求和路径
 * @Author xuefei
 * @Date 2023/8/24 22:56
 * @Version 1.0
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, sum);
        ret += pathSum(root.left, sum);
        ret += pathSum(root.right, sum);
        return ret;
    }

    public int rootSum(TreeNode root, int sum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == sum) {
            ret++;
        }

        ret += rootSum(root.left, sum - val);
        ret += rootSum(root.right, sum - val);
        return ret;
    }

}
