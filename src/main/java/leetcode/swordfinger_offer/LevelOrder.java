package leetcode.swordfinger_offer;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * @author: xuefei
 * @date: 2022/11/13 21:48
 */
public class LevelOrder {


    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.poll();
            ans.add(treeNode.val);
            if (treeNode.left != null) {
                deque.add(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.add(treeNode.right);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
