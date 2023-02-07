package xuefei.done.leetcode.hot_100;

import xuefei.done.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的最大深度   https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @author: xuefei
 * @date: 2022/05/26 23:41
 */
public class MaxDepth {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
