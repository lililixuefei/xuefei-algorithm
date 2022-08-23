package me.binary_tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 路径总和 II   https://leetcode.cn/problems/path-sum-ii/%C2%A0%20%C2%A0/
 * @author: xuefei
 * @date: 2022/08/24 00:05
 */
public class PathSum {


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> path = new LinkedList<>();
        process(root, targetSum, path, ans);
        return ans;

    }

    private void process(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            boolean result = sum == root.val;
            if (result) {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }
        path.add(root.val);
        if (root.left != null) {
            process(root.left, sum - root.val, path, ans);
        }
        if (root.right != null) {
            process(root.right, sum - root.val, path, ans);
        }
        path.remove(path.size() - 1);
    }

}
