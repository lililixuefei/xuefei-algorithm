package leetcode.interviewgolden.unresolved;

import labuladong.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 求和路径
 * @Author xuefei
 * @Date 2023/8/24 22:56
 * @Version 1.0
 */
public class PathSum {


    public int pathSum2(TreeNode root, int sum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, sum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int sum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - sum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, sum);
        ret += dfs(root.right, prefix, curr, sum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }


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
