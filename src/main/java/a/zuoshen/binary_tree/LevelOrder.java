package a.zuoshen.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二叉树层序遍历
 * @author: xuefei
 * @date: 2022/07/24 00:25
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = deque.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode treeNode = deque.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
