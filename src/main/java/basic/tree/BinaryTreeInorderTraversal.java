package basic.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树的中序遍历   https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * @author: xuefei
 * @date: 2022/07/02 21:57
 */
public class BinaryTreeInorderTraversal {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        traversal1(root, traversals);
        return traversals;
    }

    public void traversal1(TreeNode root, List<Integer> traversals) {
        if (root == null) {
            return;
        }
        traversal1(root.left, traversals);
        traversals.add(root.val);
        traversal1(root.right, traversals);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        if (root == null){
            return traversals;
        }
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                traversals.add(root.val);
                root = root.right;
            }
        }
        return traversals;
    }


}
