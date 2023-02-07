package xuefei.done.interviews.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 二叉搜索树中的中序后继   https://leetcode.cn/problems/P5rCT8/
 * @author: xuefei
 * @date: 2022/07/05 00:18
 */
public class InorderSuccessor {


    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }


    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }

}
