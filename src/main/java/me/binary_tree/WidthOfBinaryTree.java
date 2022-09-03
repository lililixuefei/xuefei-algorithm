package me.binary_tree;

import a.zuoshen.binary_tree.TreeNode;

import java.util.*;

/**
 * @description: 二叉树最大宽度
 * @author: xuefei
 * @date: 2022/09/03 19:45
 */
public class WidthOfBinaryTree {

    Map<Integer, Integer> levelMin = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        levelMin.putIfAbsent(depth, index);
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }
}
