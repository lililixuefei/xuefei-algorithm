package study.wushixiong.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的前序遍历(先序遍历)  https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @author: xuefei
 * @date: 2022/05/11 23:29
 */
public class PreorderTraversal {
    public static void main(String[] args) {

    }


    /**
     * 二叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> nodes = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            nodes.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return nodes;
    }

    /**
     * 二叉树的前序遍历
     * @param root
     * @return
     */
    public static List<Integer> preOrderIteration(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> nodes = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            nodes.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return nodes;
    }

}
