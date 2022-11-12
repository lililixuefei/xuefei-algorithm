package study.zuoshen.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 一棵树是否是完全二叉树
 * @author: xuefei
 * @date: 2022/08/01 23:05
 */
public class CompleteBinaryTree {


    public boolean isCompleteBinaryTree(TreeNode node) {
        if (node == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if ((leaf && (left != null || right != null)) ||
                    (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
