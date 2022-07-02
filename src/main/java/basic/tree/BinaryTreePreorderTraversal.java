package basic.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树的前序遍历   https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @author: xuefei
 * @date: 2022/07/02 21:42
 */
public class BinaryTreePreorderTraversal {


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        traversal1(root, traversals);
        return traversals;
    }

    public void traversal1(TreeNode root, List<Integer> traversals) {
        if (root == null) {
            return;
        }
        traversals.add(root.val);
        traversal1(root.left, traversals);
        traversal1(root.right, traversals);
    }


    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        if (root == null) {
            return traversals;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            traversals.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return traversals;
    }
}
