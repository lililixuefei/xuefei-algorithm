package leetcode.tree;

import java.util.*;

/**
 * @description: 二叉树的前序遍历   https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @author: xuefei
 * @date: 2022/06/09 13:32
 */
public class PreOrderTraversal {

    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}
