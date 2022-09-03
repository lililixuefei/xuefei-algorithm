package me.binary_tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 二叉树的所有路径
 * @author: xuefei
 * @date: 2022/09/03 22:46
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Set<String> ans = new HashSet<>();

        process(null, root, ans, "");

        return new ArrayList<>(ans);

    }


    private void process(TreeNode pRoot, TreeNode root, Set<String> ans, String path) {

        if (pRoot != null && pRoot.left == null && pRoot.right == null) {
            ans.add(path);
            return;
        }
        if (root == null) {
            return;
        }
        if ("".equals(path)) {
            path = root.val + "";
        } else {
            path = path + "->" + root.val;
        }

        process(root, root.left, ans, path);
        process(root, root.right, ans, path);
    }


}
